package entites;

public class Particulier extends Entite {
	private String prenom;
	
	
	public Particulier(String nom, String prenom) {
		super(nom);
		this.prenom = prenom;
	}
	
	 @Override
	 public String toString(){
		 return super.toString() + " " + prenom ;
	 }
}
