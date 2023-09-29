import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oblig7 {

    public static void main(String[] args) throws FileNotFoundException {
        Labyrint lab = new Labyrint("labyrinter/" + "2.in");

        System.out.println(lab);

        lab.settNaboer();

        kjor(lab);

    }   

    public static void kjor(Labyrint lab) {
        boolean kjor = true;
        while (kjor) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Skriv inn koordinater <rad> <kolonner> ('-1' for aa avslutte)");
            String koordinater = sc.nextLine();
            if (koordinater.equals("-1")) {
                kjor = false;
                break;
            }
            String [] deler = koordinater.split(" ");
            int forsteKord = Integer.parseInt(deler[0]);
            int andreKord = Integer.parseInt(deler[1]);
    
            System.out.println("Åpninger:");
            if (lab.hentRute(forsteKord, andreKord) instanceof SortRute) {
                System.out.println("Kan ikke starte i sort rute");
            }
            lab.hentRute(forsteKord, andreKord).finnUtveiFra(forsteKord, andreKord);
        }

    }
}
