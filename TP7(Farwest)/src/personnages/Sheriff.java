package personnages;

public class Sheriff extends Cowboy {

    private static final String ATTITUDE = "honnête";
    private int nbBrigandsCoffres;

    public Sheriff(String nom, String boisson) {
        super(nom, boisson, ATTITUDE);
    }

    public Sheriff(String nom){
        this(nom, "Vin");
    }

    public void coffrer(Brigand brigand) {
        parler("Au nom de la loi, je vous arrète" + brigand.getNom() + "!");
        brigand.seFaireEmprisonner(this);
    }

    public void rechercherUnBrigand(Brigand brig) {
        System.out.println("OYEZ OYEZ BRAVE GENS!! " + brig.getMiseAPrix() +
                "$ à qui arrêtera " + brig.getNom() + " mort ou vif!!");
    }

    @Override
    public void sePresenter() {
        super.sePresenter();
        parler("J'ai coffré " + nbBrigandsCoffres + " brigands.");
    }
}
