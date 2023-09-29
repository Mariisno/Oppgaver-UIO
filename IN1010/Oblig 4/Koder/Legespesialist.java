public class Legespesialist extends Leger implements Godkjenningsfritak {

    protected String kontrollkode;

    public Legespesialist (String navn, String kontrollkode) {
        super(navn);
        this.kontrollkode = kontrollkode;
    }

    @Override
    public String hentKontrollkode() {
        return kontrollkode;
    }

    @Override
    public String toString() {
        return super.toString();
    }


    
}
