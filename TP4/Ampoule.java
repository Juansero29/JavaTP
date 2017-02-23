import java.util.Random;


public class Ampoule {


    private boolean allume;
    private int dureeDeVie;

    public Ampoule() {
        Random rand = new Random();
        dureeDeVie = rand.nextInt(25) + 5;
    }

    public boolean allumer() {
        if (dureeDeVie == 0) {
            return false;
        }
        allume = true;
        dureeDeVie--;
        return true;
    }

    public void eteindre() {
        allume = false;
        dureeDeVie--;
    }

    public void afficherEtat() {
        String msg;
        if (allume) {
            msg = "*";
        } else if (dureeDeVie != 0) {
            msg = " ";
        } else {
            msg = ".";
        }
        System.out.print(msg);
    }

    public boolean isGrillee() {
        return dureeDeVie == 0;
    }

    public boolean inverseEtat() {
        if (dureeDeVie == 0) {
            return false;
        }
        allume = !allume;
        dureeDeVie--;
        return true;
    }


}
