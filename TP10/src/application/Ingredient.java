package application;

import java.io.Serializable;


public class Ingredient implements Serializable {

	private static final long serialVersionUID = -4895798272391819413L;
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
	
}
