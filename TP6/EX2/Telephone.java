import java.util.LinkedList;

class Telephone {

    private boolean decroche;
    private boolean enCommunication;
    private String numeroCompose;
    private LinkedList<Contact> listContacts;
    private LinkedList<String> listeDerniersNumAppeles;


    public void composer(String numero) throws Exception {
        if (!decroche) this.numeroCompose = numero;
        else throw new Exception("Le telephone est decroche, impossible de composer. Veuillez raccrocher. ");
    }

    public void decrocher() {
        if (numeroCompose != null) {
            enCommunication = true;
            decroche = true;
        } else {
            numeroCompose = listeDerniersNumAppeles.pop();
            decroche = true;
            enCommunication = false;
        }
    }

    public void raccrocher() {
    }

    public void ajouterNouveauContact(String nom, String prenom, String numTel) {
    }

    public void ajouterNouveauContact(String nom, String numTel) {
    }

    public boolean supprimerContact(String nom, String prenom) {
    }

    private Contact rechercherContact(String numTel) {
    }

    public void afficherContact(String numTel) {
    }

    private LinkedList<Contact> rechercherContacts(char initialeNom) {
    }

    public void afficherContacts(char initialeNom) {
    }

    public void voirDerniersNumAppeles() {
    }

    public void viderListeDerniersNumAppele() {
    }

    public String toString() {
        return"";
    }
}
