public class EgenTest {

    public static void main(String[] args) {
        Narkotisk morfin = new Narkotisk("morfin", 400, 10, 20);
        Leger lege1 = new Leger("Anna");
        Pasient pasient1 = new Pasient("Linn", 1111);

        pasient1.skrivUtResepter();

    }  

    
}
