package application;

import java.io.Serializable;

public class Quantite implements Serializable {


	private static final long serialVersionUID = -6107871957193810159L;
	private float nombre;
	private Unite unite;
	
	public Quantite(float nombre, Unite unite){
		this.nombre = nombre;
		this.unite = unite;
	}

	public float getNombre() {
		return nombre;
	}

	public Unite getUnite() {
		return unite;
	}
	
	@Override
	public String toString(){
		return new java.text.DecimalFormat("#.##").format(nombre) + " " + unite;
	}	
}
