public class SortRute extends Rute {

    SortRute(int radNummer, int kolNummer, Labyrint lab) {
        super(radNummer, kolNummer, lab);
    }

    public String toString() {
        return "#";
    }

    @Override
    public void finn(Rute fra) {
        //Skjer ikke noe hvis den er svart, da skal den ikke få videre
    }
    
}
