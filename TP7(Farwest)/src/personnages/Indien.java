package personnages;/* Created by Juansero29 on 3/4/2017 at 23:05. */

public class Indien extends Humain {

    private int nbPlumes;
    private String totem;


    public Indien(String nom, String boisson, String totem) {
        super(nom, boisson);
        this.totem = totem;
    }

    public Indien(String nom) {
        this(nom, "jus de racine", "Coyote");
    }

    public void scalper(VisagePale visagePale) {
        visagePale.etreScalpe();
        nbPlumes++;
        parler("Hahaha! Maintent j'ai " + nbPlumes + " plumes!");
    }

    @Override
    public void sePresenter() {
        super.sePresenter();
        parler("Mon nombre de plumes est: " + nbPlumes);
    }

    @Override
    public void parler(String msg) {
        super.parler(msg + " Ugh!");
    }
}
