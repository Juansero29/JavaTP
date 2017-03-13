package entitees;

public class Particulier extends Entite{

    String prenom;
    
    public Particulier(String nom, String prenom){
	super(nom);
	this.prenom = prenom;
    }

}
