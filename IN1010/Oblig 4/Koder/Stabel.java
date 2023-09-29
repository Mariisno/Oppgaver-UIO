public class Stabel <E> extends Lenkeliste<E>{

    //overrider leggTil slik at det legges til foerst og ikke sist i lenkelisten
    @Override public void leggTil(E x) {
        Node nyNode = new Node(x);

        if (this.foerste == null) {
            this.foerste = nyNode;
            this.siste = nyNode;
            return;    
           
        }
        else {
            //legges til foerst
            Node midlertidig = foerste;
            foerste = nyNode;
            nyNode.neste = midlertidig;
            midlertidig.forrige = nyNode;
            
        }
    }
    
}
