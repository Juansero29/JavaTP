package application;

import java.util.LinkedList;

import entites.AUnNumero;
import entites.Entite;
import entites.Particulier;
import entites.ParticulierAvecNumero;
import entites.Professionnel;
import entites.ProfessionnelAvecNumero;

public class ProgPrincipal {

	public static void main(String[] args) {
		Annuaire a = new Annuaire();
		 
		AUnNumero toto = new ParticulierAvecNumero("toto", "toto", "3 rue des lilas", "0102");
		
		a.ajouter(toto);
		
//		Particulier titi = new Particulier("dupond", "toto");
//		a.ajouter(titi);     ////// impossible :  n'est pas un AunNumero
		
		Particulier part1 = new ParticulierAvecNumero("durant", "paul", "23 rue des roses", "1177");
		a.ajouter((ParticulierAvecNumero)part1);
		
		Professionnel prof1 = new ProfessionnelAvecNumero("durant", "zac de clermont", "entreprise BTP", "3344");
		a.ajouter((ProfessionnelAvecNumero)prof1);
		
		System.out.println(a);
		
		System.out.println("------------");
		
		
		a.afficherEntiteAyantPourNom("durant");
		
		System.out.println("------------");
		
		a.afficherEntiteAyantPourNom("dupont");
		
	}

}
