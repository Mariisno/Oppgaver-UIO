package obliger;

class Person {

    private Bil3 bilen;
    private String navn;

    public Person(Bil3 bilObjekt1, String navn) {
        this.bilen = bilObjekt1;
        this.navn = navn;

    }

    public void skriv_ut_bilnummer() {
        System.out.println("Eieren til bilen er: " + navn);
        System.out.println("Bilen sitt nummer er: " + bilen.hentNummer());

    }

}
