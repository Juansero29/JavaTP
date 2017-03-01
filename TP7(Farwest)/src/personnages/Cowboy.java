package personnages;

/*Created by Juansero29 on 3/1/2017 at 21:09. */
public class Cowboy extends Humain {
    private int popularite = 0;
    private String attitude;

    public Cowboy(String nom, String boisson, String attitude) {
        super(nom, boisson);
        this.attitude = attitude;
    }

    public Cowboy(String nom) {
        super(nom);
        attitude = "vaillant";
    }

    public void liberer(Dame dame) {
        super.parler("Je suis arrivé au secours, ma cherie inferieuràtrois");
        try {
            dame.seFaireLiberer(this);
        } catch (IllegalStateException i) {
            i.printStackTrace();
            parler("QUOI!? Tu m'as trahie!");
        }
        popularite++;
    }

    public void tirer(Brigand brigand) {
        System.out.println("Le" + attitude + " " + super.getNom() + "tire sur " + brigand.getNom() + ".\nPAAN!!");
        super.parler("Prends ça, rascal!");
    }

    @Override
    public void sePresenter() {
        System.out.println(super.getNom());
    }

}