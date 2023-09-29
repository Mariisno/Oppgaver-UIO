import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.PrintWriter;


//Programmet skal holde styr på flere lister
//Den skal ha en liste for legemidler, en for resepter, en for leger og en for pasienter.

public class Legesystem {

    public IndeksertListe<Pasient> pasienter = new IndeksertListe<>(); 
    public IndeksertListe<Legemiddel> legemidler = new IndeksertListe<>();
    public IndeksertListe<Leger> leger = new IndeksertListe<>(); 

    //E1: leser fil og deretter oppretter objekter for elementene i filen og deretter legger objektene inn i dei tilhorende listene
    public Legesystem (String fil) throws FileNotFoundException {
        Scanner lesFil = new Scanner(new File(fil));

        int teller = 0;

        //Hvis den ikke har har # og teller = tall så er det de forskjellige
        
        //har en while loop som sjekker om linjen starter med hashtag
        //sjekk om det er pasient, legemidler, lege eller resepter

        while (lesFil.hasNextLine()) {
            //Har en if-sjekk for å sjekke om det er pasient, legemidler, leger eller resepter
            String data = lesFil.nextLine();

            char forste = data.charAt(0);

            //Hvis den har # så teller++
            //Hvis teller = 1 pasient, hvis 2 = legemidler...osv
            if (forste == '#') {
                teller++;
             //viss den ikkje starter med hashtag
            }else{
                //Skal splitte alt på mellomrom
                String[] deler = data.split(",");
                

                // //1 = pasient
                if (teller == 1) {
                    String navn = deler[0];
                    Long fnr = Long.parseLong(deler[1]);
                    Pasient pasient = new Pasient(navn, fnr);
                    pasienter.leggTil(pasient);
                }

                //2 = legemidler
                if (teller == 2) {
                    if ( deler[1].equals("narkotisk")){
                        String legemiddelnavn = deler[0];
                        String type = deler[1];
                        int pris = Integer.parseInt(deler[2]);
                        int virkestoff = Integer.parseInt(deler[3]);
                        int styrke = Integer.parseInt(deler[4]);
                        Narkotisk narkotisk = new Narkotisk(legemiddelnavn, pris, virkestoff, styrke);
                        legemidler.leggTil(narkotisk);

                    }else if (deler[1].equals("vanedannende")){
                        String legemiddelnavn = deler[0];
                        String type = deler[1];
                        int pris = Integer.parseInt(deler[2]);
                        int virkestoff = Integer.parseInt(deler[3]);
                        int styrke = Integer.parseInt(deler[4]);
                        Vanedannende vanedannende = new Vanedannende(legemiddelnavn, pris, virkestoff, styrke);
                        legemidler.leggTil(vanedannende);


                    }else{
                        String legemiddelnavn = deler[0];
                        String type = deler[1];
                        int pris = Integer.parseInt(deler[2]);
                        int virkestoff = Integer.parseInt(deler[3]);
                        Vanlig vanlig = new Vanlig(legemiddelnavn, pris, virkestoff);
                        legemidler.leggTil(vanlig);
                    }
                }

                //3 = leger
                if (teller == 3) {
                    String navn = deler[0];
                    String kontrollkode = deler[1];
                    kontrollkode = kontrollkode.trim();
                    if (kontrollkode.equals("0")){
                        Leger lege = new Leger(navn);
                        leger.leggTil(lege);
                    }else{
                        Legespesialist legespesialist = new Legespesialist(navn, kontrollkode);
                        leger.leggTil(legespesialist);
                    }
                }

                //4 = resepter
                if (teller == 4) {

                    //Hvite resepter
                    if (deler[3].equals("hvit")){
                        int legemiddelNummer = Integer.parseInt(deler[0]);
                        String legeNavn = deler[1]; //Bruk denne til å finne legeobjektet
                        int pasientID = Integer.parseInt(deler[2]);
                        int reit = Integer.parseInt(deler[4]);

                        Legemiddel tempLegemiddel = null;
                        for (Legemiddel legemiddel: legemidler) {
                            if (legemiddel.ID == legemiddelNummer) {
                                tempLegemiddel = legemiddel;
                            }
                        }

                        Pasient tempPasient = null;
                        for (Pasient pasient: pasienter) {
                            if (pasient.ID == pasientID) {
                                tempPasient = pasient;
                            }
                        }

                        //Må ta en for loop som går gjennom lege objektene
                        //sammenlig legeNavn med legeobjektet sitt navn
                        Leger tempLege = null;
                        for (Leger lege : leger) {
                            if (legeNavn.equals(lege.hentNavn())) {
                                tempLege = lege;
                            }
                        }
                        tempLege.skrivHvitResept(tempLegemiddel, tempPasient, reit);                        

                    //Blaa resepter
                    }else if (deler[3].equals("blaa")){
                        int legemiddelNummer = Integer.parseInt(deler[0]);
                        String legeNavn = deler[1]; //Bruk denne til å finne legeobjektet
                        int pasientID = Integer.parseInt(deler[2]);
                        int reit = Integer.parseInt(deler[4]);

                        Legemiddel tempLegemiddel = null;
                        for (Legemiddel legemiddel: legemidler) {
                            if (legemiddel.ID == legemiddelNummer) {
                                tempLegemiddel = legemiddel;
                            }
                        }

                        Pasient tempPasient = null;
                        for (Pasient pasient: pasienter) {
                            if (pasient.ID == pasientID) {
                                tempPasient = pasient;
                            }
                        }

                        //Må ta en for loop som går gjennom lege objektene
                        //sammenlig legeNavn med legeobjektet sitt navn
                        Leger tempLege = null;
                        for (Leger lege : leger) {
                            if (legeNavn.equals(lege.hentNavn())) {
                                tempLege = lege;
                            }
                        }
                        tempLege.skrivBlaaResept(tempLegemiddel, tempPasient, reit);
                    }

                    // //Militærresept
                    else if (deler[3].equals("militaer")) {
                        int legemiddelNummer = Integer.parseInt(deler[0]);
                        String legeNavn = deler[1]; //Bruk denne til å finne legeobjektet
                        int pasientID = Integer.parseInt(deler[2]);

                        Legemiddel tempLegemiddel = null;
                        for (Legemiddel legemiddel: legemidler) {
                            if (legemiddel.ID == legemiddelNummer) {
                                tempLegemiddel = legemiddel;
                            }
                        }

                        Pasient tempPasient = null;
                        for (Pasient pasient: pasienter) {
                            if (pasient.ID == pasientID) {
                                tempPasient = pasient;
                            }
                        }

                        //Må ta en for loop som går gjennom lege objektene
                        //sammenlig legeNavn med legeobjektet sitt navn
                        Leger tempLege = null;
                        for (Leger lege : leger) {
                            if (legeNavn.equals(lege.hentNavn())) {
                                tempLege = lege;
                            }
                        }
                        int reit = 0;

                        tempLege.skrivMilResept(tempLegemiddel, tempPasient);
                    }

                    // //p-resept
                    else {
                        int legemiddelNummer = Integer.parseInt(deler[0]);
                        String legeNavn = deler[1]; //Bruk denne til å finne legeobjektet
                        int pasientID = Integer.parseInt(deler[2]);
                        int reit = Integer.parseInt(deler[4]);

                        Legemiddel tempLegemiddel = null;
                        for (Legemiddel legemiddel: legemidler) {
                            if (legemiddel.ID == legemiddelNummer) {
                                tempLegemiddel = legemiddel;
                            }
                        }

                        Pasient tempPasient = null;
                        for (Pasient pasient: pasienter) {
                            if (pasient.ID == pasientID) {
                                tempPasient = pasient;
                            }
                        }

                        //Må ta en for loop som går gjennom lege objektene
                        //sammenlig legeNavn med legeobjektet sitt navn
                        Leger tempLege = null;
                        for (Leger lege : leger) {
                            if (legeNavn.equals(lege.hentNavn())) {
                                tempLege = lege;
                            }
                        }
                        tempLege.skrivPResept(tempLegemiddel, tempPasient, reit);
                    }
                }
            }
        }
        lesFil.close();
    }

