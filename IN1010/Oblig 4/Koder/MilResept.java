public class MilResept extends Hvite_resepter {
    
    public MilResept (Legemiddel legemiddel, Leger utskrivendeLege, Pasient pasient) {
        super(legemiddel, utskrivendeLege, pasient, 3);
        
    }

    @Override
    public int prisAaBetale() {
        return 0;
    }

    @Override
    public String farge() {
        return "militaer";
    }

}
