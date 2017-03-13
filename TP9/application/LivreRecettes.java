package application;

import java.util.*;

public class LivreRecettes {

    private Map<Recette, Set<Ingredient>> livre;

    public LivreRecettes() {

    }

    public void ajouterRecette(Recette r, List<Ingredient> ingredient) {
        livre.put(r, new TreeSet<>(ingredient));
    }

    public Map<Recette, Set<Ingredient>> rechercherRecettes(String nomRecette) {
        Map<Recette, Set<Ingredient>> trouvees = new TreeMap<>();
        for (Map.Entry<Recette, Set<Ingredient>> entry : livre.entrySet()) {
            if (entry.getKey().getNom().equals(nomRecette)) {
                trouvees.put(entry.getKey(), entry.getValue());
            }
        }
        return trouvees;
    }

    public void afficherTousLesNomsDeRecette() {
        for (Map.Entry<Recette, Set<Ingredient>> entry : livre.entrySet()) {
            System.out.println(entry.getKey().getNom());
        }
    }

    public void afficherLeLivre() {
        for (Map.Entry<Recette, Set<Ingredient>> entry : livre.entrySet()) {
            System.out.println(entry.getKey() + "\n\t" + entry.getValue());
        }
    }

    public Map<Recette, Set<Ingredient>> rechercherToutesLesRecettesAvec(String aliment) {
        Map<Recette, Set<Ingredient>> trouvees = new TreeMap<>();
        for (Map.Entry<Recette, Set<Ingredient>> entry : livre.entrySet()) {
            if (entry.getValue().iterator().hasNext()) {
                if (entry.getValue().iterator().next().getAliment().equals(aliment)) {
                    trouvees.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return trouvees;
    }

    public Map<String, Quantite> faireListeCourses(List<Recette> selection) {
        Map<String, Quantite> listeCourses = new TreeMap<>();
        for (Map.Entry<Recette, Set<Ingredient>> entry : livre.entrySet()) {
            if (selection.contains(entry.getKey())) {
                if (entry.getValue().iterator().hasNext()) {
                    listeCourses.put(entry.getValue().iterator().next().getAliment(), entry.getValue().iterator().next().getQuantite());
                }
            }
        }
        return listeCourses;
    }
}
