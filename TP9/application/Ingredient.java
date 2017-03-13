package application;

public class Ingredient {

    private Quantite quantite;
    private String aliment;


    public Ingredient(String aliment, Quantite quantite){
	this.aliment = aliment;
	this.quantite = quantite;
    }

    public String getAliment(){
	return aliment;
    }

    public Quantite getQuantite(){
	return quantite;
    }

    public String toString(){
	return aliment + " " + quantite;
    }

}
