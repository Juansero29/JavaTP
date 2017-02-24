import java.util.LinkedList;
import java.util.Objects;

/**
 *  Un téléphone a  une liste de contacts avec des contacts enregistrés et
 *  une liste des numéros appelés.
 *  Il a aussi des états et un numéro avec lequel on peut communiquer.
 *  */

class Telephone {
    /** indique si le téléphone est décroché */
    private boolean decroche;
    /** indique si le téléphone est en communication */
    private boolean enCommunication;
    /** contient le nom auquel on peut faire appel */
    private String numeroCompose;
    /** liste des contact enregistrés */
    private LinkedList<Contact> listeContacts;
    /** liste des derniers numéros appelés */
    private LinkedList<String> listeDerniersNumAppeles;


    /**
     * Constructeur du téléphone.
     */
    public Telephone(){
        decroche = false;
        enCommunication = false;
        numeroCompose = null;
        listeContacts = new LinkedList<Contact>();
        listeDerniersNumAppeles = new LinkedList<String>();
    }

    /**
     * Permet de composer un numéro avec lequel on peut communiquer.
     * @param numero Le numéro à composer.
     * @throws Exception si le téléphone est décroché.
     */
    public void composer(String numero) throws Exception {
        if (!decroche) this.numeroCompose = numero;
        else throw new Exception("Le telephone est décroché, impossible de composer. Veuillez raccrocher.");
    }

    /** Décroche le télephone et apelle le numéro composé s'il y en a un. */
    public void decrocher() {
        if (numeroCompose != null) {
            enCommunication = true;
            decroche = true;
        } else if (null != listeDerniersNumAppeles.getFirst()) {
            numeroCompose = listeDerniersNumAppeles.getFirst();
            decroche = true;
            enCommunication = false;
        } else {
            System.out.println("Aucun numéro à appeler. ");
        }
    }

    /**
     * Permet de raccrocher le téléphone et arreter la communication */
    public void raccrocher() {
        enCommunication = false;
        if (numeroCompose != null) {
            listeDerniersNumAppeles.addFirst(numeroCompose);
        }
    }

    /**
     * Permet d'ajouter un nouveau contact à la liste des contacts.
     * @param nom Le nom du contact à ajouter.
     * @param prenom Le prénom du contact à ajouter.
     * @param numTel Le numéro de téléphone du contact à ajouter.
     * @throws Exception si le nom ou le numéro de téléphone sont nulls ou si le contact est présent déjà dans la liste des contacts.
     */
    public void ajouterNouveauContact(String nom, String prenom, String numTel) throws Exception {
        Contact c = null;
        c = new Contact(nom, prenom, numTel);
        Contact x = c;
        x = rechercherContact(numTel);
        if (x == null) {
            listeContacts.add(c);
        } else {
            throw new Exception("Ce contact existe déjà. ");
        }

    }

    /**
     * Permet d'ajouter un nouveau contact à la liste des contacts sans prenom.
     * @param nom Nom du contact à ajouter.
     * @param numTel Numéro de téléphone du contact à ajouter.
     * @throws Exception si le nom ou le numéro de téléphone sont nulls ou si le contact est présent déjà dans la liste des contacts.
     */
    public void ajouterNouveauContact(String nom, String numTel) throws Exception {
        ajouterNouveauContact(nom, null, numTel);
    }

    /**
     * Permet de supprimer un contact de la liste des contacts.
     * @param nom Nom du contact à supprimer.
     * @param prenom Prénom du contact à supprimer.
     * @return true si le contact était bien dans la liste des
     * 	contacts et donc a bien été supprimé.
     */
    public boolean supprimerContact(String nom, String prenom) {
        for (int i = 0; i < listeContacts.size(); i++) {
            if (Objects.equals(listeContacts.get(i).getNom(), nom) &&
                    Objects.equals(listeContacts.get(i).getPrenom(), prenom)) {
                listeContacts.remove(i);
                return true;
            }
        }
        return false;
    }

    private Contact rechercherContact(String numTel) {

        if (listeContacts.isEmpty()) {
            return null;
        }

        for (Contact c : listeContacts) {
            if (c.getNumTel().equals(numTel)) {
                return c;
            }
        }
        return null;
    }

    /** Affiche un contact dont le numéro de téléphone correspond au numéro passé en parametres
     * @param numTel numéro du contact à afficher.
     * */
    public void afficherContact(String numTel) {
        Contact c = rechercherContact(numTel);
        if (c != null) System.out.println(c.getIdentite());
        else System.out.println(numTel);
    }



    /**
     * Recherche les contacts dont le nom commence par la lettre passée en paramètres.
     * @param initialeNom L'initiale du nom des contact cherchés.
     * @return la liste des contacts dont le nom commence par la lettre donnée.
     */
    private LinkedList<Contact> rechercherContacts(char initialeNom) {
        LinkedList<Contact> listeContactsInitiale = new LinkedList<>();
        for (Contact c : listeContacts) {
            if (c.getNom().charAt(0) == initialeNom) {
                listeContactsInitiale.add(c);
            }
        }
        return listeContactsInitiale;
    }

    /**
     * Affiche la liste des contacts dont le nom commence par la lettre donnée.
     * @param initialeNom Initiale du nom.
     */
    public void afficherContacts(char initialeNom) {
        LinkedList<Contact> listeAAfficher = new LinkedList<>();
        listeAAfficher = rechercherContacts(initialeNom);
        if (listeAAfficher.isEmpty()) {
            System.out.println("Aucun contact dont le nom commence par '" + initialeNom + "' présent dans la liste de contacts. ");
        }
        for (Contact c : listeAAfficher) {
            System.out.println(c.getIdentite());
        }
    }

    /**
     * Affiche les derniers numéros appelés
     */
    public void voirDerniersNumAppeles() {
        if (!listeDerniersNumAppeles.isEmpty()) {
            for (String num : listeDerniersNumAppeles) {
                System.out.println(num);
            }
        } else {
            System.out.println("Liste vide. ");
        }
    }

    /**
     * Permet de vider la liste des derniers numéros appelés.
     */
    public void viderListeDerniersNumAppele() {
        listeDerniersNumAppeles.clear();
    }

    /**
     * Permet de décrire l'état général du téléphone :
     * 	s'il est décrocjé, s'il est en communication
     * 	(et dans ce cas avec quel numéro ou quel contact connu),
     * 	ou s'il est raccroché.
     */
    public String toString(){
        String message;
        if(decroche){
            if(enCommunication){
                Contact c = rechercherContact(numeroCompose);
                if(c==null){
                    message = "Telephone décroché et en communication avec le "
                            + numeroCompose + ".";
                }else{
                    message = "Telephone décroché et en communication avec "
                            + c.getIdentite() + ".";
                }

            }else{
                message = "Telephone décroché.";
            }
        }else{
            message ="Telephone raccroché ";
        }
        return message;
    }
}
