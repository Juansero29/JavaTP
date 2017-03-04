package application;

import personnages.*;

public class Main{

    public static void main(String[] yolo){

	Humain vilain = new Brigand("Wario","martini","désagréable", 1200f);
	Humain mario = new Cowboy("Mario", "froggie", "remarquable");
	Dame princesse = new Dame("Peach");


	mario.sePresenter();
	princesse.sePresenter();
	
	vilain.parler("Je suis vraiment méchant.");
	
	((Brigand)vilain).kidnapper(princesse);
	mario.parler("PAS DE RESPECT RAMENES MA MEUF");
	vilain.parler("MUAHAHAHAHAHAAA");
	vilain.sePresenter();
	mario.parler("Attends, je mange ce champignon et tu vas moins rigoler !");

	((Cowboy)mario).tirer((Brigand)vilain);
	((Cowboy)mario).tirer((Brigand)vilain);

	((Cowboy)mario).liberer(princesse);

	mario.boire();
	
	Barman batman = new Barman("Lopo", "Chez señor Lopo");

	batman.sePresenter();
	batman.parler("j'suis bourré");

	princesse.sePresenter();
	
	
    }


}
