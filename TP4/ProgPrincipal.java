public class ProgPrincipal {

    public static void main(String[] bonjour) {

        Ecran ecran = null;
        try {
            ecran = new Ecran(10, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ecran != null) {
            //Allumer l'écran et le dessiner
            ecran.toutAllumer();
            ecran.dessinerEcran();

            //Éteindre l'écrant et le dessiner.
            ecran.toutEteindre();
            ecran.dessinerEcran();

            ecran.toutAllumer();


            boolean isNotGrillee = true;
            while (isNotGrillee) {
                try {
                    isNotGrillee = ecran.changerEtat(3, 4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            Ampoule nouvelAmpoule = new Ampoule();
            try {
                ecran.changerAmpoule(3, 4, nouvelAmpoule);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                ecran.changerEtat(3, 4);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ecran.faireClignoter(150);
            ecran.toutAllumer();

            System.out.println();
            ecran.dessinerEcran();
        }


    }

}
