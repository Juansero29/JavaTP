package utils;
import application.Unite;
import application.Quantite;

public class QuantiteUtilitaires {

    public Quantite conversion(Quantite quantite){

	Unite u = quantite.getUnite();
	float f = quantite.getNombre();
	
	if (u == KG || u == L || u == UNITE){
	    return quantite;
	} else if (u == G){
	    return new Quantite(f/1000, KG);
	} else if (u == ML) {
	    return new Quantite(f/1000, L);
	} else if (u == CL) {
	    return new Quantite(f/100, L);
	} else if (u == DL) {
	    return new Quantite(f/10, L);
	}
    }


    public Quantite somme (Quantite qte1, Quantite qte2) throws IllegalArgumentException {

	if (qte1.getUnite() != qte2.getUnite()){
	    qte1 = conversion(qte1);
	    qte2 = conversion(qte2);
	    
	   if(qte1.getUnite() != qte2.getUnite()){
		throw new IllegalArgumentException("somme impossible: unites de mesure non compatibles");
	   }
	}
	
	return new Quantite(qte1.getNombre() + qte2.getNombre(), qte1.getUnite());
    }
}




