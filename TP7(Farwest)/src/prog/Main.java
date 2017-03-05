package prog;

import personnages.*;

public class Main {

    public static void main(String[] yolo) {

        Humain vilain = new Brigand("Wario", "martini", "désagréable", 1200f);
        Humain mario = new Cowboy("Mario", "froggie", "remarquable");
        Dame princesse = new Dame("Peach", "lait", "rose");
        Narrateur narrateur = new Narrateur("Pluto");


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

        narrateur.parler("Mario va se promener dans un bar...\n " +
                "Ce qu'il sait pas: le brigand est sorti de la prison!");


        Barman batman = new Barman("Lopo", "Chez Señor Lopo");
        mario.boire();

        batman.sePresenter();
        batman.parler("j'suis bourré");

        princesse.sePresenter();
        batman.parler("t'es belle princesse");


        narrateur.parler("Dans ce moment, Wario est rentré dans le bar.\n" +
                "Au même temps, un sheriff s'approche au bar! \n" +
                "Les problèmes vont commencer... ");

        //DONE: Test class 'Sheriff'
        System.out.println("\n\n");

        //Je change la référence du 'clint' à un Sheriff, ainsi je peux
        //utiliser ses méthodes sans cast à chaque fois.

        Sheriff clint = new Sheriff("Clint Eastwood");
        clint.sePresenter();
        clint.rechercherUnBrigand((Brigand) vilain);

        vilain.parler("merde, j'suis foutu");


        clint.parler("Ahh! Je l'ai entendu! Tu échapperas jamais fdp! ");
        vilain.parler("merde...");

        clint.coffrer((HorsLaLoi) vilain);

        princesse.parler("Ah! J'suis trop conne! Regarde ma robe!");
        batman.parler("T'es nulle");
        princesse.boire();

        /*clint.coffrer((Brigand)vilain))
        On peut pas coffrer un Brigand car le compilateur ne sait pas à priori
        quelle est l'instance contenue dans la référence de type Cowboy 'clint'. Il
        suppose qu'il s'agit donc d'une instance d'un Cowboy, et un Cowboy n'a pas
        de méthode 'coffrer'. C'est donc une erreur au moment de compiler.
        */


        //DONE: Test class 'Indien'


        narrateur.parler("Après cette formidable situation, un indien rentre");

        Indien porro = new Indien("Vihaan");
        porro.sePresenter();
        porro.parler("J'suis un indien chelou, " +
                "j'viens vous dépiler les gars");

        mario.parler("Casse-toi putain!");
        batman.servir(porro);
        princesse.parler("Regarde-lui, il a un dildo dans ses mains! ");
        porro.parler("Tais-toi merde, c'est un coyote!");
        porro.scalper(princesse);

        porro.parler("Alleez! Préparez vos poils! C'est Vihaan qui va vous dépiler! ");
        porro.scalper(batman);
        porro.scalper((Cowboy) mario);

        porro.parler("Alleez! J'ai scalpé tout le monde, j'm'casse! Tchaoo! ");

        //DONE: Use interface 'VisagePale'




    }


}
