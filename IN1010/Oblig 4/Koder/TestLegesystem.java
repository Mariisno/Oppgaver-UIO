import java.io.FileNotFoundException;

public class TestLegesystem {
    public static void main(String[] args) throws FileNotFoundException{
        Legesystem legesystem = new Legesystem("legedata.txt");

            // Denne funker
            // legesystem.skrivUtPasienter();

            // legesystem.skrivUtLeger();

            // legesystem.skrivUtLegemidler();

            // legesystem.skrivUtResepter();


            // Narkotisk narkotisk = new Narkotisk("narko", 3, 5.5, 200);
            // Narkotisk nark = new Narkotisk("narko", 3, 5.5, 200);
            // Legespesialist lege = new Legespesialist("Henrik", "3");
            

            // legesystem.pasienter.hent(2).nyResept("h", narkotisk, lege, 2);
            // legesystem.pasienter.hent(2).nyResept("h", nark, lege, 5);
            // legesystem.pasienter.hent(2).skrivUtResepter();
            
            legesystem.kjorSystem();



    
           
    }
    
    
}
