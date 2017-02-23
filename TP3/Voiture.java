/**
 * permet de cr�er une voiture
 * @author De Vries Gerben, Rodriguez Juan
 */

public class Voiture {

	/**
	 * Une voiture poss�de une Vitesse maximale, une vitesse, une couleur, un
	 * moteur qui peut �tre allum� ou �teint, un nombre de places, un nombre de passagers
	 * actuellement dans la voiture, contient un tableau qui r�f�rence les
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
	 * d�finit une nouvelle vitesse � la voiture si celle-ci est positive, et
	 * sachant que celle-ci se limite � la vitesse maximale
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
	 * @return le nombre de passagers actuellement dans le v�hicule
	 */
	public int getNbPassagers() {
		return nbPassagers;
	}

	/**
	 * @return le nombre de places restantes dans le v�hicule
	 */
	public int getNbPlacesRestantes() {
		return nbPlaces - nbPassagers;
	}

	/**
	 * La voiture acc�l�re
	 * 
	 * @param acceleration
	 *            l'acc�l�ration du v�hicule
	 * @throws Exception
	 *             Le v�hicule est vide, la vitesse d'acc�l�ration est vide ou
	 *             le moteur est �teint.
	 */
	public void accelerer(int acceleration) throws Exception {
		if (nbPassagers == 0) {
			throw new Exception("Impossible d'acc�l�rer : La voiture ne contient pas de conducteur");
		}

		if (allume) {
			if (acceleration > 0) {
				setVitesse(vitesse + acceleration);
			} else {
				throw new Exception("La valeur d'acceleration doit être positive.");
			}
		} else {
			throw new Exception("La voiture ne peut pas accélérer parce qu'elle est éteinte. ");
		}
	}

	/**
	 * La voiture freine
	 * 
	 * @param freinage
	 * @throws Exception
	 *             La voiture ne contient pas de conducteur, ou la valeur de
	 *             freinage est n�gative
	 */
	public void freiner(int freinage) throws Exception {
		if (nbPassagers == 0) {
			throw new Exception("Impossible de freiner : La voiture ne contient pas de conducteur");
		}
		if (freinage > 0) {
			setVitesse(vitesse - freinage);
		} else {
			throw new Exception("La valeur de freinage doit être positive.");
		}
	}

	/**
	 * @return l'�tat du moteur (�teint/allum�)
	 */
	public boolean isAllume() {
		return allume;
	}

	/**
	 * D�marre la voiture
	 * @throws Exception Le v�hicule est vide
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
				throw new Exception("Une voiture qui roule ne peut pas être éteinte. ");
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
	 * La derniere personne mont�e descend de la voiture
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
	 * @return la couleur de la voiture, l'�tat de son moteur (�teint / allum�),
	 * sa vitesse, la description de ses passagers si elle en contient.
	 */
	public String toString() {
		String msg = "Voiture " + couleur;
		if (allume) {
			msg += " allumée ";
		} else {
			msg += " éteinte ";
		}
		if (vitesse == 0)
			msg += "arrêtée.";
		else
			msg += "et roulant à " + vitesse + "km/h.";
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
