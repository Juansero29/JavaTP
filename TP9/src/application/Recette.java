package application;


// la classe Recette doit implémenter l'interface Comparable 
// pour pouvoir être utilisée comme clé dans une TreeMap
public class Recette implements Comparable<Recette>{
    private String nom;
    private String description;
	
    public Recette(String nom, String description){
	this.nom = nom; 
	this.description = description;
    }
    public String getNom(){
	return nom;
    }
	
    public String getDescription(){
	return description;
    }
	
    /*	@Override
	public String toString(){
	return "recette de "+ nom + "\n\t" + description;
	}
    */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
	    + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((nom == null) ? 0 : nom.hashCode());
	return result;
    }

    // nécessaire pour pouvoir utiliser contains
    @Override
    public boolean equals(Object obj) {
	if (obj == null) return false;
	if (this == obj) return true;
	if (getClass() != obj.getClass()) return false;
	Recette other = (Recette) obj;
	if (nom == null && other.nom != null){
	    return false;
	}
	if (nom!=null &&  !nom.equals(other.nom)){
	    return false;
	}
	if (description == null) return other.description == null;
		
	return description.equals(other.description);
    }
	
	
    /**
     * Compare la recette courante avec l'objet passé en paramètre
     */
    @Override
    public int compareTo(Recette r) {
	int diff = nom.compareToIgnoreCase(r.getNom());
	if(diff !=0) return diff;
	return description.compareToIgnoreCase(r.getDescription());
    }
	
	
}
