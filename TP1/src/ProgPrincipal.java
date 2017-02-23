import personnages.Monstre;
import personnages.Chevalier;

/**
 * @author Gerben De Vries
 * @author Juan Rodriguez
 * 
 */

public class ProgPrincipal {

	/**
	 * Classe qui contient le programme principal.
	 * 
	 * @param args.
	 * 
	 */

	public static void main(String args[]) {

		Monstre globulus = new Monstre("Globulus", 15, 5);
		Chevalier arthur = new Chevalier("Arthur", 10, 8);
		globulus.parler("Tu vas trépasser preux chevalier!!!");
		arthur.sePresenter();
		globulus.attaquer(arthur);
		arthur.sePresenter();
	}
}
