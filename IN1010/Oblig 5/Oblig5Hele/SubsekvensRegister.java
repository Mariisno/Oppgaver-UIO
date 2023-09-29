import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Opg. 2

public class SubsekvensRegister {

    public ArrayList <HashMap<String, Subsekvens>> ordbokListe = new ArrayList<HashMap<String, Subsekvens>>();

    //Legger inn basert på hvor mange subsekvenser filen har
    public void settInn (HashMap<String, Subsekvens> nyHashMap) {
        ordbokListe.add(nyHashMap);
    }

    public HashMap<String, Subsekvens> taUt () {
        //Vil alltid fjerne det første elementet og retunerer det
        return ordbokListe.remove(0);
    }

    public int storrelse() {
        return ordbokListe.size();
    }

    //Opg. 3:
    public static HashMap<String, Subsekvens> lesFil (String fil) {

        //Lager en hashmap for filen/personen som skal leses
        HashMap<String, Subsekvens> ordbok = new HashMap<String, Subsekvens>();

        try (Scanner lesFil = new Scanner(new File(fil))) {
            //Her skal jeg samle subsekvens
            String subsekvens = "";

            //Går gjennom filen
            while (lesFil.hasNextLine()) {
                //Leser en og en linje

                String linje = lesFil.nextLine();

                if (!linje.equals("amino_acid")) {

                    //Må ha -2 for å ikke gå utenfor når strengen ikke er lang nok
                    for (int i = 0; i < linje.length()-2; i++) {
                        //Går fra i til de 3 etter det
                        subsekvens = linje.substring(i, i+3);
                        Subsekvens sub = new Subsekvens(subsekvens);
                        ordbok.put(subsekvens, sub);
                        subsekvens = "";
                    }
                }
            }
            lesFil.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ordbok;
    }

    //Oppgave 4:
    public static HashMap<String, Subsekvens> slaaSammen(HashMap<String,Subsekvens> hash1, HashMap<String, Subsekvens> hash2) {

        //Får gjennom hash1 og legger det til i hash2

        //Må bruke Map.Entry for å få frem både nøkkelen og verdien
        for (Map.Entry<String, Subsekvens> subUt : hash1.entrySet()) {
            String subString = subUt.getKey(); // Her får jeg string, altså nøkkelen som er f.eks abc
            Subsekvens sub = subUt.getValue(); //Her får jeg selve Subsekvensobjektet

            //Hvis den allerede er i mappen vil jeg bare telle den og ikke legge den til
            if (hash2.containsKey(subString)) {
                int ant = hash1.get(subString).antforekomster();
                hash2.get(subString).leggTilForekomster(ant);
                }

            else {
                //Legger de fra hash1 inn i hash2
                hash2.put(subString, sub); 
            }
        }
        return hash2;
    }
}