    //E3 metoder
    public void skrivUtPasienter () {
        for (Pasient pasient: pasienter) {
            System.out.print(pasient);
        }
    }

    public void skrivUtResepter() {
        for (Leger lege : leger) {
            lege.hentResepter();
        }
    }

    public void skrivUtLegemidler(){
        for (Legemiddel legemidler: legemidler){
            System.out.println(legemidler);
        }
    }
    public void skrivUtLeger(){
        Prioritetskoe<Leger> nyLegeListe = new Prioritetskoe<>();
        for (Leger lege : leger){
            nyLegeListe.leggTil(lege);
        }
        for (Leger lege : nyLegeListe){
            System.out.print(lege);
        }
    }

    //Del E2
    public void kjorSystem() {

        Scanner lokke = new Scanner(System.in);
        System.out.println("Nå kjører systemet:");
        String whileData = "";
        Scanner input = new Scanner(System.in);

        while (!whileData.equals("Q")) {
        
            System.out.println("For oversikt over hele systemet press 1 \nFor å legge til nye elementer i systemet press 2 \nFor å bruke en resept skriv inn 3 \nFor å få frem statestikk skriv 4\nFor aa skrive alle data inn i fil skriv 5  ");
            String data = input.nextLine();

            //Oversikt hele systemet -> for del E3
            if (data.equals("1")) {
                System.out.println("Oversikt hele systemet:");
                this.oversikt();
            }

            //Legge til nye elementer i systemet -> for del E4
            else if (data.equals("2")) {
                System.out.println("Nå legger du inn nye elementer:");
                this.leggTil();
            }

            //Bruke en resept -> for del E5
            else if (data.equals("3")) {
                System.out.println("Nå skal du bruke en resept");
                System.out.println("Hvilken pasient vil du se resepter for? Skriv inn pasient ID.");
                System.out.println(pasienter);
                int nummer = input.nextInt();
                
                while (nummer > pasienter.stoerrelse()-1 || nummer < 0) {
                    System.out.println("Ugyldig indeks!");
                    break;
                }
                
                while (nummer <= pasienter.stoerrelse()-1 && nummer >= 0) {
                    if (pasienter.hent(nummer).resepter.stoerrelse() == 0) {
                        System.out.println("Ingen resepter aa se!");
                        break;
                    }
                    System.out.println("Hvilken resept vil du bruke? Skriv inn tall:");
                    System.out.println("");
                    pasienter.hent(nummer).skrivUtResepter();
                    int reseptnr = input.nextInt();
                    this.brukResept(nummer, reseptnr);
                    break;
                    

                }
                
            }

            //Skriv ut forskjellige former for statistikk -> for del E6
            else if (data.equals("4")) {
                System.out.println("Her er statistikk:");
                this.statistikk();
            }

            //Skriv all data til fil
            else if (data.equals("5")) {
                System.out.println("Skriv inn all data til fil:");
                this.dataTilFil();
            }

            else {
                System.out.println("Du skrev et ugyldig input");
            }

            System.out.println("Vil du fortsette systemet? For å fortsette trykk enter\nTrykk Q for å avslutte");

            whileData = lokke.nextLine();

            }

        lokke.close();
        input.close();
        //Avslutter programmet helt
        System.exit(0);
        
    }

