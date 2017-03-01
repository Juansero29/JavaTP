package personnages;

public class Dame extends Humain{

    String couleurRobe;
    boolean captive;

    public Dame(String nom, String boisson, String couleurRobe){
	super(nom, boisson);
	this.couleurRobe = couleurRobe;
    }

    public Dame(String nom){
	super(nom);
	this.couleurRobe = "rouge passion";
    }
    public String getCouleurRobe(){
	return couleurRobe;
    }
    public void setCouleurRobe(String couleur){
	this.couleurRobe = couleur;
	super.parler("Regardez ma nouvelle robe"+couleur+" !");
    }

    public boolean isCaptive(){
	return captive;
    }
    void seFaireKidnapper (Brigand brigand){
	super.parler("AHHHHHHHHHH AU SECOURS !!!");
	captive = true;
    }
    void seFaireLiberer (Cowboy cowboy) throws IllegalStateException{
	if (!captive) throw new IllegalStateException("Cette dame est déjà libérée"); 
	super.parler("Merci de m'avoir sauvé gentil Cowboy.");
	captive = false;
    }

    @Override
    public void sePresenter(){
	System.out.println("Miss "+super.getNom());
    }
    


}
