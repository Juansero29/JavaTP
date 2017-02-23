class Contact {

    String nom;
    String prenom;
    String numTel;

    public Contact(String nom, String prenom, String numero) throws Exception {
        setNom(nom);
        setPrenom(prenom);
        setNumTel(numero);
    }

    public Contact(String nom, String numero) throws Exception {
        this(nom, null, numero);
    }

    //Déclartion des getteurs et setteurs.
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) throws Exception {
        if (nom == null) throw new Exception("Le nom est null!");
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTel() {
        return numTel;
    }
    public void setNumTel(String numTel) throws Exception {
        if (numTel == null) throw new Exception("Le numéro de téléphone est null!");
        this.numTel = numTel;
    }


    public String getIdentite() {
        if (prenom != null) {
            return nom + prenom;
        } else {
            return nom;
        }
    }

    public String toString() {
        return "Contact: " + getIdentite() + "\n" + numTel;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!o instanceof Contact) return false;

        Contact c = (Contact) o;

        if (!nom.equals(o.getNom())) {
            return false;
        }

        if (prenom == null) {
            return c.getPrenom() == null:
        }

        return prenom.equals(o.getPrenom());
    }

    //Préuve git diff.
}
