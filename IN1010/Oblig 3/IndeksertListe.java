/*
Vi skal nå utvide listen i deloppgave B med muligheten for å indeksere listen,
dvs kunne finne elementer i vilkårlige posisjoner, ikke bare først. Vi definerer
derfor en subklasse med noen flere operasjoner:
 */

class IndeksertListe <E> extends Lenkeliste<E> {

    /*
    Metoden leggTil(int pos,E x) skal sette inn x i listen i posisjon pos der
    0<=pos<=stoerrelse(). Dette betyr at alle elementene lenger ut i listen
    forskyves og heretter får en høyere indeks.
    */
    public void leggTil (int pos, E x) {

        /*
        Er fire forskjellige alternativer man må tenke på:
        1. Hvordan skal den inn om lista er tom
        2. Hvordan skal den inn om det er bare en node
        3. Hvordan skal den inn om noden kommer sist
        4. Hvordan skal den inn om noden kommer mellom to noder.
         */

        //Sjekker om posisjonen er større eller mindre enn lovlig indeks:
        if (pos < 0 || pos > stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }

        Node <E> nyNode = new Node<E>(x);


        //Hvis posisjonen er 0, så vet vi at vi må legge til den nye på starten, da gjør vi det samme som i stabel:

        //Alternativ 1 og 2:
        if (pos == 0) {
            if (start == null) {
                start = nyNode;
             }
             //Må flytte den gammle starten et hakk til høyre
             //LEgge den til om det er en først
             else {
                 Node <E> gammelStart = start; //Lagrer start i en annen variabel
                 start = nyNode; //Setter inn Nynode på start
                 start.neste = gammelStart; 
                 return;
                 }
             }
        //Legge til på slutten -> alternativ 2
        if (pos>stoerrelse()-1) {
            leggTil(x);
            return;
        }
        /*
        Teller gjennom hele lista, når jeg kommer inn på posisjonen, 
        setter jeg den inn og må forandre referansen til den til venstre

        Den til venstre skal ha referanse til den nye og den nye til den til høyre
        */          
        Node <E> temp = start;

        //MÅ ha pos+1 for hvis ikke vil i hoppe ut når den er lik som pos
        //Trenger ikke sjekke 0 for det sjekker over
        //Legge til i midten -> alternativ 4
        for (int i=1; i<pos+1; i++) {
            temp = temp.neste;
            //Skal ha -1 fordi temp er på posisjonen som nyNode skal på
            if (i == pos-1) {
                //Legger inn nyNode inni
                nyNode.neste = temp.neste;
                temp.neste = nyNode;
                
            }
        }
    }
    
    /*
    ● Metoden sett(int pos,E x) skal erstatte elementet i posisjon pos med x.
    Lovlig pos er 0<=pos<stoerrelse().
    */
    public void sett (int pos, E x) {

        //Sjekker ugyldig posisjon
        if (pos < 0 || pos > stoerrelse()-1) {
            throw new UgyldigListeindeks(pos);
        }

        Node <E> temp = start;

        //Når for -loopen er ferdig vil temp være den noden som skal erstattes
        for (int i = 0; i<pos; i++) {
            temp = temp.neste;
        }
        //Bytter ut innholdet
        temp.innhold = x;

    }

    /*
    ● Metoden hent(int pos) skal hente elementet i gitt posisjon der
    0<=pos<stoerrelse(). Elementet skal bli stående i listen.
    */
    public E hent (int pos) {
        
        if (pos < 0 || pos > stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }

        Node <E> hentaNode;

        if (pos == 0) {
            //Hva gjør jeg om det ikke er en node å erstatte?
            if (start == null) {
                hentaNode = start;
                return hentaNode.innhold;
             }
             //Må flytte den gammle starten et hakk til høyre
             else {
                 hentaNode = start; //Setter inn Nynode på start
                 return hentaNode.innhold;
                 }
             }
        /*
        Teller gjennom hele lista, når jeg kommer inn på posisjonen, 
        setter jeg den inn og må forandre referansen til den til venstre

        Den til venstre skal ha referanse til den nye og den nye til den til høyre
        */          
        Node <E> temp = start;

        for (int i=1; i<pos+1; i++) {
            temp = temp.neste;
            if (i == pos) {
                hentaNode = temp;
                return hentaNode.innhold;
                }
            }

        //Må ha null???
        return null;
    }    
    
    /*
    ● Metoden fjern(int pos) skal fjerne elementet i posisjon pos (der
    0<=pos<stoerrelse()) og returnere det. Det innebærer at alle
    elementene lenger ut i listen vil få en lavere indeks.
    */
    public E fjern (int pos) {

        if (pos < 0 || pos > stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }

        //Hvis det er pos = 0 kan jeg bruke fjern fra lenkeliste
        if (pos == 0) {
            return fjern();
        }

        //Bruker denne hvis jeg sletter elementet som er indeks 1
        try {//Må ha try-catch med nullpointerexception i tilfelle innhold == null -> altså ingen node er ved siden av
            if (pos == 1) {
            //Her lagrer jeg indeksen FØR den som skal bli sletta
            Node <E> sletta = start.neste;
            E slettaInnhold = sletta.innhold;

            //Gjør den før sletta sin peker til pekeren til sletta sin peker
            start.neste = sletta.neste;

            return slettaInnhold;} 
            } catch (NullPointerException feil) {
                throw new UgyldigListeindeks(pos);
            }

        //Må gå til posisjonen hvor den skal slettest
        try {
        Node <E> temp = start;
        for (int i=1; i<pos; i++) {
            temp = temp.neste;

            if (i == pos-1) {

                //Her lagrer jeg indeksen FØR den som skal bli sletta
                Node <E> sletta = temp.neste;
                E slettaInnhold = sletta.innhold;

                //Gjør den før sletta sin peker til pekeren til sletta sin peker
                temp.neste = sletta.neste;

                return slettaInnhold;
                }
            } } catch (NullPointerException feil) {
                throw new UgyldigListeindeks(0);
            }
        return null;
        }
}