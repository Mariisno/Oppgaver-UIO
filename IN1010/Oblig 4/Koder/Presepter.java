public class Presepter extends Hvite_resepter {

    protected int nyPris;

    public Presepter (Legemiddel legemiddel, Leger utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
        int pris = legemiddel.hentPris();
        int nyPris = pris - 108;
        if (nyPris < 0) { //Sjekker at pris ikke blir negativ
            nyPris = 0;
        }
    }

    @Override
    public int prisAaBetale() {
        return nyPris;
    }

    @Override
    public String farge() {
        return "p";
    }

}