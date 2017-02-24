

/**
 * Un contact a un nom et un numéro de téléphone.
 * Un contact peut ou pas avoir un prénom.
 */

class Contact {

    String nom;
    String prenom;
    String numTel;

    /**
    * Constructeur de la classe Contact
    * @param nom Le nom du contact.
    * @param prenom Le prénom du contact (optionel)
    * @param numero Le numero de téléphone du contact.
    * @throws Exception Cette exception est lancée quand le numéro ou le nom du contact sont pas rentrés.
    */
    public Contact(String nom, String prenom, String numero) throws Exception {
        setNom(nom);
        setPrenom(prenom);
        setNumTel(numero);
    }


     /**
    * Constructeur de la classe Contact
    * @param nom Le nom du contact.
    * @param numero Le numero de téléphone du contact.
    * @throws Exception Cette exception est lancée quand le numéro ou le nom du contact sont pas rentrés.
    */


    public Contact(String nom, String numero) throws Exception {
        this(nom, null, numero);
    }

    /**
    * Retourne le nom du contact.
    */
    public String getNom() {
        return nom;
    }

    /**
    * Modifie le nom du contact si le nouveau nom n'est pas null.
    * @param nom Le nouveau nom.
    * @throws Exception si le nouveau nom est null.
    */
    public void setNom(String nom) throws Exception {
        if (nom == null) throw new Exception("Le nom est null!");
        this.nom = nom;
    }

       /**
    * Retourne le nom du contact.
    */
    public String getPrenom() {
        return prenom;
    }

	/**
	 * Modifie le prénom du contact
	 * @param prenom Nouveau prénom du contact (peut être null).
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Permet de récupérer le numéro de téléphone du contact.
	 * @return Le numéro de téléphone du contact.
	 */
	public String getNumTel() {
		return numTel;
	}
	/**
	 * Modifie le numéro de téléphone du contact si celui-ci est non null.
	 * @param numTel Le nouveau numéro de téléphone du contact.
	 * @throws Exception Exception lancée si le numéro de téléphone passé en paramètre est null.
	 */
	public void setNumTel(String numTel)throws Exception {
		if(numTel!=null){
			this.numTel = numTel;
		}else{
			throw new Exception("le numéro de téléphone doit être renseigné");
		}
	}
	/**
	 * Permet de récupérer l'identité d'un contact (nom + prénom,
	 * 		ou simplement nom si le prénom n'est pas renseigné).
	 * @return La chaine de caractère décrivant l'identité du contact.
	 */
	public String getIdentite(){
		if(prenom != null){
			return nom + " " + prenom;
		}else{
			return nom ;
		}
	}

	@Override
	public String toString() {
		return "Contact : " + getIdentite() + "\n\t numero telephone : "+ numTel;
	}


	/**
	 * Méthode permettant de dire si le  contact courant
	 * 		est égal à l'objet passé en paramètre.
	 * Deux contacts sont les égaux s'ils ont même nom et
	 * même prénom (on ne regarde pas leur numéro de téléphone)
	 * @return true si l'objet passé est égal au contact courant.
	 */
	public boolean equals(Object o){
		if(o==null) return false;
		if(this == o) return true;
		if (this.getClass() != o.getClass()){
			return false;
		}
		Contact other = (Contact) o;

        if (prenom == null) {
            return other.getPrenom() == null;
        }

        return prenom.equals(other.getPrenom());
    }

}
