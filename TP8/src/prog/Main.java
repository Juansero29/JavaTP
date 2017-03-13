package prog;
import entitees.*;

public class Main{

    public void main(String[] koala){

	Annuaire a = new Annuaire();

	AUnNumero toto = new ParticulierAvecNumero("Truc", "toto", "3 rue des lilas", "0102");
	a.ajouter(toto);

	Particulier part1 = new ParticulierAvecNumero("Durant", "Paul", "23 rue des roses", "1177");

	Professional pro1 = new ProfessionelAvecNumero("Durant", "zac de Riom", "entreprise BTP", "3344");


	a.afficherEntiteAyantPourNom("Durant");
	System.out.println("---------------");
	a.afficherEntiteAyantPourNom("Dupont");
				 
    }
}
