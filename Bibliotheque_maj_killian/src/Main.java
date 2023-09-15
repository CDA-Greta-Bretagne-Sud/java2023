import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Combien de livres souhaitez-vous créer et ajouter à la bibliothèque ?");
        int nombreDeLivresAAjouter = Util.scan.nextInt();
        Util.scan.nextLine();

        // Création d'une bibliothèque avec une capacité maximale de 10 livres
        Bibliotheque bibliotheque = new Bibliotheque(10);

        for (int i = 0; i < nombreDeLivresAAjouter; i++) {
            Livre livre = new Livre();
            livre.creerLivre();
            bibliotheque.ajouterLivre(livre);

            // On appuie sur entrée pour passer au livre suivant
            System.out.println("Appuyez sur Enter pour ajouter un autre livre...");
            Util.scan.nextLine();
        }

        // Affichage du contenu de la bibliothèque
        bibliotheque.afficherContenu();

        // Recherche d'un livre par titre
//        System.out.println("Entrez le titre du livre que vous souhaitez rechercher :");
//        String titreRecherche = Util.scan.nextLine();
//        Livre livreTrouve = bibliotheque.chercherLivreParTitre(titreRecherche);
//
//        if (livreTrouve != null) {
//            System.out.println("Livre trouvé :");
//            livreTrouve.afficherInformations();
//        } else {
//            System.out.println("Livre non trouvé dans la bibliothèque.");
//        }

        // Par auteur
//        System.out.println("Entrez l'auteur du livre que vous souhaitez rechercher :");
//        String auteurRecherche = Util.scan.nextLine();
//        Livre livreTrouveA = bibliotheque.chercherLivreParAuteur(auteurRecherche);
//
//        if (livreTrouveA != null) {
//            System.out.println("Livre trouvé :");
//            livreTrouveA.afficherInformations();
//        } else {
//            System.out.println("Livre non trouvé dans la bibliothèque.");
//        }

        // Par éditeur
//        System.out.println("Entrez l'auteur du livre que vous souhaitez rechercher :");
//        String editeurRecherche = Util.scan.nextLine();
//        Livre livreTrouveE = bibliotheque.chercherLivreParEditeur(editeurRecherche);
//
//        if (livreTrouveE != null) {
//            System.out.println("Livre trouvé :");
//            livreTrouveE.afficherInformations();
//        } else {
//            System.out.println("Livre non trouvé dans la bibliothèque.");
//        }

        // Modification d'un livre par titre
        System.out.println("Entrez le titre du livre que vous souhaitez modifier :");
        String titreModification = Util.scan.nextLine();
        bibliotheque.modifierLivreParTitre(titreModification);

        // Affichage de la bibliothèque après modification
        bibliotheque.afficherContenu();

        // Suppression d'un livre avec le titre
//        System.out.println("Entrez le titre du livre que vous souhaitez supprimer :");
//        String titreSuppression = Util.scan.nextLine();
//        boolean livreSupprime = bibliotheque.supprimerLivreParTitre(titreSuppression);
//
//        if (livreSupprime) {
//            System.out.println("Livre supprimé avec succès.");
//        } else {
//            System.out.println("Livre non trouvé dans la bibliothèque. Aucune suppression effectuée.");
//        }
//
//        // Affichage de la bibliothèque après suppression
//        bibliotheque.afficherContenu();
    }
}