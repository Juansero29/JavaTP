package entites;

public class ParticulierAvecNumero extends Particulier implements AUnNumero {
	private String adresse;
	private String numero;
	
	
	public ParticulierAvecNumero(String nom, String prenom, String adresse, String numero) {
		super(nom, prenom);
		this.adresse = adresse;
		this.numero = numero;
	}
	
	@Override
	public String getNumero() {
		return numero;
	}

	@Override
	public String getAdresse() {
		return adresse;
	}
	
	 @Override
	 public String toString(){
		 return super.toString() + "  : " + numero + "\n \t" + adresse ;
	 }

}
