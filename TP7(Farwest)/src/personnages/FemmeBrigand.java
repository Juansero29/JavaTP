package personnages;/* Created by Juansero29 on 3/4/2017 at 23:03. */

public class FemmeBrigand extends Humain implements HorsLaLoi {

    // TODO: Define Ripou's methods, constructor and toString() method. (not said on the PDF)

    public FemmeBrigand(String nom, String boisson) {
        super(nom, boisson);
    }


    @Override
    public void seFaireEmprisonner(Sheriff sheriff) {

    }

    @Override
    public void kidnapper(Dame dame) {

    }

    @Override
    public float getMiseAPrix() {
        return 0;
    }
}
