import java.util.ArrayList;

/**
 * La classe Wagon permet de créer un wagon,
 * possédant une capacité maximale de passagers, un numéro
 * et une liste de passagers.
 * @author De Vries Gerben, Rodriguez Juan
 *
 */

class Wagon {

	public final static int capacite = 20;
	private int numero;
	private ArrayList<Passager> lesPassagers;

	/**
	 * Permet de construire un Wagon
	 * @param numero le numéro du wagon
	 */
	public Wagon(int numero) {
		this.numero = numero;
		lesPassagers = new ArrayList<>();
	}
	
	/**
	 * @return true si le wagon est plein (cette méthode a été ajoutée pour la fonction monterDansLeTrain2)
	 */
	public boolean isPlein(){
		return lesPassagers.size() == capacite;
	}

	/**
	 * Ajoute un passager au wagon
	 * @param lePassager le passager à ajouter
	 * @throws Exception le wagon est plein.
	 */
	public void ajouter(Passager lePassager) throws Exception{
	if (lesPassagers.size() < 20){
	    lesPassagers.add(lePassager);
	    lePassager.setWagonActuel(this);
	}else {
	    throw new Exception("Ce wagon est plein !");	
	    }    
    }

	/**
	 * Enleve un passager du wagon
	 * @param lePassager le passager à enlever
	 * @throws Exception le wagon est vide
	 */
	public void enlever(Passager lePassager) throws Exception {
		if (lesPassagers.isEmpty()) {
			throw new Exception("Le wagon est vide !");
		} else {
			lesPassagers.remove(lePassager);
		}
	}

	/**
	 * Décrit un wagon
	 */
	public String toString() {
		String msg = "Wagon N°" + (numero+1) + " : "+ lesPassagers.size()+ " passager(s).";
		msg+="\nReste "+ (capacite-lesPassagers.size())+" place(s).";
		
		if (lesPassagers.size() == 0){ return msg; }
		
		msg+="\nListe des passagers : ";
		for (Passager p : lesPassagers){
			if (p != null) {
				msg += "\n\t" + p;
			}
		}
		return msg;
		
	}
}
