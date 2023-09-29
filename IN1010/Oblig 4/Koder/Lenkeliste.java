import java.util.Iterator;

abstract class Lenkeliste <E> implements Liste<E> {
    Node foerste; //foerste peker aka roten/hode
    Node siste; //siste peker
    
    //denne metoden returnerer hvor lang lenkelisten er
    public int stoerrelse() {
        int teller = 0;
        Node midlertidig = foerste;
        while(midlertidig != null) {
            teller++;
            midlertidig = midlertidig.neste;
            
        }
        return teller;
    }

    //legger til sist i listen
    public void leggTil(E x) {
        Node nyNode = new Node(x);
        //hvis det ikke er noe i listen blir det som er lagt inn foerste og siste node
        if (this.foerste == null) { 
            this.foerste = nyNode;
            this.siste = nyNode;
            return;    
           
        }
        //hvis ikke legges det til sist i listen
        else {
            Node midlertidig = foerste;
            //hvis midlertidig sin neste ikke er null
            while (midlertidig.neste != null) {
                //meningen er at man skal gaa videre til man finner siste node
                midlertidig = midlertidig.neste;
            }
            midlertidig.neste = nyNode;
            nyNode.forrige = midlertidig;
            siste = nyNode;
        }

    }

    //henter første i listen
    @Override public E hent() {
        
        return foerste.verdi;
        
    }


    //fjerner første i listen
    @Override public E fjern() throws UgyldigListeindeks {

        //hvis listen er tom
        if (stoerrelse() == 0){
        throw new UgyldigListeindeks(-1);
        }
      
        Node midlertidig = foerste;
      //hvis stoerrelse er 1, er det ingen noder etter det, så setter foerste peker og siste på null
        if (stoerrelse() == 1){
        foerste = null;
        siste = null;
        return midlertidig.verdi;
      }
        
        
        //om det er flere noder i listen, fjernes foerste og setter midlertidig sin neste sin forrige til null
        midlertidig.neste.forrige = null;
        //oppdaterer foerste pekeren til å peke på midlertidig sin neste
        foerste = midlertidig.neste;
        //setter det foerste peker på sin forrige til å peke på null
        foerste.forrige = null;
        return midlertidig.verdi;
     
      
    }

     public String toString() {
        String string = "";

        Node mid = foerste;
        while (mid != null) {
            string += mid.verdi + " ";
            mid = mid.neste;
        }
        return string;
        
    }
    //opprettes en iterator for hver lenkeliste
    public Iterator iterator() {
        return new LenkeListeIterator();
    }

    protected class Node { 

        E verdi;
        Node neste;
        Node forrige;
    
        public Node(E verdi) {
            this.verdi = verdi;
    
        }
        public E hentInfo() {
        return verdi;
    }

    }
    //LenkeListeIterator skal gå gjennom de ulike listene vi lager
    //Siden Node er en indre klasse til Lenkeliste, trengs ikke typeparameter
    public class LenkeListeIterator implements Iterator {
        private Node current = foerste;
        
        //om current ikke er null betyr det at det er en neste
        @Override
        public boolean hasNext() {
            return current != null;  
        }

        @Override
        public E next() {
            //dette blir alltid før current
               Node denne = current;
                //dette blir alltid etter neste
                current = current.neste;
            return denne.verdi;
               
        }
    }
}