    //Del E3 -> Linn
    public void oversikt() {
        System.out.println("\nPasienter: ");
        this.skrivUtPasienter();
        
        System.out.println("\nLegemidler: ");
        this.skrivUtLegemidler();

        System.out.println("\nLeger: ");
        this.skrivUtLeger();

        System.out.println("\nResepter: ");
        this.skrivUtResepter();
    }

    //Del E4 -> Mari
    public void leggTil() {

        Scanner lokke = new Scanner(System.in);
        System.out.println("Nå kjører legg til programmet:");
        String whileData = "";
        Scanner input = new Scanner(System.in);

        while (!whileData.equals("Q")) {
        
            System.out.println("For å legge til lege skriv lege\nFor å legge til pasient skriv pasient\nFor å legge til resept skriv resept\nFor å legge til legemiddel skriv legemiddel");
            String data = input.nextLine();

            if (data.equals("lege")) {
                this.leggTilLege();
            }
    
            else if (data.equals("pasient")) {
                this.leggTilPasient();
            }
    
            else if (data.equals("resept")) {
                this.leggTilResept();
            }
    
            else if (data.equals("legemiddel")) {
                this.leggTilLegemiddel();
            }
    
            else {
                System.out.println("Du skrev inn ugyldig input");
            }
            
            System.out.println("Vil du fortsette å legge til flere? For å fortsette trykk enter\nTrykk Q for å avslutte");
            whileData = lokke.nextLine();
            }
    } 

