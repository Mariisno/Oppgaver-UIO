import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Labyrint {

    int antRad;
    int antKol;
    Labyrint lab;

    Rute[][] rutenett;
    

    Labyrint(String fil) throws FileNotFoundException { //Parameter er fil

        lab = this;

        //Først gå gjennom filen
        //første linje er rad/kol
        //Hvis ruten er # så er Rute svart
        //Hvis rute er . så er Rute hvit

        //Lage en rute når rutene settes inn
        //Ha parameter med det som trengs

        Scanner lesFil = new Scanner(new File(fil));

        int rad = 0; //Teller for å se hvor ruten er`?

        while (lesFil.hasNextLine()) {
            String data = lesFil.nextLine();
            
            //Husk trim for å få vekk alt på sidene?
            //Bruk charAt for å få hver char ???

            data.trim(); //Tar vekk whitespace

            //For å få rad og kol:
            if (data.charAt(0) != '.' && data.charAt(0) != '#') {

                //Kunne gjort dette mye lettere med strip av mellomrommet!!!

                String [] deler = data.split(" "); //Bruker strip her
                

                //DET UNDER FUNKER IKKE OM rad og kol er mer enn to tegn!
                //Char gir ut unicode, så må gjøre det til string først
                // String rader = "" + data.charAt(0);
                // String kolonner ="" + data.charAt(2);

                antRad = Integer.parseInt(deler[0]);
                antKol = Integer.parseInt(deler[1]);

                rutenett = new Rute[antRad][antKol];
            }

            //Ta en for-loop gjennom strengen for å få med alle char
            if (data.charAt(0) == '.' || data.charAt(0) == '#') {

                for (int kol = 0; kol < data.length(); kol++) {

                    //Oversikt hva er hva
                    if (data.charAt(kol) == '#') {
                        SortRute sort = new SortRute(rad, kol, this);
                        rutenett[rad][kol] = sort;
                    }
                    if (data.charAt(kol) == '.') {

                        //Sjekker om det er åpning
                        if (kol == 0 || rad == 0 || kol == antKol-1 || rad == antRad-1) {
                            Aapning aapning = new Aapning(rad,kol,this);
                            System.out.println("asdad");

                            rutenett[rad][kol] = aapning;
                        }   

                        else { //Vanlig hvit
                            HvitRute hvit = new HvitRute(rad, kol, this);
                            rutenett[rad][kol] = hvit;
                        }

                    }
                }
                rad++;
            } //Nå er rutene inni rutenettet, men de har ikke naboer enda

        }
    }

    //Ha en hentRute -> samme som GOL
    public Rute hentRute (int Ruterad, int Rutekol) {
        //Her sjekkes det om variabelet er ulovelig:
        if ((Ruterad < 0 ) || (Ruterad >= antRad) || (Rutekol < 0) || (Rutekol >= antKol)) { 
        //Denne sjekker at ikke noe er under 0 eller over lengden til radene og kolonnene, ved hjelp av å bruke antKolonner og antRader som forteller hvor lange kolonnene og radene er
            return null;
        }
        else {
            return rutenett[Ruterad][Rutekol]; //Retunerer en Rute til den gitte posisjonen
        }
    }

    public void settNaboer() {
        for (int rad = 0; rad < antRad; rad++) {
            for (int kol = 0; kol < antKol; kol++) {
                rutenett[rad][kol].leggTilNabo(hentRute(rad, kol));
            }
        }
    }

    public String toString() {
        //Ha en loop som går igjennom lab og skriver den ut
        //Se på Game of life 
        for (int rad = 0; rad < antRad; rad++) {
            System.out.println();
            for (int kol = 0; kol < antKol; kol++) {
                System.out.print(rutenett[rad][kol]); //Print, ikke println
            }
        }
        return ""; //Har en tom streng fordi den må ha en streng lol
    }
}