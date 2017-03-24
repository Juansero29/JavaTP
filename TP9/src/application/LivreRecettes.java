package application;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;

import affichage.RecetteAffichage;
import utils.QuantiteUtilitaires;


public class LivreRecettes {
    private Map<Recette, Set<Ingredient>> livre= new TreeMap<>();
	
    /**
     * Permet d'ajouter une recette ainsi que sa liste d'ingrédients dans le livre de recette.
     * @param r La recette 
     * @param list La liste des ingrédients
     */
    public void ajouterRecette(Recette r, List<Ingredient> list){
	if(livre.containsKey(r)){
	    System.out.println("recette déjà présente");
	    //// c'est à dire même nom et même description d'après la définition du equals de Recette
	    //// ça n'empêche pas d'avoir deux soupes aux poireaux si pas même description
	}
	else{
	    ///// en faisant comme ça, pas de bug mais si deux ingrédients égaux => seulement l'un est dans le set
	    //Set<Ingredient> hs = new HashSet<>(list);

	    /////autre façon : si dans la liste il y a 1dl de lait et 5 dl de lait => il y aura dans le set 6dl de lait
	    Set<Ingredient> hs = new HashSet<>();
	    for(Ingredient ingredient : list){
		Iterator<Ingredient> it = hs.iterator();
		while(it.hasNext()){
		    Ingredient ing = it.next();
		    if(ing.equals(ingredient)){
			ingredient = new Ingredient(ingredient.getAliment(), QuantiteUtilitaires.somme(ingredient.getQuantite(),ing.getQuantite()));
			it.remove();
			break;
		    }
		}
		hs.add(ingredient);
	    }
	    
	    livre.put(r, hs);
	}
    }
	
	
    /**
     * Recherche et retourne toutes les recettes (et leurs ingrédients) ayant pour nom celui donné en paramètre.
     * @param nomRecette Le nom de la recette cherchée.
     * @return La map rassemblant les recettes trouvées avec leurs ingrédients respectifs.
     */
    public Map<Recette, Set<Ingredient>> rechercherRecettes(String nomRecette){
	Map<Recette, Set<Ingredient>> recettesTrouvees = new TreeMap<>();
	Set<Entry<Recette, Set<Ingredient>>> ensPaires = livre.entrySet();
	for(Entry<Recette, Set<Ingredient>> paire : ensPaires){	
	    if(paire.getKey().getNom().equals(nomRecette)){
		recettesTrouvees.put(paire.getKey(), paire.getValue());
	    }
	}
	return recettesTrouvees;
    }
	
    /**
     * Affiche tous les noms de recettes contenues dans le livre de recettes.
     */
    public void afficherTousLesNomsDeRecette(){
	RecetteAffichage.afficherNomsDesRecettes(livre);
    }
	
    /**
     * Permet d'afficher tout le contenu du livre : 
     * 	toutes les recettes et leurs ingrédients respectifs.
     */
    public void afficherLeLivre(){
	RecetteAffichage.afficherTout(livre);
    }
	
    /**
     * Recherche toutes les recettes dont l'aliment donné en paramètre est 
     * 	l'un de leurs ingrédients.
     * @param aliment L'aliment que l'on cherche à cuisiner.
     * @return Une map contenant toutes les recettes cuisinant l'aliment donné.
     */
    public Map<Recette, Set<Ingredient>> rechercherToutesLesRecettesAvec(String aliment){
	Map<Recette, Set<Ingredient>> recettesPossibles  = new TreeMap<>();
	Set<Entry<Recette, Set<Ingredient>>> ensPaires = livre.entrySet();
	for(Entry<Recette, Set<Ingredient>> paire : ensPaires){
	    for(Ingredient ingredient : paire.getValue()){
		if(ingredient.getAliment().equals(aliment)){
		    recettesPossibles.put(paire.getKey(), paire.getValue());
		}
	    }
			
	}
	return recettesPossibles;
    }
	

    public Map<String, Quantite> faireListeCourses(List<Recette> selection){
	Map<String, Quantite> courses = new TreeMap<>();
	for(Recette r : selection){
	    Set<Ingredient> ingredients = livre.get(r);
	    for(Ingredient ingredient : ingredients){
		String aliment = ingredient.getAliment();
		Quantite quantite = ingredient.getQuantite();
				
		if(courses.containsKey(aliment)){
		    // l'aliment est déjà dans la liste de courses il faut augmenter sa quantite
		    quantite = QuantiteUtilitaires.somme(quantite, courses.get(aliment));
		}
		courses.put(aliment, quantite);
	    }
	}
	return courses;
    }
	
	
	
}
