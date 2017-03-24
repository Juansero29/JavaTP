import java.util.Scanner;
import java.util.ArrayList;

class Prog {
    public static void main(String[] lol){
	
	String message = "Un fichier comme ça il y en a 17 tous les 59"
	    + " voir tous les 44 . Et encore ... Etre spécifique est l"
	    + "'une de ses 40 principales particularités . On peut lui"
	    + " en trouver 56 autres . Dans les 49 caractères de son n"
	    + "om est concentré son objectif , et de son extension dép"
	    + "end la réussite de sa lecture . S'il est crypté soyez a"
	    + "ttentif à sa clé et à son 62 ème expéditeur , les 51 pr"
	    + "emiers ne comptent pas , sauf peut être le 49 ème ou le"
	    + " 50 ème .";

	ArrayList<Integer> listeEntiers = new ArrayList<>();
	ArrayList<String> listeMots = new ArrayList<>();

	Scanner scan = new Scanner(message);

	while(scan.hasNext()){
	    if(scan.hasNextInt()){
		listeEntiers.add(scan.nextInt());
	    } else {
		listeMots.add(scan.next());
	    }
	}
	scan.close();

	String mots = "";
	String entiers = "";
	
	for(int i: listeEntiers){
	    mots += listeMots.get(i)+ " ";
	}



	System.out.println("Message decrypté: " + mots);
	
    }
}
