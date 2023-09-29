public class GOLkontroller {

    public GOLModel model;
    private GOLView view;
    
    public void start() {
        model = new GOLModel();
        view = new GOLView(this);
    }

    public void lagVerden() {
        model.lagVerden();
    }

    public int hentRad(){
        return model.hentRad();
    }

    public int hentKol(){
        return model.hentKol();
    }

    //Oppdaterer, bruk i action
    public void oppdaterGol() {
        model.oppdaterGOL();
    }

}
