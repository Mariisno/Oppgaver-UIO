public class Vanedannende extends Legemiddel {

    public final int styrke;

    public Vanedannende(String navn, int pris, int virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke; //Ny variabel
    }
    
    @Override //Override toString
    public String toString() {
        return super.toString() + "\nStyrke: " + styrke;
    }
}
