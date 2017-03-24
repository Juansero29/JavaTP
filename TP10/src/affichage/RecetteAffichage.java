package affichage;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import application.Ingredient;
import application.Recette;


public class RecetteAffichage {
	
	public static void afficherNomEtIngredients( Recette r , Set<Ingredient> ingredients){
		System.out.println(r.getNom()+" : ");
		for(Ingredient ingredient : ingredients){
			System.out.println("\t" + ingredient);
		}
	}
	
	
	public static void afficherTout(Recette r, Set<Ingredient> ingredients){
		afficherNomEtIngredients(r, ingredients);
		System.out.println("description : \n "+ r.getDescription());
	}

	
	public static void afficherTout(Map<Recette, Set<Ingredient>> recettes){
		Set<Entry<Recette, Set<Ingredient>>> ensPaires = recettes.entrySet();
		for(Entry<Recette, Set<Ingredient>> paire : ensPaires){
			RecetteAffichage.afficherTout(paire.getKey(), paire.getValue());
			System.out.println("");
		}
	} 
	
	public static void afficherNomsDesRecettes(Map<Recette, Set<Ingredient>> recettes){
		Set<Recette> ensCle = recettes.keySet();
		for(Recette r : ensCle){
			System.out.println(r.getNom());
		}
		
	} 
	
}
