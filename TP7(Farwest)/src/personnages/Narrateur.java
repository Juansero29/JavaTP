package personnages;/* Created by Juansero29 on 3/4/2017 at 23:33. */

public class Narrateur extends Humain {

    public Narrateur(String nom) {
        super(nom, "kasteel rouge");
    }

    @Override
    public void parler(String texte) {
        super.parler(texte + "(dit l'histoire...)\n" + "-----------------\n\n");
    }

}
