package personnages;

public class Dame extends Humain implements VisagePale {

    private String couleurRobe;
    private boolean captive;

    public Dame(String nom, String boisson, String couleurRobe) {
        super(nom, boisson);
        this.couleurRobe = couleurRobe;
    }

    public Dame(String nom) {
        this(nom, "lait", "rouge passion");
    }

    public String getCouleurRobe() {
        return couleurRobe;
    }

    public void setCouleurRobe(String couleur) {
        this.couleurRobe = couleur;
        parler("Regardez ma nouvelle robe" + couleur + " !");
    }

    public boolean isCaptive() {
        return captive;
    }

    void seFaireKidnapper(HorsLaLoi horsLaLoi) {
        parler("AHHHHHHHHHH AU SECOURS !!!");
        captive = true;
    }

    void seFaireLiberer(Cowboy cowboy) throws IllegalStateException {
        if (!captive) {
            throw new IllegalStateException("Cette dame est déjà libérée");
        }
        parler("Merci de m'avoir sauvé gentil Cowboy.");
        captive = false;
    }

    @Override
    public String getNom() {
        return "Miss " + super.getNom();
    }

    @Override
    public void sePresenter() {
        super.sePresenter();
        parler(" J'aime ma robe couleur " + couleurRobe);
    }

    @Override
    public void etreScalpe() {
        parler("Aïe! Ma tête! ");
    }
}
