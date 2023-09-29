public class HvitRute extends Rute {


    HvitRute(int radNummer, int kolNummer, Labyrint lab) {
        super(radNummer, kolNummer, lab);
    }

    public String toString() {
        return ".";
    }

    //Hvis den er hvit kan den gå videre
    //Er BARE rekusjon på hvit, for det er den eneste som kan gå videre!
    //På svart/åpning stopper den!
    @Override
    public void finn(Rute fra) {

        // Rute [] naboer = {fra.naboNord, fra.naboSyd, 
        //                 fra.naboVest, fra.naboOest };

        for (int i = 0; i < naboer.length; i++) {
            if (!(naboer[i] == null) && naboer[i] != fra) {
                naboer[i].finn(this);
            }
        }
    }

    
    
}
