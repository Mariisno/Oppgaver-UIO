public abstract class Rute {

    int radNummer;
    int kolNummer;

    Labyrint lab;

    //Naboer
    Rute naboNord;
    Rute naboSyd;
    Rute naboVest;
    Rute naboOest;

    Rute [] naboer = new Rute[4]; //4 naboer

    Rute(int radNummer, int kolNummer, Labyrint lab) {
        
        this.radNummer = radNummer;
        this.kolNummer = kolNummer;
        
        this.lab = lab;
    }

    //Ha en leggTilNabo som i game of life så det ikke må gjøres i parameter
    public void leggTilNabo(Rute nabo) { //Legger til nabo-Rute

        //Ha -1 og +1 for å finne de rundt

        //Kan bruke rad/kol nummer
        naboNord = lab.hentRute(radNummer-1, kolNummer);
        naboOest = lab.hentRute(radNummer, kolNummer+1);
        naboVest = lab.hentRute(radNummer, kolNummer-1);
        naboSyd = lab.hentRute(radNummer+1, kolNummer);
        
        naboer[0] = naboNord;
        naboer[1] = naboSyd;
        naboer[2] = naboVest;
        naboer[3] = naboOest;


        // naboNord = lab.rutenett[radNummer-1][kolNummer]; //Nord
        // naboOest = lab.rutenett[radNummer][kolNummer+1]; //Øst
        // naboVest = lab.rutenett[radNummer][kolNummer-1]; //Vest
        // naboSyd = lab.rutenett[radNummer+1][kolNummer]; //Sør
        }

    public abstract void finn (Rute fra); //Rute fra er åpningen den starter på

    //Denne skal kalle på metoden finn i den ruta som ligger på posisjon (rad, kol) i labyrinten
    public void finnUtveiFra(int rad, int kol) { 
        // finn(lab.hentRute(rad, kol));
        finn(null);
    }

    //TEst for å printe ut naboer
    public void printNaboer() {
        System.out.println(naboNord + "Nord");
        System.out.println(naboVest + "Vest");
        System.out.println(naboSyd + "Sør");
        System.out.println(naboOest + "Øst");

    }

}
