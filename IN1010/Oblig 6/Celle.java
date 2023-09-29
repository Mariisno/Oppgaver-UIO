import java.awt.*;
import javax.swing.*;

public class Celle extends JButton {

    //Må være public for at de kan testes:
    private boolean levende = false; //Cellen er død
    private Celle naboer[] = new Celle[8]; //variabel for naboer -> plass til 8 Celler
    private int antNaboer = 0; //angir nåværende antall naboer -> initieres til 0
    private int antLevendeNaboer = 0; // Sjekker hvor mange som er levende -> starter også på 0

    //Konstroktøren, oppgave 1:
    public Celle() {
        //Trenger ikke variabler her for de er over
    }

    //Oppgave 2: Setter statusen til cellen
    public void settDoed() {
        levende = false;
    }

    public void settLevende() {
        levende = true;
    }

    //Oppgave 3: metode som skal retunere cellens status -> true=levende, false!=levende
    public boolean erLevende() { //Må ha boolean for å ha riktig return type. om return er boolean må jeg ha boolean
        return levende;
    }

    //oppave 4: Skal retunere en char-verdi basert på status
    public char hentStatusTegn() {
        if (levende == true) {
            char tegnLevende = 'O'; //levende
            return tegnLevende;
        }

        else { 
            char tegnDoed = '.'; //Død
            return tegnDoed;
        }
    }

    //Oppgave 5: metode med instans av klassen celle som parameter (nabo)
    //Legger nabo til i arrayen naboer og øker antNaboer
    public void leggTilNabo(Celle nabo) { //Legger til nabo-celle
        antNaboer++; // +1 på naboer

        //Hvordan jeg legger til naboen:
        int lengde = naboer.length; //Her sjekker jeg lengden på arrayen = 8

        //Her vil for-loopen gå gjennom alle elementeene i arrayen
        for (int i = 0; i < lengde; i++) {

            if (naboer[i] == null) { //Hvis elementet er null, som er tom, så vil den legge til naboen
                naboer[i] = nabo;
                break; //Her vil den gå ut av for-loopen, så den ikke legger til nabo på alle nullene, men bare den første den finner
                }
            }
        }
    
    //Oppgave 6:  Oppdatering av statusen for en celle

        //Metode 1: går igjennom naboer og teller antall levende naboer.
        //Svaret skal legges i instansvariabelen antLevendeNaboer
    public void tellLevendeNaboer(){
        int tellerLevende = 0;

        int lengde = naboer.length; //Må ha den på nytt for kan ikke hente den over

        for (int i = 0; i < lengde; i++) {

            if (naboer[i] != null) { //Sjekker om det er en celle der
                if (naboer[i].erLevende()){ //Sjekker om den er levende
                    tellerLevende++;

                }
                }
            }
        antLevendeNaboer = tellerLevende;

    }

        //Metode 2: endrer statusen på cellene, utifra spillets regler
        //Basert på antall levende naboer 
    public void oppdaterStatus(){
        if (levende){ 
                if (antLevendeNaboer < 2) {
                    settDoed();
            }
                if (antLevendeNaboer == 2 || antLevendeNaboer == 3 ) {
                    settLevende();
            }
                else {
                    settDoed();
                }
            }

        else {
            if (antLevendeNaboer == 3) {
                settLevende();
            }
        }
    }
}