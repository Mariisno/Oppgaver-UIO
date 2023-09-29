public class Rutenett {
    
    private int antKolonner;
    private int antRader;
    public Celle[][] rutene;

    /*Oppgave 1: Konstroktør
    Tar imot dimensjonene på rutenettet (parameter)
    Lager parameteres som instansvariablene antRader og antKolonner
    */
    //Oppgave 2: 2D-Array
    public Rutenett(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutene = new Celle[antRader][antKolonner];

    }

    /*Oppgave 3: oppretter en instans av klassen Celle
    Legger inn cellen på en plass i 2D-arrayen basert på de to parametrene rad og kolonne
    Hver celle i rutenetter skal ha 1/3 sjanse for å være levende når den legges inn i rutenettet
    Her kan man bruke metoden settLevende fra klassen Celle
    */
    public void lagCelle (int rad, int kol) {

        Celle nyCelle = new Celle();

        //Lager levende celle om det er 1/3 sjanse
        // if (Math.random() <= 0.333) {
        //     nyCelle.settLevende();
        //     rutene[rad][kol] = nyCelle;
        // }
        // else {
        //     rutene[rad][kol] = nyCelle;
        // }
        rutene[rad][kol] = nyCelle;
    }

    /*Oppgave 4: fyllMedTilfeldigeCeller
    Går gjennom hele rutenettet og sørger for at det blir fylt med celler.
    Bruk metoden lagCelle til å opprette cellene.
    Dette rutenettet utgjør utgangspunktet, eller "0-te generasjon" for cellesimuleringen vår
    */

    public void fyllMedTilfeldigeCeller() {
                
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol=0; kol < antKolonner; kol++) {
                this.lagCelle(rad, kol); 
            }
        }
    }

    /* Oppgave 5: Tar imot en celles kordinater (rad og kol) i rutenettet som parameter,
    og retunerer cellen med den gitte posisjonen.
    Hvis en ulovlig rad- eller kolonneindeks er gitt (for lav eller for høy indeks),
    så skal metoden retunere null
    */
    public Celle hentCelle (int Cellerad, int Cellekol) {
        //Her sjekkes det om variabelet er ulovelig:
        if ((Cellerad < 0 ) || (Cellerad >= antRader) || (Cellekol < 0) || (Cellekol >= antKolonner)) { 
        //Denne sjekker at ikke noe er under 0 eller over lengden til radene og kolonnene, ved hjelp av å bruke antKolonner og antRader som forteller hvor lange kolonnene og radene er
            return null;
        }
        else {
            return rutene[Cellerad][Cellekol]; //Retunerer en celle til den gitte posisjonen
        }
    }

    /* Oppgave 6: For å vise frem rutenettet skal du skrive metoden tegnRutenett.
    Denne metoden skal bruke en dobbelt for-løkke for å skrive ut hvert element i rutenettet.
     */
    public void tegnRutenett() {
        //Her går jeg først gjennom radene og lager de, så lager jeg kolonnene med en celle i
        for (int rad = 0; rad < antRader; rad++) {
            System.out.println(); //Her printer jeg ut hver kolonne
            for (int kol=0; kol < antKolonner; kol++) {
                System.out.print(rutene[rad][kol].hentStatusTegn() + " | "); //Her printer man ut hver celle
            } 
        }
    }

    /* Oppgave 7: For å bestemme hvilke celler som skal være levende og død i neste generasjon, trenger vi å vite statusen til hver celles nabo.
    Metoden skal ta imot en celles koordinater (rad og kolonner) -> parameter og sette referanser til alle instanser av klassen Celle som er nabo for den gitte Celle-instansen.
    Hver celle kan ha maksimalt 8 naboer, men celler langs kanten eller i hjørnene har færre.
     */
    public void settNaboer(int CellensRad, int CellensKol) {
        Celle hentaCelle = hentCelle(CellensRad, CellensKol); //Her har jeg henta en celle
        
        for (int rad = -1; rad < 2; rad++) { //Går gjennom -1, 0 og +1 på alle radene
            for (int kol = -1; kol< 2; kol++) { //Går gjennom -1, 0 og +1 på alle kolonnene
                //For loopene sjekker alle mulige "naboer" og sjekker at ingen av de er null eller seg selg
                if ((kol != 0) || (rad != 0)) { //Sjekker om det er samme celle som seg selv, da kan naboen aldri være [0][0] som er det samme som lokasjonen til cella vi henter fra starten
                    if ((hentCelle((CellensRad + rad), (CellensKol + kol)) != null)) {//Denne if-sjekken sjekker om den er utenfor
                        hentaCelle.leggTilNabo(rutene[CellensRad + rad][CellensKol + kol]);
                    }
                }
            }
        }
    }

    /* oppgave 8: Skriv en metode kobleAlleCeller som ved hjelp av en 
    dobbel for-løkke skal kalle på settNaboer for hver plass (rad, kol) i rutenettet.
     */
     public void kobleAlleCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++){
                settNaboer(rad, kol);  //Bruker metoden over for å sette nabo inn i rutenettet så det blir riktig
            }
        }
     }

     /* oppgave 9: Skal retunere antall levende celler i rutenettet.
     Dette kan du enklest gjøre ved å gå gjennom rutenettet og øke en teller for 
     hver levende celle du finner
      */
     public int antallLevende () {
        int levendeCeller = 0;
        //I for-løkka går jeg gjennom alle cellene i rutenettet sjekker om de er levende
        for (int rad = 0; rad < antRader; rad++) {
            for(int kol = 0; kol < antKolonner; kol++) {
                if (rutene[rad][kol].erLevende()) {  //Her sjekker jeg om den er levende
                    levendeCeller++;
                }
            }
        }
        return levendeCeller;
     }


}
    