    public void leggTilLege() {
        String navn = "";
        String svar = "";
        String kode = "";

        Scanner data = new Scanner(System.in);

        System.out.println("Hva er navnet på legen?");
        navn = data.nextLine();

        System.out.println("Er dette en spesiallege? ja/nei");
        svar = data.nextLine();

        if (svar.equals("ja")) {
            System.out.println("Hva er koden til spesiallegen?");
            kode = data.nextLine();
            Legespesialist nySpessLege = new Legespesialist("Dr. " + navn, kode);
            leger.leggTil(nySpessLege);
        }

        else {
            Leger nyLege = new Leger("Dr. " + navn);
            leger.leggTil(nyLege);
        }
    }

   //OK
   public void leggTilPasient() {
    String navn = "";
    Long fnr;

    Scanner data = new Scanner(System.in);

    System.out.println("Hva er navnet på pasienten?");
    navn = data.nextLine();

    System.out.println("Hva er fødselsnummeret på pasienten? OBS 11 tall");
    fnr = data.nextLong();

    Pasient pasient = new Pasient(navn, fnr);

    pasienter.leggTil(pasient);
}

    //Metoder for legg til resept
    //Sjekker at lege finnes i systemet
    public Leger sjekkLege() {
        Scanner data = new Scanner(System.in);
        Leger tempLege = null;
        String legeNavn = "";
        boolean legesjekk = true;

        while (legesjekk) {
            System.out.println("Hvilken lege skal skrive resepten?");
            this.skrivUtLeger();
            System.out.println("Skriv navnet på en lege");
            legeNavn = data.nextLine();

            //Sjekker at navn finnes
            for (Leger lege: leger) {
                if (legeNavn.equals(lege.navn)) {
                    legesjekk = false;
                    tempLege = lege;
                }
            }
            //Går ut av while
            if (!legesjekk){
                break;
            }
            System.out.println("Du skrev et navn som ikke finnes i systemet");
        }
        return tempLege;
    }

    //Her må jeg gå gjennom lege lista
    //Jeg må sjekke om legen faktisk finnes
    //NB bare spesiallege kan skrive ut narkotiske stoffer!!!!
    public void leggTilResept() {
        Scanner data = new Scanner(System.in);

        //reit
        int reit = 0;
        Scanner dataReit = new Scanner(System.in);
        System.out.println("Hva er reiten til resepten? (oppgi i tall)");
        reit = dataReit.nextInt();

        //Type resept
        String type = "";
        System.out.println("Hvilken type resept vil du skrive ut?\nTast h for hvit, m for militær, p for presept og b for blå");
        type = data.nextLine();

        //Pasient ->
        Pasient tempPasient = null;
        String tekst = "";
        System.out.println("Hvem er resepten til? (pasientnavn)");
        System.out.println("Liste over pasienter:");
        this.skrivUtPasienter();
        tekst = data.nextLine();
        for (Pasient pasient : pasienter) {
            if (tekst.equals(pasient.navn)) {
                tempPasient = pasient;
            }
        }

        //Lege
        Leger lege = sjekkLege();

        //Legemiddel
        Legemiddel tempLegemiddel = null;
        String navnLegemiddel = null;
        boolean sjekk = true;
        while (sjekk) {
            System.out.println("Her er en liste over alle legemidlene:");
            this.skrivUtLegemidler();
            System.out.println("Hva er navnet på legemiddelet du vil gi resept til?");
            navnLegemiddel = data.nextLine();

            for (Legemiddel legemiddel : legemidler) {
                if (navnLegemiddel.equals(legemiddel.navn)) {
                    tempLegemiddel = legemiddel;
                    if (legemiddel instanceof Narkotisk){
                        if (!(lege instanceof Legespesialist)) {
                            System.out.println("Legen er ikke en legespesialist og kan ikke skrive ut denne resepten\nVelg en annen lege");
                            lege = sjekkLege();
                            if (lege instanceof Legespesialist) {
                                sjekk = false;
                            }
                        }
                        else {
                            sjekk = false;
                        }
                    }
                    else {
                        sjekk = false;
                        }
                }
            }
            if (sjekk) {
                System.out.println("Ugyldig navn på legemiddel");
            }
        }

        //Hvit resept
        if (type.equals("h")) {
            lege.skrivHvitResept(tempLegemiddel, tempPasient, reit);
        }

        //Militær
        else if (type.equals("m")) {
            lege.skrivMilResept(tempLegemiddel, tempPasient);
        }

        //Blå
        else if (type.equals("b")) {
            lege.skrivBlaaResept(tempLegemiddel, tempPasient, reit);
        }

        //P-resept
        else {
            lege.skrivPResept(tempLegemiddel, tempPasient, reit);
        }
    }
    
