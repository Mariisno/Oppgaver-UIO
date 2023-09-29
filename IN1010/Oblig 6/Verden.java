public class Verden {


   /* Oppgave 1: Lag konstruktøren.
   Her er instansvariablene
   */ 
    private int antRad;
    private int antKol;
    Rutenett rutenett;
    private int genNr = 0;

    public Verden(int antRad, int antKol){ //Konstruktøren
        this.antRad = antRad;
        this.antKol = antKol;
        rutenett = new Rutenett(antRad, antKol); //Lager rutenettet
        rutenett.fyllMedTilfeldigeCeller(); 
        rutenett.kobleAlleCeller();
    }

    //Oppgave 2: metoden tegner rutenettet og skriver ut generasjonsnummeret og antlevende celler
    public void tegn() {
        rutenett.tegnRutenett();
        System.out.println();
        System.out.println("Generasjonsnummer er: " + genNr);
        System.out.println("Antall levende celler: " + rutenett.antallLevende());
    }

    /*Oppgave 3: Skal gjøre tre ting
    1. går gjennom alle celler i rutenettet og telle og oppdatere antall levende naboer for hver celle
    2. Gå gjennom alle celler i rutenettet på nytt og oppdaterer status (dvs. om den er levende eller død) på hver celle
    3. husk å oppdatere telleren for antall generasjoner
    */
    public void oppdatering() {

        //1. her oppdateres naboen, man går inn i rutenettet og henter hver celle:
        for (int rad = 0; rad < antRad; rad++) {
            for (int kol = 0; kol < antKol; kol++){
                rutenett.hentCelle(rad, kol).tellLevendeNaboer();
                //Bruker hentCelle for å få tak i riktig celle
            }
        }

        //2. Her oppdateres statusen på alle cellene:
        for (int rad = 0; rad < antRad; rad++) {
            for (int kol=0; kol < antKol; kol++) {
                rutenett.hentCelle(rad, kol).oppdaterStatus();
            }
        }

        //3. oppdaterer genNr.
        genNr++;
    }

    public int hentGenNr() {
        return genNr;
    }
}
