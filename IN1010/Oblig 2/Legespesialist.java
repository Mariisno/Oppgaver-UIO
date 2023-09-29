public class Legespesialist extends Leger implements Godkjenningsfritak {

    String kontrollkode;

    public Legespesialist (String navn, String kontrollkode) {
        super(navn);
        this.kontrollkode = kontrollkode;
    }

    @Override
    public String hentKontrollkode() {
        return kontrollkode;
    }


    
}
