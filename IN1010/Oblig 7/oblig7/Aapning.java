public class Aapning extends HvitRute {

  
    Aapning(int radNummer, int kolNummer, Labyrint lab) {
        super(radNummer, kolNummer, lab);
    }


    @Override
    public void finn(Rute fra) {
        System.out.println("(" + radNummer + "," + kolNummer + ")");

        //Må ha denne for om den starter på en åpning så må den sjekke de andre åpningene
        for (int i = 0; i < naboer.length; i++) {
            if (!(naboer[i] == null) && naboer[i] != fra) {
                naboer[i].finn(this);
            }
        }
    }

}
