public abstract class Resepter {

    //Konstroktøren er lik som på vanlig


    //Hvordan jeg får ny ID:
    public final int ID;
    public static int IDteller; //Denne teller

    protected Legemiddel legemiddel;
    protected Leger utskrivendeLege;
    protected Pasient pasient;
    protected int reit; //Antall ganger igjen av resept, hivs 0 = ugyldig


    public Resepter (Legemiddel legemiddel, Leger utskrivendeLege, Pasient pasient, int reit) {
        this.ID = IDteller++; //Her vil hvert Resepter få en ny ID
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasient = pasient;
        this.reit = reit;
    }

    public int hentId () {
        return ID;
    }

    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }

    public Leger hentLege() {
        return utskrivendeLege;
    }

    public Pasient hentPasient()  {
        return pasient;
    }

    public int hentReit() {
        return reit;
    }

    public boolean bruk() {
        //Først sjekkes det om den er 0, så hvis den ikke er 0 blir det -1 på reit.
        if (reit <= 0 ) {
            return false;
        }
        else if ((reit - 1) > -1) {
            reit--;
            return true;
        }
        return false; //Må ha denne på slutten hvis ikke så funker det ikke, men denen har ingen funksjon
    }

    abstract public String farge(); //Denne må være tom, for den må implementeres i sub

    abstract public int prisAaBetale();

    @Override
    public String toString() {
        return "Resept ID: " + ID + "\nInfo om legemiddel: " + legemiddel + "\nGitt fra lege: " + utskrivendeLege + " \nDin pasient er: " + pasient + "\nDu kan bruke den " + reit + " ganger til" + "\n" + "Resepten har farge:" + farge() + " Ny pris å betale:" + prisAaBetale() + "\n";
    }



}