/**
 * programme principale permettant de tester miticuleusement la classe Voiture.
 * 
 * @author carine simon, de vries gerben, rodriguez juan
 *
 */
public class TestVoitureMeticuleux {
	public static void main(String[] args) {
		TestVoitureMeticuleux t = new TestVoitureMeticuleux();

		System.out.printf("--testInitialisation : ");
		t.testInitialisation();
		System.out.println("ok");
		System.out.printf("--testDemarrer : ");
		t.testDemarrer();
		System.out.println("ok");
		System.out.printf("--testAccelerer : ");
		t.testAccelerer();
		System.out.println("ok");
		System.out.printf("--testFreiner : ");
		t.testFreiner();
		System.out.println("ok");
		System.out.printf("--testMonterEnVoiture : ");
		t.testMonterEnVoiture();
		System.out.println("ok");		
		
		System.out.printf("--testDescendreDeVoiture : ");
		t.testDescendreDeVoiture();
		System.out.println("ok");

		// A COMPLETER :

	}

	/**
	 * Permet de tester l'initialisation de la voiture à sa création Elle doit
	 * être éteinte, de vitesse nulle et avec aucun passager.
	 */
	private void testInitialisation() {
		Voiture v = new Voiture("rouge", 180, 4);
		if (v.isAllume()) {
			System.out.println("\n PROBLEME : la voiture devrait être initialisée éteinte");
			System.exit(1);
		}
		verifValeurVitesse(v, 0, "\n PROBLEME : la voiture devrait avoir une vitesse nulle à l'initialisation");
		if (v.getNbPassagers() != 0 || v.getNbPlacesRestantes() != 4) {
			System.out.println(
					"\n PROBLEME : la voiture devrait être initialisée sans passagers et avec 4 places restantes");
			System.exit(1);
		}
	}

	/**
	 * test unitaire de la méthode demarrer : permet de vérifier le bon
	 * fonctionnement de cette méthode. une voiture ne peut démarrer s'il n'y
	 * a pas au moins un passager la vitesse de la voiture doit être nulle au
	 * démarage
	 */
	private void testDemarrer() {
		boolean err = false; // va servir à savoir si une exception attendue a
								// bien été levée
		Voiture v = new Voiture("rouge", 180, 5);
		try {
			v.demarrer();
		} catch (Exception e) {
			err = true;
		}
		if (!err) {
			System.out.println("une voiture sans passager n'aurait pas dû démarrer");
			System.exit(1);
		}
		try {
			v.monterEnVoiture(new Personne("Durand", "Pierre"));
			v.demarrer(); // on doit arriver a démarrer normalement
		} catch (Exception e) {
			// ne doit pas arriver
			e.printStackTrace();
		}

		if (!v.isAllume()) {
			System.out.println("\n PROBLEME : on aurait dû pouvoir démarrer la voiture");
			System.exit(1);
		}
		verifValeurVitesse(v, 0, "\n PROBLEME : la vitesse devrait être nulle au démarrage");
	}

	/**
	 * méthode qui permet d'effectuer un test sur la méthode accelerer
	 * 
	 * @param v
	 *            Voiture initialisée sur laquelle on tente d'accélérer
	 * @param valeurAcc
	 *            La valeur de l'accélération
	 * @param messageSiPb
	 *            Le message affiché si l'exception attendue n'a pas été
	 *            levée
	 */
	private void testuAccelerer(Voiture v, int valeurAcc, String messageSiPb) {
		boolean err = false; // va servir à savoir si une exception attendue a
								// bien été levée
		try {
			v.accelerer(valeurAcc);
		} catch (Exception e) {
			err = true;
		}
		if (!err) {
			System.out.println(messageSiPb);
			System.exit(1);
		}

	}

	/**
	 * test unitaire pour la méthode accelerer : permet de vérifier le bon
	 * fonctionnement de cette méthode. la valeur de l'accélération doit
	 * être positive sinon Exception on ne peut accélérer si la voiture n'est
	 * pas allumée sinon Exception on ne peut accélérer si la voiture n'a pas
	 * au moins un passager sinon Exception tenter d'accelerer alors que la
	 * voiture est au max ne fait rien
	 */
	private void testAccelerer() {
		Voiture v = new Voiture("rouge", 180, 2);
		try {
			testuAccelerer(v, 10, "\n PROBLEME : on n'aurait pas dû pouvoir accélérer : personne dans la voiture");
			v.monterEnVoiture(new Personne("Titou", "Baptiste"));
			testuAccelerer(v, 10, "\n PROBLEME : on n'aurait pas dû pouvoir accélérer : voiture éteinte");
			v.demarrer();
			v.accelerer(10); // on doit arriver à accélérer normalement
			if (v.getVitesse() != 10) {
				System.out.println("\n PROBLEME : suite à l'accélération, la vitesse devrait être de 10");
				System.exit(1);
			}
			testuAccelerer(v, -10, "\n PROBLEME : on n'aurait pas dû pouvoir accélérer: valeur négative");

			v.accelerer(200);
			if (v.getVitesse() != 180) {
				System.out.println("\n PROBLEME : suite à l'accélération, la vitesse ne devrait pas dépasser 180");
				System.exit(1);
			}
		} catch (Exception e) {
			// exception anormale
			e.printStackTrace();
		}
	}

	/**
	 * Permet de vérifier que la vitesse de la voiture v donnée est bien d'une
	 * valeur donnée. Si ce n'est pas le cas le message en paramètre est
	 * affiché et le programme s'arête.
	 * 
	 * @param v
	 *            La voiture dont on veut vérifier la vitesse
	 * @param valVitesse
	 *            La valeur attendue de la vitesse
	 * @param messageSiPb
	 *            Le message à afficher si problème
	 */
	private void verifValeurVitesse(Voiture v, int valVitesse, String messageSiPb) {
		if (v.getVitesse() != valVitesse) {
			System.out.println(messageSiPb);
			System.exit(1);
		}
	}

