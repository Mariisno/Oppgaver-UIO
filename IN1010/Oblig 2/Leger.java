public class Leger {
    
    public String navn;

    public Leger (String navn) {
        this.navn = navn;
        }

    public String hentNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn;
    }
    
}
