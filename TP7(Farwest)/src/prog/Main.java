/* Created by Juansero29 on 3/1/2017 at 20 at 20:34 at 20:38.
 */

package prog;
import personnages.Humain;



public class Main {

    public static void main(String[] args){
        Humain homosapiens = new Humain("Juan", "Kasteel Rouge");

        homosapiens.parler("Je viens de spawner dans ce monde!");
        homosapiens.sePresenter();
        homosapiens.boire();
    }
}
