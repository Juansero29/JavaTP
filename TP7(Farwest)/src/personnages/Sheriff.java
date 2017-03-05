package personnages;

public class Sheriff extends Cowboy {

    private static final String ATTITUDE = "honnête";
    private int nbBrigandsCoffres;

    public Sheriff(String nom, String boisson) {
        super(nom, boisson, ATTITUDE);
    }

    public Sheriff(String nom){
        this(nom, "vin");
    }

    public void coffrer(HorsLaLoi bandit) {
        parler("Au nom de la loi, je vous arrète " + bandit.getNom() + "!");
        bandit.seFaireEmprisonner(this);
    }

    public void rechercherUnBrigand(Brigand brig) {
        parler("OYEZ OYEZ BRAVE GENS!! " + brig.getMiseAPrix() +
                "$ à qui arrêtera " + brig.getNom() + " mort ou vif!!");
    }

    @Override
    public void sePresenter() {
        super.sePresenter();
        parler("J'ai coffré " + nbBrigandsCoffres + " brigands.");
    }
}
