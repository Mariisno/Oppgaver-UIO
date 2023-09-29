public class GameOfLife {


    public static void main(String[] arg) {
        Verden verden = new Verden(5, 5); //Lager verden

        //Går fra 0. til 3. generasjon
        for (int gen = 0; gen < 4; gen++) {
            verden.tegn();
            verden.oppdatering();
        }
    }
}
