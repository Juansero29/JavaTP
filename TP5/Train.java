import java.util.LinkedList;

/**
 * Cette classe permet de créer un train
 * Un train peut rouler ou être à l'arrêt, et possède une référence vers une liste de wagons
 * @author De Vries Gerben, Rodriguez Juan
 *
 */

class Train {

	private boolean roule;
	private LinkedList<Wagon> listeDeWagons;

	/**
	 * Construit un train
	 * @param nombreDeWagons son nombre de wagons
	 * @throws Exception si nombreDeWagons est négatif.
	 */
	public Train(int nombreDeWagons) throws Exception {
		if (nombreDeWagons < 0) {
			throw new Exception("Impossible de créer un train possédant un nombre de wagons négatif");
		}
		listeDeWagons = new LinkedList<>();
		for (int i = 0; i < nombreDeWagons; i++) {
			listeDeWagons.addLast(new Wagon(i));
		}
	}

	/**
	 * permet de démarrer le train 
	 */
	public void demarrer() {
		setRoule(true);
	}

	/**
	 * permet d'arrêter le train
	 */
	public void arreter() {
		setRoule(false);
	}

	/**
	 * @return true si le train roule
	 */
	public boolean isRoule() {
		return roule;
	}

	/**
	 * on définit si le train est en train de rouler
	 * @param roule (valeur booléenne)
	 */
	private void setRoule(boolean roule) {
		this.roule = roule;
	}

	/**
	 * Permet à un passager de monter dans le train dans le numero de wagon spécifié
	 * @param numeroWagon 
	 * @param lePassager
	 * @throws Exception le wagon est inexistant ou le train est en train de rouler
	 */
	public void monterDansLeTrain(int numeroWagon, Passager lePassager) throws Exception {
		if (numeroWagon > listeDeWagons.size()) {
			throw new Exception("Impossible d'ajouter un passager à un Wagon inexistant");
		}

		if (!roule) {
			listeDeWagons.get(numeroWagon).ajouter(lePassager);
		} else {
			throw new Exception("Impossible de monter lorsque le train roule. ");
		}
	}

	/** 2ieme version de la méthode monterDansLeTrain
	 * Le passager spécifié tente de monter dans le wagon devant lequel il se trouve, si ce dernier est plein il recherche des places dans tous les wagons du train jusqu'à ce
	 * qu'il trouve une place
	 * 
	 * @param numeroWagon
	 *            le numéro du wagon devant lequel se trouve le passager
	 * @param lePassager
	 *            le passager
	 * @throws Exception le wagon est inexistant, le train est en train de rouler ou le train est totalement rempli
	 */
	public void monterDansLeTrain2(int numeroWagon, Passager lePassager) throws Exception {
		if (numeroWagon > listeDeWagons.size()) {
			throw new Exception("Impossible d'ajouter un passager à un Wagon inexistant");
		}

		if (roule) {
			throw new Exception("Impossible de monter lorsque le train roule. ");
		}

		if (listeDeWagons.get(numeroWagon).isPlein()) {
			for (int i = 0; i < listeDeWagons.size(); i++) {
				if (!listeDeWagons.get(i).isPlein()) {
					try {
						listeDeWagons.get(i).ajouter(lePassager);
						System.out.println("Le wagon devant lequel se trouvait le passager était plein"
								+ ",\n il a donc continué de marcher sur le quai jusqu'à trouver une place\n ");
						return;
					} catch (Exception e) {
						throw e;
					}
				}
			}
			throw new Exception("Le passager n'a pas trouvé de place de disponible dans le train");

		}

	}

	/**
	 * Permet à un passager de descendre du train
	 * @param lePassager
	 * @throws Exception le passager est inexistant dans le train ou le train est en train de rouler.
	 */
	public void descendreDuTrain(Passager lePassager) throws Exception {
		if (!roule && !listeDeWagons.isEmpty()) {
			boolean succes = listeDeWagons.remove(lePassager);
			if (!succes) {
				throw new Exception("Le passager que vous souhaitez faire descendre du train n'existe pas !");
			}
		} else {

			throw new Exception("Impossible de descendre du train lorsqu'il roule ! ");
		}
	}

	/**
	 * Décrit le train
	 */
	public String toString() {
		String msg = "Train compose de " + listeDeWagons.size() + " wagons :";
		for (Wagon w : listeDeWagons) {
			if (w != null) {
				msg += "\n" + w.toString();
			}
		}
		return msg;
	}

	/**
	 * Permet de déplacer un passager au wagon suivant
	 * @param lePassager
	 * @throws Exception il n'y a pas de prochain wagon.
	 */
	public void deplacerAuWagonSuivant(Passager lePassager) throws Exception {

		Wagon w = lePassager.getWagonActuel();
		int posWagon = listeDeWagons.indexOf(w);

		if (posWagon + 1 == listeDeWagons.size()) {
			throw new Exception("Il n'y a pas de prochain wagon !");
		}

		Wagon wSuivant = listeDeWagons.get(posWagon + 1);

		try {
			wSuivant.ajouter(lePassager);
			w.enlever(lePassager);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Permet de déplacer un passager au wagon précéndent
	 * @param lePassager
	 * @throws Exception Il n'existe pas de wagon précédent
	 */
	public void deplacerAuWagonPrecedent(Passager lePassager) throws Exception {

		Wagon w = lePassager.getWagonActuel();
		int posWagon = listeDeWagons.indexOf(w);

		if (posWagon == 0) {
			throw new Exception("Il n'y a pas de  wagon precedent !");
		}

		Wagon wPrecedent = listeDeWagons.get(posWagon - 1);

		try {
			wPrecedent.ajouter(lePassager);
			w.enlever(lePassager);
		} catch (Exception e) {
			throw e;
		}
	}

}
