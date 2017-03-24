package launcher;
import application.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProgPrincipalSaisie {

	public static void main(String[] args) {
		//EX1Q1 Q2 Q3 Q4
		LivreRecettes bouquin = null;
		try {
			bouquin = GestionnaireDeSauvegarde.charger("recettes.bin");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	
		//EX1Q5
		bouquin.afficherTousLesNomsDeRecette();
		System.out.println("---------------");
		bouquin.afficherLeLivre();
		System.out.println("---------------");
		
		//EX2Q1
		try (Scanner lecteur = new Scanner(System.in)) {
			System.out.print("Nom de la recette : ");
			String nomDeLaRecette = lecteur.nextLine().trim();
			System.out.println("Description de la recette (sautez deux lignes pour terminer) :" );
			String descriptionDeLaRecette = "";
			String saisie = lecteur.nextLine().trim();
			while (!saisie.isEmpty()) {
				descriptionDeLaRecette += saisie + "\n";
				saisie = lecteur.nextLine().trim();
			}
			System.out.print("Combien d'ingrédients contient votre recette ? :" );
			int nombreIngredients = lecteur.nextInt();
			lecteur.nextLine(); 
			ArrayList<Ingredient> listeIngredients = new ArrayList<>();
			while (--nombreIngredients >= 0) {
				System.out.print("Saisissez l'aliment :" );
				String aliment = lecteur.nextLine().trim();
				System.out.print("sa quantité (nombre, espace, unité en kg,g,ml,cl,dl,l ou rien) :" );
				float quantite = lecteur.nextFloat();
				String uniteSaisie = lecteur.nextLine().trim();
				Unite uniteIdentifiee;
				try {
					uniteIdentifiee = Unite.valueOf(uniteSaisie.toUpperCase());
				} catch (IllegalArgumentException e) {
					uniteIdentifiee = Unite.UNITE;
				}
				System.out.println(uniteIdentifiee);
				listeIngredients.add(new Ingredient(aliment, new Quantite(quantite, uniteIdentifiee)));
			}
			bouquin.ajouterRecette(new Recette(nomDeLaRecette, descriptionDeLaRecette), listeIngredients);
			System.out.println("------------------------------");
			bouquin.afficherLeLivre();

			//EX2Q3
			System.out.print("Saisissez le chemin du fichier où sauvegarder le livre de recettes :" );
			String nomFichier = lecteur.nextLine().trim();
			//EX2Q2
			try {
			    GestionnaireDeSauvegarde.sauvegarder(nomFichier, bouquin);
			} catch (IOException e) {
			    e.printStackTrace();
			}
		
		}

	}
}