	/**
	 * test unitaire de la méthode freiner : permet de vérifier le bon
	 * fonctionnement de cette méthode. on ne peut freiner qu'en appuyant sur
	 * la pédale => valeur de freinage positive sinon Exception freiner alors
	 * que la voiture ne roule pas (vitesse=0), ne fait rien
	 */
	private void testFreiner() {
		Voiture v = new Voiture("rouge", 180, 2);
		try {
			v.monterEnVoiture(new Personne("Titou", "Baptiste"));
			v.freiner(10);
			verifValeurVitesse(v, 0, "\n PROBLEME : freiner à l'arrêt : la vitesse devrait rester nulle");
			v.demarrer();
			v.accelerer(10);
		} catch (Exception e) {
			// ne doit pas arriver
			e.printStackTrace();
		}

		boolean err = false;
		try {
			v.freiner(-5);
		} catch (Exception e) {
			err = true;
		}
		if (!err) {
			System.out.println("\n PROBLEME : on n'aurait pas dû pouvoir freiner : valeur négative");
			System.exit(1);
		}
		try {
			v.freiner(5);
			verifValeurVitesse(v, 5, "\n PROBLEME :après freinage la vitesse devrait être de 5");
			v.freiner(15);
			verifValeurVitesse(v, 0, "\n PROBLEME :après freinage la vitesse devrait être de 0");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * méthode qui permet d'effectuer un test sur la méthode monterEnVoiture
	 * 
	 * @param v
	 *            Voiture initialisée dans laquelle on tente de monter
	 * @param pers
	 *            La personne qui souhaite monter
	 * @param messageSiPb
	 *            Le message affiché si l'exception attendue n'a pas été
	 *            levée
	 */
	private void testuMonterEnVoiture(Voiture v, Personne pers, String messageSiPb) {
		boolean err = false; // va servir à savoir si une exception attendue a
								// bien été levée
		try {
			v.monterEnVoiture(pers);
		} catch (Exception e) {
			err = true;
		}
		if (!err) {
			System.out.println(messageSiPb);
			System.exit(1);
		}

	}
	
	/**
	 * m�thode qui permet d'effectuer un test sur la m�thode descendreDeVoiture
	 * @param v la voiture initialis�e de laquelle on tentera de faire descendre des personnes apr�s qu'elles soient mont�es.
	 * @param messageSiPb Le message affich� en cas d'exception
	 */
	
	private void testuDescendreDeVoiture(Voiture v, String messageSiPb) {
		boolean err = false; // permettra de savoir si une exception attendue a bien �t� lev�e.
		
		try{
			v.descendreDeVoiture();
		} catch (Exception e){
			err = true;
		} if (!err){
			System.out.println(messageSiPb);
			System.exit(1);
		}
	}

	/**
	 * test unitaire de la méthode monterEnVoiture on ne peut monter dans une
	 * voiture qui roule (vitesse > 0) sinon Exception on ne peut monter dans
	 * une voiture pleine sinon Exception et quand une personne monte en
	 * voiture, son nombre de passagers doit être mis à jour
	 */
	private void testMonterEnVoiture() {
		Voiture v = new Voiture("rouge", 180, 2);
		try {
			v.monterEnVoiture(new Personne("Martin", "Paul"));
			if (v.getNbPassagers() != 1) {
				System.out.println("\n PROBLEME : on devrait maintenant avoir 1 passager");
				System.exit(1);
			}
			v.demarrer();
			v.accelerer(10);
			testuMonterEnVoiture(v, new Personne("Dupond", "Jacques"),
					"PROBLEME : on aurait pas dû pouvoir monter en voiture : la voiture roule");
			v.freiner(10);
			v.monterEnVoiture(new Personne("Titou", "Baptiste"));
			if (v.getNbPassagers() != 2) {
				System.out.println("\n PROBLEME : on devrait maintenant avoir 2 passagers");
				System.exit(1);
			}
			testuMonterEnVoiture(v, new Personne("Titou", "Thomas"),
					"PROBLEME : on aurait pas dû pouvoir monter en voiture : plus de place");
		} catch (Exception e) {
			// ne doit pas arriver
			e.printStackTrace();
		}
	}


	/**
	 * test unitaire de la méthode descendreDeVoitre on ne peut descendre d'une
	 * voiture qui roule (vitesse != 0) sinon Exception on ne peut faire descendre de passagers
	 * d'une voiture vide sinon Exception et quand une personne descend de la
	 * voiture, son nombre de passagers doit être mis à jour
	 */
	
	private void testDescendreDeVoiture() {
		Voiture v = new Voiture("rouge", 180, 2);
		try {
			v.monterEnVoiture(new Personne("Martin", "Paul"));
			v.monterEnVoiture(new Personne("Titou", "Baptiste"));

			v.demarrer();
			v.accelerer(10);
			testuDescendreDeVoiture(v, "PROBLEME : on aurait pas du pouvoir descendre de la voiture : la voiture roule");
			v.freiner(10);
			v.descendreDeVoiture();
			if (v.getNbPassagers() != 1){
				System.out.println("PROBLEME : on devrait maintenant avoir 1 seul passager");
			}
			v.descendreDeVoiture();
			if (v.getNbPassagers() != 0){
				System.out.println("PROBLEME : on devrait maintenant avoir aucun passager restant.");
			}

		} catch (Exception e) {
			// ne doit pas arriver
			e.printStackTrace();
		}
	}

}
