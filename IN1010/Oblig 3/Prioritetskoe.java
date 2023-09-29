public class Prioritetskoe <E extends Comparable<E>> extends Lenkeliste<E>{
    
/*
F1: Skriv klassen Prioritetskoe<E extends Comparable<E>>. Denne
listen arver også fra Lenkeliste<E>, men vi ønsker at listen skal være sortert
og krever derfor at elementer som settes inn, skal være sammenlignbare. 
Kall på leggTil(E x) skal altså sette inn elementer i sortert rekkefølge (fra minst til
størst, der minst ligger først i listen). 

Like elementer (dvs elementer der compareTo(...) returnerer 0) kan ligge i vilkårlig rekkefølge. Når vi bruker
hent()- og fjern()-metodene, skal det minste elementet hentes frem og
eventuelt fjernes.
 */
    @Override
    public void leggTil(E x) {
        /*
        Er fem tilfeller jeg må sjekke for:
        1. om lista er tom
        2. om det er en node i lista
        3. om den nye noden skal legges inn sist
        4. om den nye noden skal mellom to noder
        5. om den nye noden skal inn først
         */

        Node <E> nyNode = new Node(x);
       
        Node <E> minste = start;

        //Kan lage en løkke for å gå igjennom alle nodene
        //Når noden er positiv eller lik en annen node skal jeg legge inn noden før.
        //Må også sjekke om den neste er null, altså om det ikke er flere i lista -> da er det bare å legge til en til høyre
        
        if (start == null) {
            start = nyNode;
            return;
        }

        //Sjekk om den er null, hvis den er null så finnes bare start
        if (minste.neste == null) {
            //Må sammenligne start og den nye

            if (start.innhold.compareTo(x) >= 0) {
                //sjekker om start er større enn den nye
                //Må gjøre som i stabel -> legge inn nye først
                start = nyNode;
                start.neste = minste;
                return;
            }
            else {
                start.neste = nyNode;
                return;
            }
       }

        //Husk å gå ut av løkka!
        while (minste.innhold.compareTo(x) <= 0) {
            //Om jeg får minustall vet jeg at innholdet i start er mindre enn x
            
            //Hvis det nye elementet er likt som et annet
            if (minste.innhold.compareTo(x) == 0) {
                nyNode.neste = minste.neste;
                minste.neste = nyNode;
                return;
            }

            //Hvis den ikke er lik som en annen
            else if (minste.innhold.compareTo(x) > 0) {
                nyNode.neste = minste.neste;
                minste.neste = nyNode;
                return;
            }

            //Må sjekke om neste er null
            if (minste.neste == null) {
                 minste.neste = nyNode;
                //Da settes den inn på slutten
                return;
            }

            //Hvis den skal legges inn mellom to
            if (minste.neste.innhold.compareTo(x) > 0) {

                nyNode.neste = minste.neste;
                minste.neste = nyNode;

                return;
                }

            //Gå gjennom nodene for å finne riktig node

            minste = minste.neste;
        }

        //Om den skal inn først
        if (minste == start) {
            //Samme som stabel
            start = nyNode;
            start.neste = minste;
        }
    }
}