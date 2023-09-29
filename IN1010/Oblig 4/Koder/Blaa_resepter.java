public class Blaa_resepter extends Resepter {

    protected int nyPris;

    public Blaa_resepter (Legemiddel legemiddel, Leger utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);

        int pris = legemiddel.hentPris();
        int nyPris = pris/4; //25%
        nyPris = (int)Math.round(nyPris);
    }
    
    @Override
    public String farge () {
        return "blaa";
    }

    @Override
    public int prisAaBetale() {
        return nyPris;
    }
}
