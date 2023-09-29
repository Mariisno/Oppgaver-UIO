public class Pasient {

    //Har final for de skal ikke forandres
    public final String navn;
    public final long fodselsnummer;

    //Hvordan jeg får ny ID:
    public final int ID;
    public static int IDteller; //Denne teller

    public IndeksertListe<Resepter> resepter = new IndeksertListe<>(); 
    
    public Pasient (String navn, long fodselsnummer) {
        this.navn = navn;
        this.fodselsnummer = fodselsnummer;
        this.ID = IDteller;
        IDteller++;
        
    }

    // Legge til ny resept
    // Det skal være mulig å legge til nye resepter.
    public Hvite_resepter nyHvitResept(Legemiddel legemiddel, Leger lege, int reit) throws UgyldigListeindeks {
        Hvite_resepter hvit = new Hvite_resepter(legemiddel, lege, this, reit);
            resepter.leggTil(hvit);
            lege.leggTilResepter(hvit);
            return hvit;
    }

    public MilResept nyMilResept (Legemiddel legemiddel, Leger lege) throws UgyldigListeindeks {
        MilResept mil = new MilResept(legemiddel, lege, this);
            resepter.leggTil(mil);
            lege.leggTilResepter(mil);
            return mil;
    }

    public Presepter nyPResept (Legemiddel legemiddel, Leger lege, int reit) throws UgyldigListeindeks {
        Presepter pResept = new Presepter(legemiddel, lege, this, reit);
            resepter.leggTil(pResept);
            lege.leggTilResepter(pResept);
            return pResept;
    }

    public Blaa_resepter nyBlaaResept (Legemiddel legemiddel, Leger lege, int reit) throws UgyldigListeindeks {
        Blaa_resepter blaa = new Blaa_resepter(legemiddel, lege, this, reit);
            resepter.leggTil(blaa);
            lege.leggTilResepter(blaa);
            return blaa;
        }

    public void leggTilResepter(Resepter resept) {
        resepter.leggTil(resept);
    }

    public int pasAntallNarkotiske() {
        int gyldige = 0;
        int teller = 0;
        while (teller <= resepter.stoerrelse()-1 && resepter.stoerrelse() > 0){
            if (resepter.hent(teller).hentLegemiddel() instanceof Narkotisk) {
                if (resepter.hent(teller).reit != 0) {
                    gyldige++;

                }
            
        }
        teller++;
         
    }
        return gyldige; 
    }

    public String toString() {
        return "Navn: " + navn + " Fodselsnummer: " + fodselsnummer + " PasientID: " + ID + "\n";
    }

    public void skrivUtResepter() {
        int tall = 0;
        for (Resepter res : resepter) {
            System.out.println("Tall - "+ tall + ": " + " Legemiddelnavn: " + res.hentLegemiddel().navn + " Reit: " + res.hentReit());
            tall++;

        }
    }

}