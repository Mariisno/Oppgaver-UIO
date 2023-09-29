public class GOLModel {

    private int rad = 20;
    private int kol = 20;
    public Verden verden;

    public void lagVerden() {
        verden = new Verden(rad, kol);
    }

    public int hentRad() {
        return rad;
    }

    public int hentKol() {
        return rad;
    }

    public void oppdaterGOL() {
        verden.tegn();
        verden.oppdatering();
    }
}
