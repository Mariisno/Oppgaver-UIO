public class Presepter extends Hvite_resepter {

    int nyPris;

    public Presepter (Legemiddel legemiddel, Leger utskrivendeLege, int pasientID, int reit) {
        super(legemiddel, utskrivendeLege, pasientID, reit);
        int pris = legemiddel.hentPris();
        int nyPris = pris - 108;
        if (nyPris < 0) { //Sjekker at pris ikke blir negativ
            nyPris = 0;
        }
        legemiddel.settNyPris(nyPris);
    }

    @Override
    public int prisAaBetale() {
        return legemiddel.hentPris();
    }

}