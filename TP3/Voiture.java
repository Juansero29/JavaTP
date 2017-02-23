/**
 * permet de créer une voiture
 * @author De Vries Gerben, Rodriguez Juan
 */

public class Voiture {

	/**
	 * Une voiture possède une Vitesse maximale, une vitesse, une couleur, un
	 * moteur qui peut être allumé ou éteint, un nombre de places, un nombre de passagers
	 * actuellement dans la voiture, contient un tableau qui référence les
	 * passagers actuellement dans cette voiture.
	 */
	private final int VITESSE_MAX;
	private int vitesse = 0;
	private String couleur;
	private boolean allume = false;
	private int nbPlaces;
	private int nbPassagers = 0;
	private Personne[] passagers;

	/**
	 * Initialise une voiture
	 * 
	 * @param couleur  sa couleur
	 * @param vMax  sa vitesse maximale
	 * @param nbPlaces le nombre de passagers maximum qu'elle puisse contenir
	 */
	public Voiture(String couleur, int vMax, int nbPlaces) {
		this.couleur = couleur;
		VITESSE_MAX = vMax;
		this.nbPlaces = nbPlaces;
		passagers = new Personne[nbPlaces];
	}

	/**
	 * @return la vitesse actuelle de la voiture
	 */
	public int getVitesse() {
		return vitesse;
	}

	/**
	 * définit une nouvelle vitesse à la voiture si celle-ci est positive, et
	 * sachant que celle-ci se limite à la vitesse maximale
	 * 
	 * @param vitesse
	 *            la nouvelle vitesse
	 */
	private void setVitesse(int vitesse) {
		if (vitesse < 0) {
			this.vitesse = 0;
		} else if (vitesse > VITESSE_MAX) {
			this.vitesse = VITESSE_MAX;
		} else {
			this.vitesse = vitesse;
		}
	}

	/**
	 * @return le nombre de passagers actuellement dans le véhicule
	 */
	public int getNbPassagers() {
		return nbPassagers;
	}

	/**
	 * @return le nombre de places restantes dans le véhicule
	 */
	public int getNbPlacesRestantes() {
		return nbPlaces - nbPassagers;
	}

	/**
	 * La voiture accélère
	 * 
	 * @param acceleration
	 *            l'accélération du véhicule
	 * @throws Exception
	 *             Le véhicule est vide, la vitesse d'accélération est vide ou
	 *             le moteur est éteint.
	 */
	public void accelerer(int acceleration) throws Exception {
		if (nbPassagers == 0) {
			throw new Exception("Impossible d'accélérer : La voiture ne contient pas de conducteur");
		}

		if (allume) {
			if (acceleration > 0) {
				setVitesse(vitesse + acceleration);
			} else {
				throw new Exception("La valeur d'acceleration doit Ãªtre positive.");
			}
		} else {
			throw new Exception("La voiture ne peut pas accÃ©lÃ©rer parce qu'elle est Ã©teinte. ");
		}
	}

	/**
	 * La voiture freine
	 * 
	 * @param freinage
	 * @throws Exception
	 *             La voiture ne contient pas de conducteur, ou la valeur de
	 *             freinage est négative
	 */
	public void freiner(int freinage) throws Exception {
		if (nbPassagers == 0) {
			throw new Exception("Impossible de freiner : La voiture ne contient pas de conducteur");
		}
		if (freinage > 0) {
			setVitesse(vitesse - freinage);
		} else {
			throw new Exception("La valeur de freinage doit Ãªtre positive.");
		}
	}

	/**
	 * @return l'état du moteur (éteint/allumé)
	 */
	public boolean isAllume() {
		return allume;
	}

	/**
	 * Démarre la voiture
	 * @throws Exception Le véhicule est vide
	 */
	public void demarrer() throws Exception {
		if (nbPassagers > 0)
			allume = true;
		else
			throw new Exception("La voiture ne contient aucun passager");
	}

	/**
	 * Eteint la voiture
	 * @throws Exception la voiture roule ou elle est vide.
	 */
	public void eteindre() throws Exception {
		if (nbPassagers > 0) {
			if (vitesse == 0) {
				allume = false;
			} else {
				throw new Exception("Une voiture qui roule ne peut pas Ãªtre Ã©teinte. ");
			}
		} else {
			throw new Exception("La voiture ne contient aucun passager");
		}
	}

	/**
	 * Une personne monte dans la voiture
	 * @param p la personne qui monte dans la voiture
	 * @throws Exception la voiture est en train de rouler, la voiture est pleine
	 */
	public void monterEnVoiture(Personne p) throws Exception {
		if (vitesse != 0)
			throw new Exception("Impossible de monter dans la voiture lorsqu'elle est en train de rouler!");
		if (getNbPlacesRestantes() == 0)
			throw new Exception("Impossible de monter, il ne reste plus suffisamment de places !");

		passagers[nbPassagers] = p;
		nbPassagers += 1;
	}

	/**
	 * La derniere personne montée descend de la voiture
	 * @throws Exception la voiture est en train de rouler ou elle est vide.
	 */
	public void descendreDeVoiture() throws Exception {
		if (vitesse != 0)
			throw new Exception("Impossible de descendre de la voiture lorsqu'elle roule!");

		if (nbPassagers == 0) {
			throw new Exception("La voiture ne contient aucun passager");
		}
		passagers[nbPassagers - 1] = null;
		nbPassagers--;
	}

	/**
	 * La voiture renvoie des informations la concernant
	 * @return la couleur de la voiture, l'état de son moteur (éteint / allumé),
	 * sa vitesse, la description de ses passagers si elle en contient.
	 */
	public String toString() {
		String msg = "Voiture " + couleur;
		if (allume) {
			msg += " allumÃ©e ";
		} else {
			msg += " Ã©teinte ";
		}
		if (vitesse == 0)
			msg += "arrÃªtÃ©e.";
		else
			msg += "et roulant Ã  " + vitesse + "km/h.";
		if (nbPassagers == 0)
			return msg + " Aucun passager.";
		else
			msg += " Les passagers sont :";
		for (Personne p : passagers) {
			if (p != null) {
				msg += "\n\t" + p;
			}
		}
		return msg;
	}

}
