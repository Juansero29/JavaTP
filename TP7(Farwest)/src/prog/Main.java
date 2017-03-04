package prog;

import personnages.*;

public class Main {

    public static void main(String[] yolo) {

        Humain vilain = new Brigand("Wario", "martini", "désagréable", 1200f);
        Humain mario = new Cowboy("Mario", "froggie", "remarquable");
        Dame princesse = new Dame("Peach", "lait", "rose");


        mario.sePresenter();
        princesse.sePresenter();

        System.out.println("\n\n");

        vilain.sePresenter();
        vilain.parler("Je suis vraiment méchant.");

        System.out.println("\n\n");

        ((Brigand) vilain).kidnapper(princesse);
        mario.parler("PAS DE RESPECT RAMENES MA MEUF");
        vilain.parler("MUAHAHAHAHAHAAA");
        vilain.sePresenter();
        mario.parler("Attends, je mange ce champignon et tu vas moins rigoler !");

        System.out.println("\n\n");

        ((Cowboy) mario).tirer((Brigand) vilain);
        ((Cowboy) mario).tirer((Brigand) vilain);

        ((Cowboy) mario).liberer(princesse);

        System.out.println("\n\n");

        System.out.println("\nMario va se promener dans un bar...");

        Barman batman = new Barman("Lopo", "Chez Señor Lopo");
        mario.boire();

        batman.sePresenter();
        batman.parler("j'suis bourré");

        princesse.sePresenter();

        System.out.println("\n\n");
        Cowboy clint = new Sheriff("Clint Eastwood");
        clint.sePresenter();

        /*clint.coffrer((Brigand)vilain))
        On peut pas coffrer un Brigand car le compilateur ne sait pas à priori
        quelle est l'instance contenue dans la référence de type Cowboy 'clint'. Il
        suppose qu'il s'agit donc d'une instance d'un Cowboy, et un Cowboy n'a pas
        de méthode 'coffrer'. C'est donc une erreur au moment de compiler.
        */




    }


}
