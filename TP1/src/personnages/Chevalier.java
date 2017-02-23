package personnages;

/**
 * @author Gerben De Vries
 * @author Juan Rodriguez
 * 
 */

public class Chevalier {

	String titre;
	int ptsDeVie;
	int puissArme;
	int puissBouclier;

	/**
	 * Initialise un Chevalier.
	 * 
	 * @param titre
	 *            le nom du chevalier.
	 * @param bouclier
	 *            la puissance du bouclier.
	 * @param arme
	 *            la puissance de son arme.
	 */

	public Chevalier(String titre, int bouclier, int arme) {
		this.titre = titre;
		this.puissBouclier = bouclier;
		this.puissArme = arme;
		this.ptsDeVie = 10;
	}

	/**
	 * Le chevalier se présente.
	 */

	public void sePresenter() {
		System.out.println("--" + titre + "-- pour vous servir.");
		System.out.println("\tpuissance de mon arme: " + puissArme);
		System.out.println("\tpuissance de mon bouclier: " + puissBouclier);
		System.out.println("\tmes points de vie: " + ptsDeVie);
	}

	/**
	 * Le chevalier subit une attaque.
	 * 
	 * @param forceAttaque
	 *            la force de l'attaque que subit ce chevalier.
	 */

	public void subirAttaque(int forceAttaque) {
		if (forceAttaque > this.puissBouclier) {
			ptsDeVie -= (forceAttaque - puissBouclier);
			System.out.println("Le chevalier a Ã©tÃ© touchÃ© !\n" + " ses nouveaux pv sont : " + this.ptsDeVie);
		} else {
			System.out.println("L'attaque est manquÃ©e !");
		}
	}

}
