package entites;

public class Entite {
	 private String nom;
	 
	 public Entite(String nom)throws IllegalArgumentException {
		 setNom(nom);
	 }
	 
	 public String getNom(){
		 return nom;
	 }
	 
	 public void setNom(String nom)throws IllegalArgumentException {
		 if(nom == null || nom.trim().isEmpty()){
			 throw new IllegalArgumentException("nom de l'entite non valide : il doit être non vide");
		 }
		 else{
			 this.nom = nom;
		 }
	 }
	 
	 @Override
	 public String toString(){
		 return nom;
	 }
	 
}
