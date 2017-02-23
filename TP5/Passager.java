/**
 * La classe qui permet la création de passagers
 * Un passager a un nom, un prenom et peut se situer actuellement dans un Wagon.
 * @author De Vries Gerben, Rodriguez Juan
 *
 */


class Passager {
	
	private String mNom;
	private String mPrenom;
	private Wagon wagonActuel;

	/**
	 * Constructeur du passager
	 * @param nom le nom du passager
	 * @param prenom le prénom du passager
	 */
	public Passager(String nom, String prenom) {
		mNom = nom;
		mPrenom = prenom;
	}

	/**
	 * décrit un passager
	 */
	public String toString() {
		return mNom + " " + mPrenom;
	}

	/**
	 * 
	 * @return le wagon dans lequel se trouve actuellement le passager
	 */
	public Wagon getWagonActuel() {
		return wagonActuel;
	}

	/**
	 * Définit le wagon du passager
	 * @param wagonActuel le wagon
	 */
	void setWagonActuel(Wagon wagonActuel) {
		this.wagonActuel = wagonActuel;
	}

}
