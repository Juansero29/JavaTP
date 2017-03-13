package application;

public class Recette{

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
    
}
