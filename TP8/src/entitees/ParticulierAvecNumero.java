package entitees;

public class ParticulierAvecNumero{

    private String numero;
    private String adresse;

    public ParticulierAvecNumero(String nom, String prenom, String adresse, String numero){
	super(nom, prenom);
	this.adresse = adresse;
	this.numero = numero;
    }

    public String getAdresse(){ return adresse; }

    public String getNumero(){ return numero; }
    
}
