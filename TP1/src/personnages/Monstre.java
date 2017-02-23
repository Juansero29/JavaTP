package personnages;

/**
 * @author Gerben De Vries
 * @author Juan Rodriguez
 * 
 */

public class Monstre {

	String nom;
	int nbPtsVie;
	int force;

	/**
	 * Initialise un Monstre.
	 * 
	 * @param nom
	 *            Son nom.
	 * @param nbPtsVie
	 *            Son nombre de points de vie .
	 * @param force
	 *            Sa force.
	 */

	public Monstre(String nom, int nbPtsVie, int force) {
		this.nom = nom;
		this.nbPtsVie = nbPtsVie;
		this.force = force;
	}

	/**
	 * Intialise un Monstre à partir de son nom. Les autres champs sont définis
	 * par défaut.
	 * 
	 * @param nom
	 *            Initialise son nom
	 */

	public Monstre(String nom) {
		this.nom = nom;
		this.force = 1;
		this.nbPtsVie = 10;
	}

	/**
	 * Le monstre parle.
	 * 
	 * @param message.
	 */

	public void parler(String message) {
		System.out.println("--" + this.nom + "-- : " + message);
	}

	/**
	 * Le monstre attaque.
	 * 
	 * @param c
	 *            Le chevalier qui est attaqué.
	 */
	public void attaquer(Chevalier c) {
		this.parler(c.titre + " tu vas subir mon attaque!:) ");
		c.subirAttaque(force);
	}

}
