    // D2: Klassen Lege skal også kunne holde styr på hvilke resepter den har skrevet ut. Utvid
    // klassen med en referanse IndeksertListe<Resept> utskrevneResepter og funksjonalitet for å
    // hente ut denne listen av resepter.
    

public class Leger implements Comparable<Leger>{
    
    protected String navn;

    public IndeksertListe<Resepter> utskrevneResepter = new IndeksertListe<>(); 

    public Leger (String navn) {
        this.navn = navn;
        }
    
    //D2
    public void hentResepter() {
        for (Resepter resept : utskrevneResepter) {
            System.out.println(resept);
        }
    }
    
    public String hentNavn() {
        return navn;
    }

    public void antallNarkotiske() {
        
        int teller = 0;
        while (teller <= utskrevneResepter.stoerrelse()-1 && utskrevneResepter.stoerrelse() > 0){
            
                if (utskrevneResepter.hent(teller).hentLegemiddel() instanceof Narkotisk) {
                    
                    teller++; 

                }
                else {
                    
                    System.out.println("Antall utskrevne narkotiske legemidler " + teller);
                    return;
                }    
        }
        System.out.println("Antall utskrevne narkotiske legemidler: " + teller);  
    }

    @Override
    public String toString() {
        return navn + "\n";
    }

    // D1: Utvid klassen Lege slik at den implementerer grensesnittet Comparable<Lege> og skriv
    // også metoden compareTo. Leger skal kunne sorteres alfabetisk etter navn, slik at en lege
    // ved navn “Dr. Paus” kommer før (altså er mindre enn) “Dr. Ueland”.
    
    @Override
    public int compareTo(Leger annenLege) {
        //< 0
        if (this.navn.compareTo(annenLege.hentNavn()) < -1) {
            return -1;
        }
        // > 0
        if (this.navn.compareTo(annenLege.hentNavn()) > 1) {
            return 1;
        }
        return 0;
    }


    // D3 (for grupper, men anbefalt for alle): Klassen Lege skal ha metoder for å opprette
    // instanser av de fire Resept-klassene man kan lage instanser av (hvit resept, p-resept,
    // millitærresept og blå resept). Når et resept-objekt opprettes, skal det legges inn i listen over
    // legens utskrevne resepter før en referanse til objektet returneres.


    public Hvite_resepter skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UgyldigListeindeks {
        if (legemiddel instanceof Narkotisk) {
            System.out.println("Legemiddelet er narkotisk og må være blaa resept");
            return null;
        }
        else {
        Hvite_resepter hvit = new Hvite_resepter(legemiddel, this, pasient, reit);
            utskrevneResepter.leggTil(hvit);
            pasient.leggTilResepter(hvit);
            return hvit; }
    }

    public MilResept skrivMilResept (Legemiddel legemiddel, Pasient pasient) throws UgyldigListeindeks {
        if (legemiddel instanceof Narkotisk) {
            System.out.println("Legemiddelet er narkotisk og må være blaa resept");
            return null;
        }
        else {    
        MilResept mil = new MilResept(legemiddel, this, pasient);
                utskrevneResepter.leggTil(mil);
                pasient.leggTilResepter(mil);
                return mil; }
    }

    public Presepter skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UgyldigListeindeks {
        if (legemiddel instanceof Narkotisk) {
            System.out.println("Legemiddelet er narkotisk og må være blaa resept");
            return null;
        }
        else {
            Presepter pResept = new Presepter(legemiddel, this, pasient, reit);
            utskrevneResepter.leggTil(pResept);
            pasient.leggTilResepter(pResept);
            return pResept;
        }
    }

    public Blaa_resepter skrivBlaaResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UgyldigListeindeks {
        if (! (legemiddel instanceof Narkotisk)) {
            System.out.println("Legemiddelet er ikke narkotisk");
            return null;
        }
        if (! (this instanceof Legespesialist) ) {
            System.out.println("Du er ikke en spesiallege");
            return null;
        }

        else {
            Blaa_resepter blaa = new Blaa_resepter(legemiddel, this, pasient, reit);
            utskrevneResepter.leggTil(blaa);
            pasient.leggTilResepter(blaa);
            return blaa;
        }
        }

    public void leggTilResepter(Resepter resept) {
        utskrevneResepter.leggTil(resept);
    }
}
