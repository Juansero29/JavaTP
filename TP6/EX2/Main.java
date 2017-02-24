public class Main {
	public static void main(String[] args) throws Exception {
		Telephone tel = new Telephone();

		tel.decrocher();
		System.out.println(tel);
		try {
			tel.composer("6666666");
		} catch (Exception e) {
			e.printStackTrace();
		}
		tel.voirDerniersNumAppeles();
		System.out.println(tel);
		tel.decrocher();
		System.out.println(tel);
		tel.raccrocher();
		System.out.println(tel);
		try {
			tel.composer("66666666");
		} catch (Exception e) {
			e.printStackTrace();
		}
		tel.decrocher();
		tel.raccrocher();
		System.out.println("liste des derniers numéros appelés : ");
		tel.voirDerniersNumAppeles();
		try{
			tel.ajouterNouveauContact("Dupond", "Jean", "0102030405");
			tel.ajouterNouveauContact("Durand", "Pierre", "0908070605");
			tel.ajouterNouveauContact("Martin", "0908070605");
			tel.ajouterNouveauContact("Toto", "0102030405");
		}catch(Exception e){
			e.printStackTrace();  /// ne devrait pas arriver
		}
		System.out.println("liste des contacts commençant par T : ");
		tel.afficherContacts('T');
		tel.supprimerContact("Toto", null);
		System.out.println("liste des contacts commençant par T (après suppression de Toto) : ");
		tel.afficherContacts('T');

		System.out.println("liste des contacts commençant par D : ");
		tel.afficherContacts('D');
		System.out.println("liste des contacts commençant par M : ");
		tel.afficherContacts('M');
		System.out.println("liste des contacts commençant par C : ");
		tel.afficherContacts('C');

		System.out.println("le numero 0908070605 correspond à : ");
		tel.afficherContact("0908070605");

		System.out.println("le numero 0908070604 correspond à : ");
		tel.afficherContact("0908070604");

		tel.composer("0908070605");
		tel.decrocher();
		System.out.println(tel);
		tel.raccrocher();
		System.out.println(tel);
		tel.decrocher();
		System.out.println(tel);
		tel.decrocher();
		System.out.println(tel);
		tel.raccrocher();
		System.out.println(tel);
		tel.viderListeDerniersNumAppele();
		tel.decrocher();
		System.out.println(tel);
	}
}
