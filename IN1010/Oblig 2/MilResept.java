public class MilResept extends Hvite_resepter {
    
    public MilResept (Legemiddel legemiddel, Leger utskrivendeLege, int pasientID) {
        super(legemiddel, utskrivendeLege, pasientID, 3);
        legemiddel.settNyPris(0); //100% rabatt = 0
        
    }

    @Override
    public int prisAaBetale() {
        return 0;
    }

}