    public void leggTilLegemiddel() {
        //konverter i ein try catch , number.format.Exception
        //del opp programmet 
        String type;
        String pris;  //int
        String navn;
        String virkestoff; //int
        String styrke; //int

        //tekst
        Scanner sc = new Scanner(System.in);

        System.out.println("Hvilken type legemiddel er det: tast inn enten: narkotisk, vanedannende, vanlig");
        type = sc.nextLine();
        System.out.println("SKriver ut type: " +type);
        boolean sjekk= true;
        while (sjekk){
            if (type.equals("narkotisk")|| type.equals("vanedannende") || type.equals("vanlig")){
                sjekk = false;
            }else{
                System.out.println("Ugyldig input");
                System.out.println("Hvilken type legemiddel er det: tast inn enten: narkotisk, vanedannende, vanlig");
                type = sc.nextLine();

            }

        }
        System.out.println("Hvor mye koster legemiddelet?: ");
        pris = sc.nextLine();
        int pris2 = Integer.parseInt(pris);
        while (pris2 < 0){
            System.out.println("Prisen kan ikke vere negativt");
            System.out.println("Hvor mye koster legemiddelet?: ");
            pris = sc.nextLine();
            pris2 = Integer.parseInt(pris);
        }
      
        System.out.println("Hva heter legemiddelet? ");
        navn = sc.nextLine();


       
        System.out.println("Hvor sterk er virkestoffet? oppgi tall");
        virkestoff = sc.nextLine();
        int virkestoff2 =Integer.parseInt(virkestoff);
        while (virkestoff2 <0){
            System.out.println("Virkestoffet kan ikke vere negativt");
            System.out.println("Hvor sterk er virkestoffet? oppgi tall");
            virkestoff = sc.nextLine();
            virkestoff2 =Integer.parseInt(virkestoff);
        }

        if (type.equals("narkotisk")){
            System.out.println("Hvilke styrke har legemiddelet? oppgi tall");
            styrke = sc.nextLine();
            int styrke2 = Integer.parseInt(styrke);
            Narkotisk narkotiskLegemiddel = new Narkotisk(navn, pris2, virkestoff2, styrke2);
            legemidler.leggTil(narkotiskLegemiddel);


        }else if(type.equals("vanedannende")){
            System.out.println("Hvilke styrke har legemiddelet? oppgi tall");
            styrke = sc.nextLine();
            int styrke2 = Integer.parseInt(styrke);
            Vanedannende vanedannendeLegemiddel = new Vanedannende(navn, pris2, virkestoff2, styrke2);
            legemidler.leggTil(vanedannendeLegemiddel);

        }else{
            Vanlig vanligLegemiddel = new Vanlig(navn, pris2, virkestoff2);
            legemidler.leggTil(vanligLegemiddel);

        }
        System.out.println("Du har lagt til legemiddelet " + navn);

}

 

    //Del E5 -> Shannen
    public void brukResept(int pasientID, int reseptnr) {

         //Bruker velger hvilken pasient de vil se resepter for
         for (int i = 0; i <= (pasienter.stoerrelse()-1); i++) {
            // i er posisjon i pasienter lenkelisten
            
            if (pasientID == i) {
                System.out.println("Valgt pasient: " + pasienter.hent(pasientID)); 
                      
            }  
            
        }
       
        // om bruker prøver å hente en resept som er innenfor resepter lenkelisten
        if(reseptnr <= pasienter.hent(pasientID).resepter.stoerrelse()-1) {
            //om reiten ikke kan brukes mer
            
            if (pasienter.hent(pasientID).resepter.hent(reseptnr).hentReit() == 0) {
                System.out.println("Kunne ikke bruke resept paa " + 
                pasienter.hent(pasientID).resepter.hent(reseptnr).hentLegemiddel().navn + " ingen gjenvaerende reit");
            }
            else {
                //bruker resept til den spesifikke pasienten, bruk() er fra Resepter-klassen
                pasienter.hent(pasientID).resepter.hent(reseptnr).bruk();
            
                //skriver ut reseptene slik at bruker kan se hvor mange resepter som er igjen
                pasienter.hent(pasientID).skrivUtResepter();

            }       
            
        }
        // om bruker prøver å hente utenfor resepter lenkelisten
        else {
            System.out.println("Ugyldig indeks!");
        }
    }

