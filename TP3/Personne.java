/**
 * Permet de créer une personne
 * @author Gerben De Vries, Juan Rodriguez
 */

public class Personne {
	
	/**
	 * Une personne a un nom et un prenom
	 */
	private String nom;
	private String prenom;

	/** Initialise une personne
	 * 
	 * @param nom le nom de cette personne
	 * @param prenom le prenom de cette personne
	 */
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * La personne renvoie des informations la concernant 
	 * @return son nom et son prenom
	 */

	public String toString() {
		return nom + " " + prenom;
	}

}
