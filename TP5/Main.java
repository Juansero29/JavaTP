class Main {

	public static void main(String[] oilofNutofCoco) {

		// On initialise 3 passagers
		Passager dupontPierre = new Passager("Dupont", "Pierre");
		Passager durantPaul = new Passager("Durant", "Paul");
		Passager lagardeClaude = new Passager("Laggard", "Claude");

		try {

			// on instancie un nouveau Train qui s'appelle train.
			Train train = new Train(3);

			// On fait monter 3 passagers dans le train
			train.monterDansLeTrain(0, dupontPierre);
			train.monterDansLeTrain(0, durantPaul);
			train.monterDansLeTrain(0, lagardeClaude);

			System.out.println(train + "\n");

			// Certains passagers se déplacent 
			train.deplacerAuWagonSuivant(dupontPierre);
			train.deplacerAuWagonSuivant(lagardeClaude);
			train.deplacerAuWagonSuivant(lagardeClaude);

			System.out.println(train + "\n");

			train.deplacerAuWagonPrecedent(lagardeClaude);
			System.out.println(train + "\n");

			// Test de tous les cas possibles

			System.out.println("TEST DES ERREURS POSSIBLES : \n");
			train.demarrer();
			
			System.out.println("TEST 1");
			try {
				train.descendreDuTrain(lagardeClaude);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("TEST 2");
			try {
				train.monterDansLeTrain(2, new Passager("Dupont", "Jean"));
			} catch (Exception e) {
				e.printStackTrace();
			}

			train.arreter();
			System.out.println("TEST 3");

			try {
				train.descendreDuTrain(lagardeClaude);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("TEST 4");
			try {
				train.monterDansLeTrain(5, new Passager("Dupont", "Jean"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("TEST 5");
			try {
				train.descendreDuTrain(new Passager("Dupont", "Jean"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("TEST 6");

			try {
				train.deplacerAuWagonPrecedent(durantPaul);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("TEST 7");

			try {
				train.deplacerAuWagonSuivant(lagardeClaude);
				train.deplacerAuWagonSuivant(lagardeClaude);

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("TEST 8");

			try {
				Train vapeur = new Train(-10);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("TEST 9");

			for (int i = 1; i < 22; i++) {
				try {
					System.out.println("Passager n°"+i+" tente de monter ...");
					train.monterDansLeTrain(0, new Passager("Jean", "Pierre"));
					System.out.println("Passager n°"+i+" monté avec succès ...");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("\n\nTest de la nouvelle méthode monterDansLeTrain : \n");
			
				try {
					System.out.println("le passager tente de monter ...");
					train.monterDansLeTrain2(0, new Passager("Jean", "Jacques"));
					System.out.println("le passager est monté avec succès ...");
					System.out.println(train);
				} catch (Exception e) {
					e.printStackTrace();
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
