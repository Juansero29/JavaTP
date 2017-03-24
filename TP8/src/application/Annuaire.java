package application;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import entites.AUnNumero;


public class Annuaire {

	Map<String, List<AUnNumero>> bottin;

	public Annuaire(){
		bottin = new TreeMap<>();
	}

	public void ajouter(AUnNumero qqun) {
		String nom = qqun.getNom();
		List<AUnNumero> list = trouverEntiteAyantPourNom(nom);
		if(list == null){
			list = new ArrayList<>();
			bottin.put(nom, list);
		}
		list.add(qqun);
	}

	@Override
    public String toString(){
    	String retour = new String();
    	Set<Entry<String,List<AUnNumero>>> ens = bottin.entrySet();
    	for(Entry<String,List<AUnNumero>> entree : ens){
    	//	retour += entree.getKey().toString()+"\n";
    		for(AUnNumero qq : entree.getValue()){
    			retour += "    "+    qq.toString() + "\n";
    		}
    	}
    	return retour;
    }


    private List<AUnNumero> trouverEntiteAyantPourNom(String nom){
    	return bottin.get(nom);
    }


    public void afficherEntiteAyantPourNom(String nom){
    	List<AUnNumero> list = trouverEntiteAyantPourNom(nom);
    	System.out.print("résultats pour " + nom + " : ");
        if(list != null){
        	System.out.println(list.size() + " réponses trouvées: ");
        	for(AUnNumero p : list){
        		System.out.println(p.toString()+ "\n");
        	}
        }
        else{
            System.out.println("aucun résultat " );
        }
    }


}
