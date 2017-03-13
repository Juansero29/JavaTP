package application;

public class Quantite {

    private Unite unite;
    private float nombre;

    public Quantite(float nombre, Unite unite){
	this.unite = unite;
	this.nombre = nombre;
    }


    public float getNombre(){
	return nombre;
    }

    public Unite getUnite(){
	return unite;
    }

    public String toString(){
	return nombre + " " + unite;
    }   
}