    //Del E6 -> Shannen
    public void statistikk() {
        System.out.println("Totalt antall vanedannede legemidler:");
        int vaneantall = 0;

        for (Leger lege : leger ) {
            for (Resepter resept : lege.utskrevneResepter) {
                if (resept.hentLegemiddel() instanceof Vanedannende) {
                    vaneantall++;
                }
            }
        }
        
        System.out.println(vaneantall);

        System.out.println("Totalt antall narkotiske legemidler:");
        int narkantall = 0;
        
        for (Leger lege : leger ) {
            for (Resepter resept : lege.utskrevneResepter) {
                if (resept.hentLegemiddel() instanceof Narkotisk) {
                    narkantall++;
                }
            }
        }
        System.out.println(narkantall);

        Prioritetskoe<Leger> prio = new Prioritetskoe<Leger>();
        
        int antallNarko = 0;
        
        for (Leger lege : leger) {
            antallNarko = 0;
             
            for (Resepter resept : lege.utskrevneResepter) {
                
                    if(resept.hentLegemiddel() instanceof Narkotisk) {
                        antallNarko++;
                        
                        
                    }
                    
                }
                if (antallNarko > 0) {
                    
                    prio.leggTil(lege);

                }    
                
            }
            for (Leger lege : prio) {
                
                System.out.println("Lege navn: " + lege.navn);   
                lege.antallNarkotiske();          
                
            }
            Koe<Pasient> pasliste = new Koe<Pasient>();

            for (Pasient pasient : pasienter) {
                
                
                if (pasient.pasAntallNarkotiske() > 0) {
                    System.out.println("Pasient navn: " + pasient.navn);
                    System.out.println("Antall gyldige narkotiske legemidler: " + pasient.pasAntallNarkotiske());

                }
                
            }
            System.out.println(pasliste);
            
        } 

    

