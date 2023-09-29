import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.ArrayList;

/*
Opg. 9
 Skriv trådklassen FletteTrad som går i løkke og for hvert gjennomløp henter ut to HashMap-er
fra et monitor-objekt av klassen Monitor2, slår HashMap-ene sammen og legger resultatet
tilbake i monitoren. Først når alle HashMap-ene er flettet til én HashMap, terminerer disse
trådene. Antall tråder av trådklassen FletteTrad skal være en konstant i programmet ditt som du
kan sette til 8. 
 */

public class FletteTrad implements Runnable {

    //Pass på å ha Monitor2!
    Monitor2 monitor;

    private final CountDownLatch latch;

    //Countdownlatch på ant_filer -1 -> tell gjennom linjer i metadata
    public FletteTrad (Monitor2 monitor, CountDownLatch latch) {
        this.monitor = monitor;
        this.latch = latch;
    }

    @Override
    public void run() {

        HashMap<String, Subsekvens> nyHash;
        while (monitor.storrelse() > 1) {

            try {
                ArrayList <HashMap<String, Subsekvens>> toHashMaps = monitor.hentToHashmapper();
                if (toHashMaps.size() > 1) { //Må sjekke om det faktisk er noen elementer i lista med hashmapper, at den ikke er tom
                    HashMap<String, Subsekvens> hashMap0 =  toHashMaps.remove(0);
                    HashMap<String, Subsekvens> hashMap1 =  toHashMaps.remove(0);
    
                    nyHash = SubsekvensRegister.slaaSammen(hashMap0, hashMap1);
                    monitor.settInn(nyHash);
                    latch.countDown(); //Teller ned latchen helt på slutten
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
