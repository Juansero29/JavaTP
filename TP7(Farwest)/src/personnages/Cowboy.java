package personnages;

public class Cowboy extends Humain{

    private int popularite = 0;
    private String attitude;

    public Cowboy(String nom, String boisson, String attitude){
	super(nom, boisson);
	this.attitude = attitude;
    }

    public Cowboy(String nom){
	this(nom, "Whiskey", "vaillant");
    }

    public void liberer (Dame dame){
	super.parler("Je suis arrivé au secours, ma cherie <3");
	try {
	    dame.seFaireLiberer(this);
	} catch (IllegalStateException i){
	    parler("que je suis con, elle est déjà libre.....");
	}
	popularite++;
    }

    public void tirer (Brigand brigand){
	System.out.println("Le " + attitude + " " + getNom() + " tire sur " + brigand.getNom() + ".\nPAAN!!");
	parler("Prends ça, rascal!");
    }

    @Override
    public void sePresenter(){
	super.sePresenter();
	parler("Je suis " + attitude + " et ma popularité est " + popularite + ".");
    }


    

    

}
