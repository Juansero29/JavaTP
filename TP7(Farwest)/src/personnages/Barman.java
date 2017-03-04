package personnages;

public class Barman extends Humain{

    private String nomBar;
    
    public Barman(String nom, String nomBar){
	super(nom, "bière");
	this.nomBar = nomBar;
    }
    
    public Barman(String nom){
	this(nom,"Chez " + nom);
    }

    public void servir(Humain h) {
        parler("Tiens un bon verre de " + h.getBoisson());
    }
    @Override
    public void sePresenter(){
	super.sePresenter();
	parler("Le nom de mon bar est " + nomBar);
    }

    @Override
    public void parler(String msg){
        super.parler(msg + ", mon gars.");
    }

}
