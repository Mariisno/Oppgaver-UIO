public class Stabel <E> extends Lenkeliste<E> {

/*
 En stabel er en liste som fungerer litt spesielt: det siste elementet som er lagt
inn, er alltid det som hentes ut først
 */

/*
C1: Skriv klassen Stabel<E>. Klassen skal arve Lenkeliste<E>, men den
skal redefinere metoden leggTil(E x) slik at nye elementer legges først i
listen.
 */
    @Override
    public void leggTil(E x) {
        Node<E> Nynode = new Node<>(x);
        //Setter den inn på start om det ikke er noe
        if (start == null) {
           start = Nynode;
        }
        //Må flytte den gammle starten et hakk til høyre
        else {
            Node <E> gammelStart = start;
            start = Nynode; //Setter inn Nynode på start
            start.neste = gammelStart; 
            }
        }
    }

/*
C2: Sørg for at listen din kommer gjennom testene i TestStabel.java før du går
videre til Del D
 */
