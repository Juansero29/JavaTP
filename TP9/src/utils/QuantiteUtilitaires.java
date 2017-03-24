package utils;
import application.Quantite;
import application.Unite;


public class QuantiteUtilitaires {

    /**
     * Convertit une quantité donnée en kg ou en g en une quantité en kg. 
     * Ou alors convertit une quantitée donnée en l, dl, cl, ml en une quantité en l.
     * Si la quantité donnée est à l'unité, elle est retournée telle qu'elle.
     * @param quantite la quantité à convertir.
     * @return Retourne une nouvelle quantite, ou la même si la quantité fournie est en Unite, kg, ou l.
     */
    public static Quantite conversion(Quantite quantite){
	Unite unite = quantite.getUnite();
	switch(unite){
	case KG : 
	case L : 
	case UNITE: return quantite;
	case G :
	    return new Quantite(quantite.getNombre()/1000, Unite.KG);
	case DL: 
	    return new Quantite(quantite.getNombre()/10, Unite.L);
	case CL : 
	    return new Quantite(quantite.getNombre()/100, Unite.L);
	default : // ML
	    return new Quantite(quantite.getNombre()/1000, Unite.L);
	}
	//// autre façon : 
	/*		
			if(unite==Unite.KG || unite==Unite.L || unite==Unite.UNITE){
			return quantite;
			}else if(unite==Unite.G){
			return new Quantite(quantite.getNombre()/1000, Unite.KG);
			}else if(unite==Unite.DL){
			return new Quantite(quantite.getNombre()/10, Unite.L);
			}else if(unite==Unite.CL){
			return new Quantite(quantite.getNombre()/100, Unite.L);
			}else{ // si (unite==Unite.ML)
			return new Quantite(quantite.getNombre()/1000, Unite.L);
			}
	*/
    }
	
	
    /**
     * Ajoute deux quantités données à conditions qu'elles soient compatibles. Exemple 
     * 	des kg et des dl ne sont pas compatibles. Si on ajoute des grammes avec des 
     * 	grammes le résultat sera en grammes (idem pour dl, cl, et ml). PAr contre si 
     * 	on ajoute des kg avec des g le résultat sera en kg. De même si on ajoute des 
     *  dl avec des cl ou des ml avec des l, le résultat sera en litres. 
     * @param qte1 Une quantité à ajouter.
     * @param qte2 L'autre quantité à ajouter.
     * @return la nouvelle quantité issue de leur somme. 
     */
    public static Quantite somme(Quantite qte1, Quantite qte2){
	Unite unite1 = qte1.getUnite();
	Unite unite2 = qte2.getUnite();
	if(unite1 == unite2){
	    return new Quantite(qte1.getNombre() + qte2.getNombre(), qte1.getUnite());
	}
	unite1 = conversion(qte1).getUnite();
	unite2 = conversion(qte2).getUnite();
	if(unite1 != unite2){
	    System.out.println(unite1 + "!=" +unite2);
	    throw new IllegalArgumentException("somme impossible : unités de mesure non compatibles");
	}else{
	    return new Quantite(qte1.getNombre() + qte2.getNombre(), qte1.getUnite());
	}
    }
}
