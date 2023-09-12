public class Main {
    public static void main(String[] tutu) {
        Util.logger.warn("Début du prog!");

        //initialisation du nbre de livres présents dans la bibliotheque
        Bibliotheque.nbLivresPresents=0;

        System.out.print("Combien de livres voulez-vous saisir:");
        int n = Util.scan.nextInt();
        int i = 0;
        while (i < n) {
            Livre l = new Livre();

            try {
                Util.scan.nextLine();
                //enregistrement du livre
                l.ecrireLivre();
                //ajout du livre dans la Bib
                Bibliotheque.ajoutLivre(l);
                //affichage du livre
               System.out.println(l.toString());
               if(i!=n-1) {
                   System.out.println("Tapez entrer pour continuer!");
               }
               i++;
            } catch (LivreException e) {
                Util.logger.warn("Erreur à la création du livre!");
            }

        }
        //affichage de la Bib
        System.out.println(Bibliotheque.inString());
    }
}


