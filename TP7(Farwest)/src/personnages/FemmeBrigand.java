package personnages;/* Created by Juansero29 on 3/4/2017 at 23:03. */

public class FemmeBrigand extends Humain implements HorsLaLoi {

    // DONE: Define FemmeBrigand methods, constructor and toString() method. (not said on the PDF)

    public FemmeBrigand(String nom, String boisson) {
        super(nom, boisson);
    }


    @Override
    public void seFaireEmprisonner(Sheriff sheriff) {
        parler("Ah non! Je peux te faire un cadeau si tu m'imprisonnes pas! ");
    }

    @Override
    public void kidnapper(Dame dame) {
        parler("Hahaha! Et toi" + dame.getNom() + " croyais je coûtais que 5 " +
                "euros? Bh non! ");
    }

    @Override
    public float getMiseAPrix() {
        return 500;
    }
}
