public abstract class Legemiddel {

    //Konstroktøren er lik som på vanlig
    public final String navn;
    public int pris; //KR
    public final int virkestoff; // I mg

    //Hvordan jeg får ny ID:
    public final int ID;
    public static int IDteller; //Denne teller

 
    public Legemiddel (String navn, int pris, int virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.ID = IDteller++; //Her vil hvert legemiddel få en ny ID
    }

    public int hentPris() {
        return pris;
    }

    public void settNyPris(int nyPris) {
        pris = nyPris;
    }

    public String hentNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return "Navn: " + navn + " Pris: " + pris + " virkestoff: " + virkestoff + " ID: " + ID + "\n";
    }



}