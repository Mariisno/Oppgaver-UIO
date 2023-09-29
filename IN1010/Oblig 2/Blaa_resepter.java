public class Blaa_resepter extends Resepter {

    int nyPris;

    public Blaa_resepter (Legemiddel legemiddel, Leger utskrivendeLege, int pasientID, int reit) {
        super(legemiddel, utskrivendeLege, pasientID, reit);

        int pris = legemiddel.hentPris();
        int nyPris = pris/4; //25%
        nyPris = (int)Math.round(nyPris);
        legemiddel.settNyPris(nyPris);

    }
    
    @Override
    public String farge () {
        return "blaa";
    }

    @Override
    public int prisAaBetale() {
        return legemiddel.hentPris();
    }
}
