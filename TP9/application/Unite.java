package application;

public enum Unite{

    KG, G, ML, CL, DL, L, UNITE;

    @Override
    public String toString(){

	if (this == UNITE){
	    return "";
	} else {
	    return this.name().toLowerCase();
	}
    }
    
}
