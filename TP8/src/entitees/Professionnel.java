package entitees;

public class Professionnel extends Entite implements AUneAdresse{

    private String adresse;
    private String description;

    public Professionnel(String nom, String adresse, String description){
	super(nom);
	this.adresse = adresse;
	this.description = description;
    }

    public String getAdresse(){
	return this.adresse;
    } 

}
