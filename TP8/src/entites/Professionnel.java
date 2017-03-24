package entites;

public class Professionnel extends Entite implements AUneAdresse {
	private String adresse;
	private String description;
	
	public Professionnel (String nom, String adresse, String description){
		super(nom);
		this.adresse = adresse;
		this.description = description;
	}
	
	@Override
	public String getAdresse(){
		return adresse;
	}
	
	@Override
	public String toString(){
		return super.toString() + " \n \t" + description + "\n\t" + adresse ;
	}
	
}
