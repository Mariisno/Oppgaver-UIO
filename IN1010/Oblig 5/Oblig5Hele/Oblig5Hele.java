import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Oblig5Hele {
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        String path = args[0];

/*
Skriv en ny klasse, Oblig5Hele.java der main()-metoden oppretter to Monitor2-objekter, dvs. et
objekt med en beholder for HashMap-er fra personer som har hatt sykdommen, og et objekt med
en beholder for de som ikke har hatt sykdommen.
 */
        SubsekvensRegister regSyke = new SubsekvensRegister();
        SubsekvensRegister regFriske = new SubsekvensRegister();

        Monitor2 mSyke = new Monitor2(regSyke);
        Monitor2 mFriske = new Monitor2(regFriske);

/*
 Deretter opprettes det tråder som leser filer og,
som på samme måte som før, legger resultatet i den ene eller den andre beholderen, avhengig av
om filen er fra en som har hatt sykdommen eller ikke. 
 */

        ArrayList <Thread> traader = new ArrayList<Thread>();

        Scanner lesFil =  new Scanner(new File(path + "/metadata.csv"));

        int tellerSyke = 0;
        int tellerFriske = 0;

        //Går gjennom metadata
        while(lesFil.hasNextLine()) {
            String linje = lesFil.nextLine();

            String[] deler = linje.split(",");

            //SYKE
            if (deler[1].equals("True")) {
                //Lag en ny traad for hver fil
                LeseTrad traad = new LeseTrad(mSyke, path + "/" + deler[0]);
                //Må legge trådene inn i en liste for å kunne kjøre de
                Thread traa = new Thread(traad);
                traader.add(traa);
                traa.start(); //Lager en ny tråd for hver nye linje/fil
                tellerSyke++;
            } 
            //FRISKE
            else {
                //Lag en ny traad for hver fil
                LeseTrad traad = new LeseTrad(mFriske, path + "/" + deler[0]);
                //Må legge trådene inn i en liste for å kunne kjøre de
                Thread traa = new Thread(traad);
                traader.add(traa);
                traa.start(); //Lager en ny tråd for hver nye linje/fil
                tellerFriske++;
            }
        }
        //Må ha join for å starte trådene (?)
        for (Thread traa : traader) {
            traa.join();
        }

        final int ANT_TRAADER = 8;

        //Må være -1 for det skal være en fil igjen i arraylisten
        CountDownLatch latchSyke = new CountDownLatch(tellerSyke-1);
        CountDownLatch latchFriske = new CountDownLatch(tellerFriske-1);

        //flettetråder for syke
        Thread[] sykeFlettetrader = new Thread[ANT_TRAADER];

        for (int i = 0; i<ANT_TRAADER; i++) {
            FletteTrad nyFlette = new FletteTrad(mSyke, latchSyke);

            Thread ny = new Thread(nyFlette);
            sykeFlettetrader[i] = new Thread(nyFlette);
            ny.start();
        }

        for (Thread traa: sykeFlettetrader) {
            traa.join();
        }

        Thread[] friskeFlettetrader = new Thread[ANT_TRAADER];

        for (int i = 0; i<ANT_TRAADER; i++) {
            FletteTrad nyFlette = new FletteTrad(mFriske, latchFriske);

            Thread ny = new Thread(nyFlette);
            friskeFlettetrader[i] = new Thread(nyFlette);
            ny.start();
        }

        for (Thread traa: friskeFlettetrader) {
            traa.join();
        }

        //Hvis jeg ikke har latch så vil main-tråden bli ferdig før de andre trådene
        latchFriske.await(); //Venter på at alle trådene er ferdig

        latchSyke.await(); //Venter på at alle trådene er ferdig


        //Tror det funker til hit

/*
Resultatet er nå at vi har to Monitor2 objekter der vi kan hente ut en HashMap fra hver, én
HashMap med subsekvenser fra personer som har vært smittet og én HashMap med subsekvenser
fra friske personer.
 */

 /*
Den enkle metoden går ut på å skrive ut alle
subsekvenser der antall forekomster hos personer med viruset er mye høyere enn antall
forekomster hos personer som ikke har hatt viruset.
  */

        Subsekvens temp = null;
        int hoyestForskjell = 0;

        for (HashMap <String, Subsekvens> friskHash :regFriske.ordbokListe )  {
            for (HashMap<String, Subsekvens> sykHash : regSyke.ordbokListe ) {
                for (Subsekvens sykSub : sykHash.values()) {
                    for (Subsekvens friskSub : friskHash.values()) {

                        if (!friskHash.containsKey(sykSub.hentSubsekvens())) {
                            //Sjekker det som IKKE er i friskhash
                            if (sykSub.antforekomster() > 6) {
                                System.out.println("Subsekvens " + sykSub + "Forekommer mer enn 7 ganger mer hos syke enn friske");
                            }
                            int forskjell = sykSub.antforekomster() + 1; //+1 for den er 0 forekomster i frisk
                            if (forskjell > hoyestForskjell) {
                                temp = sykSub;
                                hoyestForskjell = forskjell;
                            }
                        }
                        //Sjekker det som er i begge
                        if (sykSub.hentSubsekvens().equals(friskSub.hentSubsekvens())) {
                            //Skriv ut alle subsekvenser osm forekommer minst 7 ganger lant de som har hatt viruset
                            if (sykSub.antforekomster() > friskSub.antforekomster()+6) {
                                System.out.println("Subsekvens " + sykSub + "Forekommer mer enn 7 ganger mer hos syke enn friske");
                            }
                            int forskjell = sykSub.antforekomster() - friskSub.antforekomster();
                            if (forskjell > hoyestForskjell) {
                                temp = sykSub;
                                hoyestForskjell = forskjell;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Høyest forekomst: " + temp);
    }
}