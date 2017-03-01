package personnages;

public class Brigand extends Humain{
    private final static float RECOMPENSE_PAR_FEMME = 242f;
    private String comportement;
    private int nbDamesEnlevees = 0;
    private float recompense;
    private boolean enPrison = false;


    public Brigand (String nom, String boisson, String comportement, float recompense){
	super(nom, boisson);
	this.comportement = comportement;
	this.recompense = recompense;
    }

    public Brigand(String nom){
	super(nom);
	recompense = 100;
    }

    public float getMiseAPrix(){
	return recompense;
    }

    public void kidnapper(Dame dame){
	System.out.println("Ah ah! " + dame.getNom() + ", tu es mienne désormais! ");
	dame.seFaireKidnapper(this);
    }

    @Override
    public void sePresenter(){
	System.out.println(super.getNom() + " le " + comportement + ".");
    }

    


    //Damned, je suis fait! (nom_du_sherif), tu m’as eu!



    
}
