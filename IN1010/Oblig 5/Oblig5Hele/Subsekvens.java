//Opg. 1

public class Subsekvens {

    public final String SUBSEKVENS;
    private int ant_forekomster = 1;

    public Subsekvens (String SUBSEKVENS) {
        this.SUBSEKVENS = SUBSEKVENS;
    }

    public String hentSubsekvens() {
        return SUBSEKVENS;
    }

    public String toString() {
        return "(" + SUBSEKVENS + "," + ant_forekomster + ")";
    }

    //Sjekken skjer i Subsekvensregister, må bare kalle på metoden -> MÅ legge til antforekomster fra tidligere
    public void leggTilForekomster(int antall) {
        ant_forekomster += antall;
    }

    //Må finne ant
    public int antforekomster() {
        return ant_forekomster;
    }
}