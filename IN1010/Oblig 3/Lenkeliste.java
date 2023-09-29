public abstract class Lenkeliste <E> implements Liste<E> { //Husk abstract

   //Dette er en indre klasse (node)
   protected class Node <E> {
      public E innhold; //data
      public Node <E> neste;

      //Konstoktøren
      public Node(E innhold) {
         this.innhold = innhold;
      }

      @Override
      public String toString() {
         return "node " + innhold;
      }
   }

   protected Node <E> start; //Dette er roten
    
   /*
B1: Skriv hele klassen Lenkeliste<E> som implementerer Liste<E> med en
lenket liste. Nye elementer settes inn på slutten av listen og tas ut fra starten
slik at det elementet som ble satt inn først, er det første som blir tatt ut.
Implementer også alle metodene i Liste<E>:
     */

    //toString for å skrive ut det som er inni hver node:
   @Override
   public String toString () {
      String string = "Lenkeliste: ";
      Node<E> node = start;
      while (node != null) {
         string += "\n" + node.toString();
         node = node.neste;
      }
      return string;
   }

     /*
Metoden stoerrelse() skal returnere hvor mange elementer det er i
listen.
      */
   //Iterer gjennom nodene og tell hvor mange node-objekter det er som ikke er tomme
   //Start fra 0
   //Denne blir feil for vil ikke telle riktig på 0!!!!!!
   @Override
   public int stoerrelse() {
      Node<E> node = start;
      int teller = 0;
      while (node != null){
         teller++;
         node = node.neste;
      }
      return teller;
    }

/*
Metoden leggTil(E x) skal legge inn et nytt element; det skal legges sist i
listen.
 */
//Må gå gjennom node-lista og lage en ny node som blir en peker fra den daværende siste noden
//Må endre peker
   @Override
   public void leggTil(E x) {
      Node<E> Nynode = new Node<>(x);
      if (start == null) {
         start = Nynode;
      }
      //Denne legger noden til på slutten
      else {
         Node <E> gammelNode = start;
         while (gammelNode.neste != null) {
         gammelNode = gammelNode.neste;
      }
         gammelNode.neste = Nynode;
      }
   }


/*
● Metoden hent() skal returnere det første elementet i listen, men det skal
ikke fjernes fra listen.
 */
   @Override
   public E hent() {
      return start.innhold;
    }

    /*
● Metoden fjern() skal fjerne det første elementet i listen og returnere det
     */
//Når den fjernes så må alle nodene flyttes, da må den daværende roten fjernes og den neste noden gjøres til roten.
   @Override
   public E fjern () {
      try {
      Node<E> temp = start;
      start = start.neste;
      return temp.innhold;
      } catch (NullPointerException feil) {
         throw new UgyldigListeindeks(0);
      }
   }
}
