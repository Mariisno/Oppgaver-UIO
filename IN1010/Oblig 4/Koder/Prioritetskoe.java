public class Prioritetskoe <E extends Comparable <E>> extends Lenkeliste <E>{


    //overrider leggTil fra Lenkeliste<E>
    @Override public void leggTil(E x) {
        //oppretter node med verdi x av typen E (som kan være hva som helst)
        Node nyNode = new Node(x);

        //om det ikke er noe i lenkelisten
        if (stoerrelse() == 0) {
            foerste = nyNode;
            siste = nyNode;
            return;

        }
        //lager en midlertidig node for å iterere gjennom lenkelisten
        Node midlertidig = foerste;


        //hvis det som blir compared to er større enn, da blir det -1.
        //hvis det som blir compared to er mindre enn, da blir det 1.


        //om midlertidig er større enn nyNode verdi DA skal man legge til før 
        if (nyNode.verdi.compareTo(foerste.verdi) <= 0) {

            nyNode.neste = foerste;
            foerste.forrige = nyNode;
            foerste = nyNode;
            return;
        }

        for (int i = 0; i < stoerrelse(); i++) {
            //den går inn om nyNode.verdi er mindre enn midlertidig.verdi
            if (nyNode.verdi.compareTo(midlertidig.verdi) <= 0) {

                midlertidig.forrige.neste = nyNode;
                nyNode.forrige = midlertidig.forrige;
                nyNode.neste = midlertidig;
                midlertidig.forrige = nyNode;
                return;

            }
            //hvis nyNode.verdi er større enn midlertidig.verdi, da går den til neste node
            midlertidig = midlertidig.neste;
        }

    //legger til slutt
    super.leggTil(x);
    return;

    }
}
