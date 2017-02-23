/**
 * @author Gerben De Vries
 * @author Juan Rodriguez
 * @version 1.0.0
 */

import applications.Telephone;
import applications.Ampoule;

public class ProgPrincipal {
    /**
     * Classe qui contient le programme principal.
     *
     * @param lafsdf paramètres au moment d'initialiser le programme depuis la console.
     */
    public static void main(String[] lafsdf) {


        Ampoule LED = new Ampoule();
        while (!LED.isGrille()) {
            LED.allumer();
            if (!LED.isGrille())
                LED.eteindre();
        }

        Telephone Honor5C = new Telephone();
        Honor5C.composer("0618262847");
        Honor5C.decrocher();
        Honor5C.raccrocher();

        Honor5C.composer(null);
        Honor5C.decrocher();
        Honor5C.raccrocher();


    }

}
