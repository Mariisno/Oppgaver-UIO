package obliger;

class BilBruk3 {
    public static void main(String[] args) {
        Bil3 bilObjekt1 = new Bil3("789");
        
        Person personObjekt = new Person(bilObjekt1, "Mari");

        personObjekt.skriv_ut_bilnummer();

    }
}