    //Del E7 -> Linn
    public void dataTilFil() {
            //oppretter en ny fil
            try {
                FileWriter file = new FileWriter("nyLegedata.txt");
                 //oppretter en printwriter som vil skrive data til filen
                PrintWriter output = new PrintWriter(file);
    
            //gaar gjennom alle pasienter
            String linjer = "# Pasienter (navn, fnr)\n";
            boolean forste = false;
            for (Pasient pasient : pasienter){
                if (forste == false){
                    linjer += pasient.navn +  "," + pasient.fodselsnummer;
                    forste = true;
                }else{
                    linjer += "\n" + pasient.navn +  "," + pasient.fodselsnummer;
    
                }
    
            }
            output.print(linjer);
            
    
    
            //gaar gjennom alle legemidler
            linjer = "\n# Legemidler (navn, type, pris, virkestoff, [styrke])\n";
            forste = false;
            for (Legemiddel legemiddel : legemidler){
                if (forste == false){
                    if (legemiddel instanceof Narkotisk){
                        Narkotisk narkotisk = (Narkotisk)legemiddel;
                        linjer += narkotisk.navn + ", " +  "narkotisk" + "," +narkotisk.pris + "," + narkotisk.virkestoff +","+  narkotisk.styrke;
                        forste = true;
        
                    }else if (legemiddel instanceof Vanedannende){
                        Vanedannende vanedannende = (Vanedannende) legemiddel;
                        linjer += vanedannende.navn +"," +  "vanedannende" +"," + vanedannende.pris + "," + vanedannende.virkestoff +"," +  vanedannende.styrke;
                        forste = true;
        
                    }else{
                        Vanlig vanlig = (Vanlig)legemiddel;
                        linjer += vanlig.navn + "," + "vanlig" + "," + vanlig.pris + "," + vanlig.virkestoff;
                        forste = true;
                    }
    
                }else{
                    if (legemiddel instanceof Narkotisk){
                        Narkotisk narkotisk = (Narkotisk)legemiddel;
                        linjer += "\n" +narkotisk.navn + ", " +  "narkotisk" + "," +narkotisk.pris + "," + narkotisk.virkestoff +","+  narkotisk.styrke;
        
                    }else if (legemiddel instanceof Vanedannende){
                        Vanedannende vanedannende = (Vanedannende) legemiddel;
                        linjer += "\n" +vanedannende.navn +"," +  "vanedannende" +"," + vanedannende.pris + "," + vanedannende.virkestoff +"," +  vanedannende.styrke;
        
                    }else{
                        Vanlig vanlig = (Vanlig)legemiddel;
                        linjer += "\n" + vanlig.navn + "," + "vanlig" + "," + vanlig.pris + "," + vanlig.virkestoff;
                    }
    
                }
    
            }
            output.print(linjer);   
    
            //gaar gjennom alle leger
            linjer = "\n# Leger (navn, kontrollid / 0 hvis vanlig lege)\n";
            forste = false;
            for (Leger lege : leger){
                if (forste == false){
                    if (lege instanceof Legespesialist){
                        Legespesialist legespesialist = (Legespesialist) lege;
                        linjer += legespesialist.hentNavn() + "," + legespesialist.hentKontrollkode();
                        forste = true;
                    
                    }else{
                        linjer+= lege.hentNavn() + "," + 0;
                        forste = true;
                    }
                }else{
                    if (lege instanceof Legespesialist){
                        Legespesialist legespesialist = (Legespesialist) lege;
                        linjer += "\n" + legespesialist.hentNavn() + "," + legespesialist.hentKontrollkode();
                    
                    }else{
                        linjer+= "\n " +lege.hentNavn() + "," + 0;
                    }
    
                }
          
            }
            output.print(linjer);
        
    
            //gaar gjennom alle resepter
                linjer = "\n# Resepter (legemiddelNummer, legenavn, pasientID, type, [reit])\n";
                forste = false;
                for (Leger lege : leger){
                    for (Resepter resept: lege.utskrevneResepter){
                        if (forste == false){
                            if (resept instanceof MilResept){
                                MilResept millitaer = (MilResept)resept;
                                linjer += millitaer.hentLegemiddel().ID + "," +  millitaer.hentLege().hentNavn() + ","+ millitaer.hentPasient().ID +","+ "militaer";
                                forste = true;
        
                            }else if (resept instanceof Presepter){
                                Presepter p = (Presepter)resept;
                                linjer += p.hentLegemiddel().ID +","+ p.hentLege().hentNavn() +","+ p.hentPasient().ID + ", "+ "p" + "," + p.reit;
                                forste = true;
    
                            }else if(resept instanceof Hvite_resepter){
                                Hvite_resepter hvit = (Hvite_resepter)resept;
                                linjer += hvit.hentLegemiddel().ID + ","+ hvit.hentLege().hentNavn() +"," + hvit.hentPasient().ID +","+  hvit.farge() + "," +hvit.reit;
                                forste = true;
        
                            }else{
                                Blaa_resepter blaa = (Blaa_resepter) resept;
                                linjer += blaa.hentLegemiddel().ID + "," + blaa.hentLege().hentNavn() + "," + blaa.hentPasient().ID +","+ blaa.farge() +","+ blaa.reit;
                                forste = true;
                            }
    
                        }else{
                            if (resept instanceof MilResept){
                                MilResept millitaer = (MilResept)resept;
                                linjer += "\n" +millitaer.hentLegemiddel().ID + "," +  millitaer.hentLege().hentNavn() + ","+ millitaer.hentPasient().ID +","+ "militaer";
                            
        
                            }else if (resept instanceof Presepter){
                                Presepter p = (Presepter)resept;
                                linjer += "\n" + p.hentLegemiddel().ID +","+ p.hentLege().hentNavn() +","+ p.hentPasient().ID + ", "+ "p" + "," + p.reit;
                               
                            } else if (resept instanceof Hvite_resepter){
                                Hvite_resepter hvit = (Hvite_resepter)resept;
                                linjer += "\n" + hvit.hentLegemiddel().ID + ","+ hvit.hentLege().hentNavn() +"," + hvit.hentPasient().ID +","+  hvit.farge() + "," +hvit.reit;
                         
        
                            } else{
                                Blaa_resepter blaa = (Blaa_resepter) resept;
                                linjer += "\n" + blaa.hentLegemiddel().ID + "," + blaa.hentLege().hentNavn() + "," + blaa.hentPasient().ID +","+ blaa.farge() +","+ blaa.reit;
                               
                            }
    
                        }
                
                    }
                }
            
                output.print(linjer);
                output.close();
                System.out.println("Du har overfort dataen til en ny fil");
    
            } catch (Exception e) {
                e.getStackTrace();
            }

    }
}