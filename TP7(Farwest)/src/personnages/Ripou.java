package personnages;

/* Created by Juansero29 on 3/4/2017 at 22:59 at 22:59. */

public class Ripou extends Humain implements HorsLaLoi {

    // DONE(?) : Define Ripou's methods, constructor and toString() method. (not said on the PDF)
    public Ripou(String nom, String boisson) {
        super(nom, boisson);
    }

    @Override
    public void seFaireEmprisonner(Sheriff sheriff) {
        parler("Ah non!");
    }

    @Override
    public void kidnapper(Dame dame) {
        parler("T'es mienne maintenant " + dame.getNom() + "!");
    }

    @Override
    public float getMiseAPrix() {
        return 200;
    }

    @Override
    public String getNom() {
        return super.getNom();
    }
}
