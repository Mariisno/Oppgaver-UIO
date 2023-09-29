public class Hvite_resepter extends Resepter {
    
    public Hvite_resepter(Legemiddel legemiddel, Leger utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public String farge() {
        return "hvit";
    }

    @Override
    public int prisAaBetale() {
        return 0; //Setter denne til 0 så jeg kan override den senere i subklassen
    }
} 
