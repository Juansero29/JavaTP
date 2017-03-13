package entitees;

public class ProfessionnelAvecNumero extends Professionnel implements AUnNumero{

    private String numero;

    public ProfessionnelAvecNumero(String nom, String adresse, String description, String numero){
	super(nom,adresse,description);
	this.numero = numero;
    }

    public String getNumero() { return this.numero; }
    
    
}
