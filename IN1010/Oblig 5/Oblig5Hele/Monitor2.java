//Opg. 10
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor2 {

    private Lock laas = new ReentrantLock();
    private SubsekvensRegister reg;

    //Ha condition for når det er mer eller lik to, altså der jeg skal hente to hashmapper
    //Hvis det er mindre enn to hashmapper så må den vente!!!!!!!
    private Condition merEnnEn = laas.newCondition();

    //Når det bare er en hashmap igjen i ordboka
    private Condition bareEn = laas.newCondition();

    public Monitor2(SubsekvensRegister reg) {
        this.reg = reg;
    }

    //Skal ha de samme metodene some subsekvensregister
    public void settInn (HashMap<String, Subsekvens> nyHashMap) {
        laas.lock();

        try {
            reg.settInn(nyHashMap);

            //Signaliserer til alle tråder som venter på "merEnnEn" condition
            if (reg.storrelse() >= 1) {
                merEnnEn.signalAll();
            }
        } finally { laas.unlock(); 
        }
    }

    public HashMap<String, Subsekvens> taUt() throws InterruptedException {
        laas.lock();
        try {
            while (reg.storrelse() == 1) {
                bareEn.await();
            }
            return reg.taUt();
        } finally { laas.unlock();
        }
    }

    public int storrelse() {
        laas.lock();
        try {
            return reg.storrelse();
        } finally { laas.unlock();
        }
    }

    //Her må de ikke være statiske
    public HashMap<String, Subsekvens> lesFil (String fil) throws FileNotFoundException {
        laas.lock();
        try {
            return SubsekvensRegister.lesFil(fil); //pga. den er statisk
        } finally { laas.unlock();}

    }

    public HashMap<String, Subsekvens> slaaSammen(HashMap<String,Subsekvens> hash1, HashMap<String, Subsekvens> hash2) {
        laas.lock();

        try {
            return SubsekvensRegister.slaaSammen(hash1, hash2);
        } finally { laas.unlock();}
    }

/*
Du må lage én metode som henter ut to HashMap-er som skal flettes. Det vil
si at metoden må vente inne i monitoren hvis den ikke inneholder to HashMap-er som kan hentes
ut. Til slutt vil det bare være én HashMap igjen i beholderen – den HashMap-en som er
resultatet av all flettingen. Å identifisere når det bare er én igjen og flettetrådene ikke har mer å
gjøre er en fin utfordring for dine logiske evner.
 */

 //Skal hente to hashmapper, men den må vente når det er mindre enn to hashmapper -> Her må jeg ha conditions
    public ArrayList<HashMap<String, Subsekvens>> hentToHashmapper() throws InterruptedException{
        laas.lock();
        //Hent to med hente metoden
        try {
            //Må ha 0, for jeg må sjekke om størrelsen er 0, for da må jeg vente på nye elementer i lista
            while (reg.storrelse() == 0) {
                merEnnEn.await();
            }
            
            ArrayList<HashMap<String, Subsekvens>> toHashMaps = new ArrayList<>();
            if (reg.storrelse() > 1) { //Må sjekke at det er mer enn 1, hvis ikke får vi out of bounce
                HashMap<String, Subsekvens> tempHash0;
                HashMap<String, Subsekvens> tempHash1;

                tempHash0 = reg.taUt();
                tempHash1 = reg.taUt();

                toHashMaps.add(tempHash0);
                toHashMaps.add(tempHash1);
            }

            //Skjer hvis det bare er en
            if (reg.storrelse() == 1) {
                bareEn.signalAll();
            }

            return toHashMaps;
        }
        finally{ laas.unlock(); }
    }
}
