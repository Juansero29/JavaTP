package entitees;

public abstract class Entite{

    private String nom;
    
    public Entite(String nom) throws IllegalArgumentException{
	if(nom == null || nom.trim().isEmpty(){
	    throw new IllegalArgumentException("Le nom ne peut pas être vide.");
    	}
	this.nom = nom;
    }

    public String getNom(){ return nom; }

    public void setNom(String nom) throws IllegalArgumentException{
	if(nom == null || nom.trim().isEmpty(){
	    throw new IllegalArgumentException("Le nom ne peut pas être vide.");
    	}
	    this.nom = nom;
    }
     
} 
