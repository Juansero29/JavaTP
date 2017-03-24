package launcher;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import affichage.RecetteAffichage;
import application.Ingredient;
import application.LivreRecettes;
import application.Quantite;
import application.Recette;
import application.Unite;


public class ProgPrincipal {

    public static void main(String[] args) {
	//testIngredient();
	//testRecette();
	testLivreRecette();
    }
	
    public static void testIngredient(){
	Ingredient ing1 = new Ingredient("poireaux", new Quantite(2f, Unite.UNITE));
	Ingredient ing2 = new Ingredient("pommes de terre", new Quantite(300, Unite.G));
	Ingredient ing3 = new Ingredient("eau", new Quantite(50, Unite.CL));
	System.out.println(ing1);
	System.out.println(ing2);
	System.out.println(ing3);
    }
	
    public static void testRecette(){
	Set<Ingredient> ens = new HashSet<>();
	ens.add(new Ingredient("poireaux", new Quantite(2f, Unite.UNITE)));
	ens.add(new Ingredient("pommes de terre", new Quantite(300, Unite.G)));
	ens.add(new Ingredient("eau", new Quantite(50, Unite.CL)));
	Recette r = new Recette("soupe de poireaux", "Faire cuire les légumes puis mixer.");
		
	RecetteAffichage.afficherNomEtIngredients(r, ens);
	System.out.println("----------------");
	RecetteAffichage.afficherTout(r, ens);
    }
	
	
    public static void testLivreRecette(){
	LivreRecettes bouquin = new LivreRecettes();
		
	List<Ingredient> list = new ArrayList<Ingredient>();
	list.add(new Ingredient("poireaux", new Quantite(2f, Unite.UNITE)));
	list.add(new Ingredient("pommes de terre", new Quantite(100, Unite.G)));
	list.add(new Ingredient("pommes de terre", new Quantite(200, Unite.G)));
	list.add(new Ingredient("eau", new Quantite(50, Unite.CL)));
	bouquin.ajouterRecette(new Recette("soupe de poireaux", "Faire cuire les légumes puis mixer."), list);

		
	list = new ArrayList<Ingredient>();
	list.add(new Ingredient("carottes", new Quantite(1.2f , Unite.KG)));
	list.add(new Ingredient("pommes de terre", new Quantite(500, Unite.G)));
	list.add(new Ingredient("beurre", new Quantite(20, Unite.G)));
	bouquin.ajouterRecette(new Recette("purée de carottes", "Faire cuire les légumes puis écraser et mélanger."), list);

	list = new ArrayList<Ingredient>();
	list.add(new Ingredient("poisson", new Quantite(1f , Unite.KG)));
	list.add(new Ingredient("oeuf", new Quantite(4f , Unite.UNITE)));
	list.add(new Ingredient("bisque de homard", new Quantite(300, Unite.G)));
	list.add(new Ingredient("pincée de noix de muscade", new Quantite(1, Unite.UNITE)));
	bouquin.ajouterRecette(new Recette("Pain de Poisson", "Faire cuire les filets de poisson. \n "
					   + "Une fois refroidis, les émietter. \n Puis mélanger avec les oeufs et la bisque de homard. \n "
					   + "Assaisonner avec la noix de muscade. \n Faire cuire 45 min à 180."), list);
		
		
		
	list = new ArrayList<Ingredient>();
	list.add(new Ingredient("carottes", new Quantite(1.2f , Unite.KG)));
	list.add(new Ingredient("courgette", new Quantite(1f, Unite.KG)));
	list.add(new Ingredient("eau", new Quantite(25, Unite.G)));
	bouquin.ajouterRecette(new Recette("purée de carottes", "Faire cuire les légumes puis écraser et mélanger avec le beurre."), list);

		
		
		
	bouquin.afficherTousLesNomsDeRecette();
	System.out.println("---------------");
	bouquin.afficherLeLivre();
	System.out.println("---------------");
	//bouquin.afficherRecetteEtIngredient("soupe de poireaux");
	RecetteAffichage.afficherTout(bouquin.rechercherRecettes("soupe de poireaux"));
	System.out.println("---------------");
	//bouquin.afficherRecetteEtIngredient("purée de carottes");
	RecetteAffichage.afficherTout(bouquin.rechercherRecettes("purée de carottes"));
	System.out.println("---------------");
	Map<Recette, Set<Ingredient>> recettesAvecPDT = bouquin.rechercherToutesLesRecettesAvec("pommes de terre");
	RecetteAffichage.afficherTout(recettesAvecPDT);
	System.out.println("---------------");
	List<Recette> selection = new ArrayList<Recette>(recettesAvecPDT.keySet());
	System.out.println("la liste de courses : ");
	Map<String, Quantite> listeCourses = bouquin.faireListeCourses(selection);
	Set<Entry<String, Quantite>> lesCourses = listeCourses.entrySet();
	for(Entry<String, Quantite> course : lesCourses){
	    System.out.println(course.getValue() + " " + course.getKey());
	}
	System.out.println("---------------");
		
    }

}
