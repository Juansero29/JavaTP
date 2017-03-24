package application;

import java.io.Serializable;

public enum Unite implements Serializable {
	ML, CL, DL, L, G, KG, UNITE;
	
	@Override
	public String toString(){
		switch(this){
		case ML : return "ml";
		case CL : return "cl";
		case DL : return "dl";
		case L : return "l";
		case G : return "g";
		case KG : return "kg";
		default : 
			return "";
		}
	}
}
