package applications;

/**
 * @author Gerben De Vries
 * @author Juan Rodriguez
 * @version 1.0.0
 */


public class NombreComplexe {

    private float mPartieReelle;
    private float mPartieImaginaire;

    /**
     * Initialise un Nombre Complexe
     *
     * @param reel       la partie réelle du nombre complexe.
     * @param imaginaire la partie imaginaire du nombre complexe.
     */


    public NombreComplexe(float reel, float imaginaire) {
        mPartieReelle = reel;
        mPartieImaginaire = imaginaire;
    }


    /**
     * Ajoute deux nombres complexes.
     *
     * @param autreNombre un nombre complexe qui va être ajouté au nombre complexe courrant.
     * @return NombreComplexe
     * le resultat d'ajouter le numero courant avec le numéro passe en paramètres.
     */

    public NombreComplexe ajouter(NombreComplexe autreNombre) {
        return new NombreComplexe(mPartieReelle + autreNombre.mPartieReelle, mPartieImaginaire + autreNombre.mPartieImaginaire);
    }

    /**
     * Multiplie deux nombres complexes.
     *
     * @param autreNombre un nombre complexe qui va être multiplié au nombre complexe courrant.
     * @return NombreComplexe
     * le resultat de multiplier le numero courant avec le numéro passe en paramètres.
     */
    public NombreComplexe multiplier(NombreComplexe autreNombre) {
        float r = autreNombre.mPartieReelle * this.mPartieReelle - autreNombre.mPartieImaginaire * this.mPartieImaginaire;
        float i = (autreNombre.mPartieReelle * this.mPartieImaginaire) + (autreNombre.mPartieImaginaire * this.mPartieReelle);

        return new NombreComplexe(r, i);
    }

    /**
     * Affiche les parties réelle et imaginaire du Nombre Complexe courrant.
     */
    public void afficher() {
        System.out.println("Partie imaginaire: " + mPartieImaginaire + "\nPartie réelle: " + mPartieReelle);
    }
}
