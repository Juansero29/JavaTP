/**
 * @author Gerben De Vries
 * @author Juan Rodriguez
 * @version 1.0.0
 */

package applications;

public class Ampoule {

    private boolean allume;
    private int dureeDeVie = 10000;
    //    public boolean grille;

    /**
     * Allume l'ampoule.
     * <p>
     * Cette méthode allume l'ampoule en question si sa durée de vie est superieure à zéro.
     * Si c'est le cas, on l'allume, on diminue sa durée de vie de un et on affiche son état.
     *
     * @see #afficheEtat()
     */
    public void allumer() {
        if (dureeDeVie > 0) {
            dureeDeVie -= 1;
            allume = true;
            afficheEtat();
        }
    }

    /**
     * Éteint l'ampoule.
     * <p>
     * Cette méthode éteint l'ampoule en question. Puis, elle affiche son état.
     *
     * @see #afficheEtat()
     */
    public void eteindre() {
        allume = false;
        afficheEtat();
    }

    /**
     * Affiche un message en fonction de l'état courrant de l'ampoule comme suit:
     * - Si la durée de vie est égale à zéro, on affiche 'L'ampoule est grillée :-('.
     * - Si l'ampoule est allumé, on affiche 'L'ampule est allumée'.
     * - Si l'ampoule est éteinte, on affiche 'L'ampoule est éteinte.
     */

    private void afficheEtat() {
        if (dureeDeVie == 0) {
            System.out.println("L'ampoule est grillée :-(");
        } else if (allume) {
            System.out.println("L'ampoule est allumée");
        } else {
            System.out.println("L'ampoule est éteinte");
        }
    }

    /**
     * Cette méthode définit si l'ampoule est grillée ou pas.
     *
     * @return boolean
     * Le boléen retourné est vrai si elle est grillée (sa durée de vie est égale à zéro), faux si c'est pas le cas.
     * @see #dureeDeVie
     */
    public boolean isGrille() {
        return dureeDeVie == 0;
    }
}
