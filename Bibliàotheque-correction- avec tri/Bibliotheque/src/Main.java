import java.util.Arrays;

public class Main {
    public static void main(String[] tutu) {
        Util.logger.warn("Début du prog!");

        //initialisation du nbre de livres présents dans la bibliotheque
        Bibliotheque.nbLivresPresents = 0;

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
                if (i != n - 1) {
                    System.out.println("Tapez entrer pour continuer!");
                }
                i++;
            } catch (LivreException e) {
                Util.logger.warn("Erreur à la création du livre!");
            }

        }
        //affichage de la Bib
        System.out.println(Bibliotheque.inString());
        try {
            //recherche
            int recherche[] = new int[Bibliotheque.nbLivresPresents];
            recherche = Bibliotheque.rechercheLivre();
            Util.logger.info("Résultat Recherche détail du livre:" + Arrays.toString(recherche));
            for (int l : recherche) {
                //on vérifie de ne pas lire les index -1
                // correspondant à l'initialisation du tableau de recherche Bibliotheque.initTab
                if (l != -1) {
                    Util.logger.info("Index:" + l + " - " + Bibliotheque.bib[l].toString());
                }
            }
            //suppression livre
            System.out.println("Recherche pour Suppression du Livre!");
            // recherche du livre à supprimer

            recherche = Bibliotheque.rechercheLivre();
            Util.logger.info("Résultat Recherche pour suppression:" + Arrays.toString(recherche));
            for (int l : recherche) {
                //on vérifie de ne pas lire les index -1

                if (l != -1) {
                    Util.logger.info("Index:" + l + " - " + Bibliotheque.bib[l].toString());
                    //suppression du livre ou des livres
                    Bibliotheque.bib[l] = Bibliotheque.bib[Bibliotheque.nbLivresPresents - 1];
                    // on décremente le nbre de livres
                    Bibliotheque.nbLivresPresents--;
                    System.out.println("Livre index " + l + " supprimé!");
                }
            }
            //recherche pour edition
            System.out.println("Recherche pour Mise à jour d'un Livre!");
            recherche = Bibliotheque.rechercheLivre();
            Util.logger.info("Résultat Recherche pour update:" + Arrays.toString(recherche));
            for (int l : recherche) {
                //on vérifie de ne pas lire les index -1
                if (l != -1) {
                    Util.logger.info("Index:" + l + " - " + Bibliotheque.bib[l].toString());
                    //edition  du livre ou des livres
                    System.out.print("nouveau Titre:");
                    String t = Util.scan.nextLine();
                    if (!t.isEmpty()) {
                        Bibliotheque.bib[l].setTitre(t);
                    }
                    System.out.print("nouvelle edition:");
                    String e = Util.scan.nextLine();
                    if (!e.isEmpty()) {
                        Bibliotheque.bib[l].setEditeur(e);
                    }
                    System.out.print("nouvel auteur:");
                    String a = Util.scan.nextLine();
                    if (!a.isEmpty()) {
                        Bibliotheque.bib[l].setAuteur(a);
                    }

                    System.out.println("Livre index " + l + " mis à jour!");
                }
            }
            // Tri de la Bibliotheque par Titre
            System.out.println("Tri Bib par titre!");
             Arrays.sort(Bibliotheque.bib, CompareLivre.TitreComparator );
            System.out.println(Bibliotheque.inString());
            // Tri de la Bibliotheque par Auteur
            System.out.println("Tri Bib par auteur!");
            Arrays.sort(Bibliotheque.bib, CompareLivre.AuteurComparator);
            System.out.println(Bibliotheque.inString());
            // Tri de la Bibliotheque par Editeur
            System.out.println("Tri Bib par editeur!");
            Arrays.sort(Bibliotheque.bib, CompareLivre.EditeurComparator );
            System.out.println(Bibliotheque.inString());
        } catch (LivreException e) {
            Util.logger.warn("Erreur recherche du livre!");
        }

    }
}


