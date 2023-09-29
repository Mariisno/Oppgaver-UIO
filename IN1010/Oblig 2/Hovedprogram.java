public class Hovedprogram {

    public static void main(String[] args) {
        
        //Legemiddel objekt/er:
        Narkotisk morfin = new Narkotisk("morfin", 400, 10, 10);
        Vanedannende valium = new Vanedannende("Valium", 111, 5, 9);
        Vanlig pPiller = new Vanlig("pPiller", 400, 10);

        //Lege objekt/er:
        Leger lege1 = new Leger("Mari");
        
        //Resept objekt/er:
        MilResept milresept = new MilResept(morfin, lege1, 69);
        Blaa_resepter blaaResept = new Blaa_resepter(valium, lege1, 2, 3);
        Presepter reseptP = new Presepter(pPiller, lege1, 69, 5);
        


        System.out.println("Her vil jeg teste legemiddel-klassene:");
        System.out.println(morfin);
        System.out.println(valium);
        System.out.println(pPiller);
        System.out.println();


        System.out.println("Her vil jeg teste resept-klassene:");
        System.out.println(milresept);
        System.out.println(blaaResept);
        System.out.println(reseptP);
        System.out.println();

        System.out.println("Her vil jeg teste lege-klassene:");
        System.out.println(lege1);
    }
}