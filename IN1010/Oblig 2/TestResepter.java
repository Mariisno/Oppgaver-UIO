public class TestResepter {
    
    public static void main(String[] args) {
        Narkotisk morfin = new Narkotisk("morfin", 400, 10, 10);
        Vanedannende valium = new Vanedannende("Valium", 111, 5, 9);
        Vanlig pPiller = new Vanlig("pPiller", 400, 10);

        Leger lege1 = new Leger("Mari");

        MilResept milresept = new MilResept(morfin, lege1, 69);
        Blaa_resepter blaaResept = new Blaa_resepter(valium, lege1, 2, 3);
        Presepter reseptP = new Presepter(pPiller, lege1, 69, 5);

        System.out.println("Tester metoder i superklassen resepter:");
        System.out.println("Test hentId\nForventer ID 0: " + milresept.ID);
        System.out.println("Forventer ID 2: " + blaaResept.hentId());
        System.out.println();
        System.out.println("Test hentLegemiddel \nForventer info om legemiddelet: " + blaaResept.hentLegemiddel());
        System.out.println();
        System.out.println("Test hentLege \nForventer Mari: " + blaaResept.hentLege());
        System.out.println();
        System.out.println("Test pasientID \nForventer 69: " + milresept.hentPasientID());
        System.out.println();
        System.out.println("Test hentReit \nForventer 3: " + milresept.hentReit());
        System.out.println();
        milresept.bruk(); //Blir 2
        System.out.println("Test Bruk \nForventer true:" + milresept.bruk()); //Blir 1 -> siste true
        System.out.println("Forventer true: " + milresept.bruk());
        System.out.println("Forventer false: " + milresept.bruk());
        System.out.println();
        System.out.println("Tester farge\nForventer hvit: " + milresept.farge());
        System.out.println("Forventer blaa: " + blaaResept.farge());
        System.out.println();
        System.out.println("Tester prisAaBetale: \nForventer 0: " + milresept.prisAaBetale());
        System.out.println("Forventer 27: " + blaaResept.prisAaBetale());
        System.out.println("Forventer forventer 292: " + reseptP.prisAaBetale());

        System.out.println();

        System.out.println("Test toString: \nForventer info om resepten: \n" + milresept);
        System.out.println();
        System.out.println(reseptP);


    }
}
