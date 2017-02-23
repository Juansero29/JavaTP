import java.util.Random;

public class Ecran {


    private Ampoule[][] daleGraphique;
    private int nombreDeLignes;
    private int nombreDeColonnes;

    public Ecran(int nbLignes, int nbColonnes) throws Exception {

        if (nbLignes * nbColonnes < 0) {
            throw new Exception("Le nombre d'ampoules n'est pas positif");
        }

        nombreDeLignes = nbLignes;
        nombreDeColonnes = nbColonnes;

        daleGraphique = new Ampoule[nbLignes][nbColonnes];

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                daleGraphique[i][j] = new Ampoule();
            }
        }


    }

    public boolean toutAllumer() {

        if (daleGraphique == null) {
            return false;
        }

        boolean succes = true;
        for (Ampoule[] a : daleGraphique) {
            for (Ampoule b : a) {
                if (succes) {
                    succes = b.allumer();
                } else {
                    b.allumer();
                }
            }
        }
        return succes;
    }

    public void toutEteindre() {

        for (Ampoule[] a : daleGraphique) {
            for (Ampoule b : a) {
                b.eteindre();
            }
        }

    }

    public boolean changerEtat(int indiceLigne, int indiceColonne) throws Exception {

        if (indiceLigne < 0 || indiceLigne >= nombreDeLignes || indiceColonne < 0 || indiceColonne >= nombreDeColonnes) {
            throw new Exception("Les paramètres sont invalides");
        }
        return daleGraphique[indiceLigne][indiceColonne].inverseEtat();

    }

    public void changerAmpoule(int indiceLigne, int indiceColonne, Ampoule autreAmpoule) throws Exception {
        if (indiceLigne < 0 || indiceLigne >= nombreDeLignes || indiceColonne < 0 || indiceColonne >= nombreDeColonnes || autreAmpoule == null || autreAmpoule.isGrillee()) {
            throw new Exception("Les paramètres sont invalides");
        }
        daleGraphique[indiceLigne][indiceColonne] = autreAmpoule;
    }

    public void faireClignoter(int nombreDeFois) {
        Random rand = new Random();
        int x;
        int y;
        int nbAmpoulesInverses;

        for (int j = 0; j < nombreDeFois; j++) {
            nbAmpoulesInverses = rand.nextInt(50);

            for (int i = 0; i < nbAmpoulesInverses; i++) {
                x = rand.nextInt(nombreDeLignes);
                y = rand.nextInt(nombreDeColonnes);

                daleGraphique[x][y].inverseEtat();
            }
        }
    }

    public void dessinerEcran() {
        dessinerBordure();
        for (Ampoule[] a : daleGraphique) {
            for (Ampoule b : a) {
                b.afficherEtat();
            }
            System.out.println();
        }
        dessinerBordure();
    }

    private void dessinerBordure() {
        String s = "";
        for (int i = 0; i < nombreDeColonnes; i++) {
            s += "-";
        }
        System.out.println(s);
    }


}
