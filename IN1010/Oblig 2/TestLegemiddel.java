public class TestLegemiddel {

    public static void main(String[] args) {
        Narkotisk morfin = new Narkotisk("morfin", 400, 10, 10);
        Vanedannende valium = new Vanedannende("valium", 111, 5, 9);
        Vanlig paracet = new Vanlig("paracet", 30, 200);

        System.out.println("Her skal pris og navn til morfin komme:");
        System.out.println(morfin.hentPris() + " Prisen til " + morfin.hentNavn());

        System.out.println();
        System.out.println("Under skal informasjon om alle legemidlene skrives ut:");
        System.out.println("Skal ha ID 0:"  + morfin);

        System.out.println("Skal ha ID 3: "+ valium);

        System.out.println("Skal ha ID 2:" + paracet);
    }
    
}
