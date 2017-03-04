package personnages;

public class Humain{

    private String nom;
    private String boisson;

    public Humain(String nom, String boisson){
	this.nom = nom;
	this.boisson = boisson;
    }
    
    public Humain(String nom){
	this(nom, "eau");
    }

    public String getNom(){ return nom; }

    public String getBoisson(){ return boisson; }
    public void setBoisson(String boisson){ this.boisson = boisson; }
    
    public void parler(String texte){
	System.out.println("("+nom+")--- "+texte);
    }
    
    public void sePresenter(){
	parler("Bonjour, je suis "+getNom()+" et ma boisson favorite est "+getBoisson()+".");
    }

    public void boire(){
	System.out.println("Ah ! Un bon verre de " + getBoisson() + "\n GLOU GLOU GLOU!");
    }
    

}
