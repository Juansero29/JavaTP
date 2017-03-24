package entites;

public class ProfessionnelAvecNumero extends Professionnel implements AUnNumero {
	private String numero; 
	
	public ProfessionnelAvecNumero(String nom, String adresse, String description, String numero) {
		super(nom, adresse, description);
		this.numero = numero;
	}
	
	@Override
	public String getNumero() {
		return numero;
	}
	
	@Override
	public String toString(){
		return super.toString() + "\n \t\t " + numero;
	}

}
