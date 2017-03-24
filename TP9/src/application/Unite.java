package application;

public enum Unite {
    ML, CL, DL, L, G, KG, UNITE;
	
    @Override
    public String toString(){
	if(this == UNITE){
	    return"";
	}
	else{
	    return name().toLowerCase();
	}
	
	// autre façon plus longue à écrire :
	/*
	  switch(this){
	  case ML : return "ml";
	  case CL : return "cl";
	  case DL : return "dl";
	  case L : return "l";
	  case G : return "g";
	  case KG : return "kg";
	  default : return "";
	  }
	*/
    }
}
