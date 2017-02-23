/**
 * @author Gerben De Vries
 * @author Juan Rodriguez
 * @version 1.0.0
 */

package applications;

public class Telephone {
    /**
     *
     */
    private String numeroAComposer;
    private boolean isDecroche;
    private boolean etatCommunication;


    /**
     * Déclanche l'action de 'télephoner' en affichant un message correspondant à la situation courrante comme suit:
     * <p>
     * - S'il y a pas de numéro auquel on peut téléphoner, on affiche le message 'Aucun numéro à appeler'.
     * - Si le telephone n'est pas decroché, on affiche le message 'Impossible de telephoner'.
     * - Si aucune de ces conditions est vraie, on affiche le message 'Communication en cours avec le numéro' suivi du numéro correspondant.
     */

    private void telephoner() {
        if (numeroAComposer == null) {
            System.out.println("Aucun numéro à appeler");
        } else if (!isDecroche) {
            System.out.println("Impossible de telephoner.");
        } else {
            System.out.println("Communication en cours avec le numéro " + numeroAComposer);
        }
    }

    /**
     * Décroche le téléphone.
     * <p>
     * Cette méthode décroche le télephone. S'il y a un numéro à composer, elle active l'état de communication. Après, elle fait appel à la méthode telephoner.
     *
     * @see #telephoner()
     */

    public void decrocher() {
        isDecroche = true;
        if (numeroAComposer != null) {
            etatCommunication = true;
        }
        telephoner();
    }

    /**
     * Raccroche le téléphone.
     * <p>
     * Cette méthode change les différents états du téléphone suivant la logique d'un téléphone raccroché.
     * - Un téléphone raccroché n'est pas decroché.
     * - Un téléphone raccroché n'est pas en communication.
     * - Un téléphone raccroché n'a pas de numéro à composer.
     */

    public void raccrocher() {
        isDecroche = false;
        etatCommunication = false;
        numeroAComposer = null;
    }

    /**
     * Rajout au téléphone un número à composer seulement si le téléphone n'est pas décroché.
     *
     * @param numero Contient le numéro qui sera ajouté pour la variable numéroAComposer (utilisé potentiellement pour téléphoner)
     * @see #numeroAComposer
     * @see #telephoner()
     */
    public void composer(String numero) {
        if (!isDecroche) {
            numeroAComposer = numero;
        }
    }

}
