package application;


public class Ingredient {
    private String aliment;
    private Quantite quantite;

    public Ingredient(String aliment, Quantite quantite){
	this.aliment = aliment;
	this.quantite = quantite;
    }	
	
    public String getAliment() {
	return aliment;
    }

    public Quantite getQuantite() {
	return quantite;
    }

    @Override
    public String toString(){
	return quantite + " " +  aliment;
    }
	

    ///// on en a besoin pour mettre un Ingrédient dans un Set
    //// quand on veut regarder si deux ingrédients sont égaux 
    ////    on ne regarde que si les aliments sont les mêmes (pas les quantités).
    @Override
    public boolean equals(Object obj) {
	if (obj == null) return false;
	if (this == obj) return true;
	if (getClass() != obj.getClass()) return false;
		
	Ingredient other = (Ingredient) obj;
	if (aliment == null) return  other.aliment == null;
	return aliment.equals(other.aliment);
    }

    //// on en a besoin pour mettre dans un hashSet
    //// on ne tient compte que de l'aliment pour être cohérent avec le equals
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((aliment == null) ? 0 : aliment.hashCode());
	return result;
    }
	
}
