package personnages;

public class Brigand extends Humain implements HorsLaLoi, VisagePale {
    private final static float RECOMPENSE_PAR_FEMME = 242f;
    private String comportement;
    private int nbDamesEnlevees = 0;
    private float recompense;
    private boolean enPrison = false;


    public Brigand(String nom, String boisson, String comportement, float recompense) {
        super(nom, boisson);
        this.comportement = comportement;
        this.recompense = recompense;
    }

    public Brigand(String nom) {
        this(nom, "Tord-Boyaux", "méchant", 100);
    }

    public float getMiseAPrix() {
        return recompense;
    }

    public void kidnapper(Dame dame) {
        parler("Ah ah! " + dame.getNom() + ", tu es mienne désormais! ");
        dame.seFaireKidnapper(this);
        nbDamesEnlevees++;
    }

    public String getNom() {
        return super.getNom() + " le " + comportement;
    }

    public void seFaireEmprisonner(Sheriff sher) {
        parler("Damned, je suis fait! " + sher.getNom() + ", tu m'as eu! ");
        enPrison = true;
    }


    @Override
    public void sePresenter() {
        super.sePresenter();

        parler("J'ai l'air " + comportement + " et " +
                (nbDamesEnlevees > 0 ?
                        "j'ai déjà kidnappé " + nbDamesEnlevees + " dames!" : "Ma tête est mise à prix " + recompense + "$ !")
        );

        parler("Ma tête est mise à prix " + recompense + "$ !");
    }

    @Override
    public void etreScalpe() {
        parler("Aïe! Ma tête! ");
    }
}
