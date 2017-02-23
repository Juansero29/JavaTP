class MainVoiture {
	public static void main(String[] args) {
		
		Voiture v = new Voiture("rouge", 180, 5);
		System.out.println(v);
		try {
			v.monterEnVoiture(new Personne("Dupond", "Thony"));
			v.demarrer();
			System.out.println(v);
			v.accelerer(50);
			System.out.println(v);
			v.freiner(50);
			System.out.println(v);
			v.monterEnVoiture(new Personne("Durand", "Pierre"));
			System.out.println(v);
			v.eteindre();
			System.out.println(v);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}	
}
