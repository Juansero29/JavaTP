package application;

public class Quantite {
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
	return nombre+ " " + unite;
    }	
}
