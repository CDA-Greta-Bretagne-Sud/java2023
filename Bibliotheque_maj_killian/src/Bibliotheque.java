import java.util.Scanner;

public class Bibliotheque {
    private Livre[] livres;
    private int nombreDeLivres;

    public Bibliotheque(int capaciteMaximale) {
        livres = new Livre[capaciteMaximale];
        nombreDeLivres = 0;
    }

    // Ajoute d'un livre à la bibliothèque
    public void ajouterLivre(Livre livre) {
        if (nombreDeLivres < livres.length) {
            livres[nombreDeLivres] = livre;
            nombreDeLivres++;
        } else {
            System.out.println("La bibliothèque est pleine. Impossible d'ajouter un nouveau livre.");
        }
    }

    // Rhercher un livre par son titre
    public Livre chercherLivreParTitre(String titre) {
        for (int i = 0; i < nombreDeLivres; i++) {
            if (livres[i].getTitre().equalsIgnoreCase(titre)) {
                return livres[i];
            }
        }
        return null; // Livre non trouvé
    }

    // Avec l'auteur
    public Livre chercherLivreParAuteur(String titre) {
        for (int i = 0; i < nombreDeLivres; i++) {
            if (livres[i].getAuteur().equalsIgnoreCase(titre)) {
                return livres[i];
            }
        }
        return null;
    }

    // Avec l'éditeur
    public Livre chercherLivreParEditeur(String titre) {
        for (int i = 0; i < nombreDeLivres; i++) {
            if (livres[i].getEditeur().equalsIgnoreCase(titre)) {
                return livres[i];
            }
        }
        return null;
    }

    // Suppression d'un livre par son titre
    public boolean supprimerLivreParTitre(String titre) {
        for (int i = 0; i < nombreDeLivres; i++) {
            if (livres[i].getTitre().equalsIgnoreCase(titre)) {
                // Demander confirmation avant de supprimer
                System.out.println("Êtes-vous sûr de vouloir supprimer ce livre ? (Appuyez sur Enter pour confirmer)");
                Scanner scanner = Util.scan;
                String confirmation = scanner.nextLine();
                if (confirmation.isEmpty()) {
                    // Confirmation de la suppression
                    // On décale les livres d'après pour remplir l'espace
                    for (int j = i; j < nombreDeLivres - 1; j++) {
                        livres[j] = livres[j + 1];
                    }
                    livres[nombreDeLivres - 1] = null;
                    nombreDeLivres--;
                    return true; // Le livre est supprimé
                } else {
                    System.out.println("Suppression annulée.");
                    return false; // Suppression annulée
                }
            }
        }
        return false; // Livre non trouvé, pas de suppression
    }

    // Méthode pour modifier un livre par son titre
    public boolean modifierLivreParTitre(String titre) {
        Livre livreAModifier = chercherLivreParTitre(titre);
        if (livreAModifier != null) {
            Scanner scanner = Util.scan;
            System.out.println("Entrez le nouveau titre :");
            String nouveauTitre = scanner.nextLine();
            System.out.println("Entrez le nouvel auteur :");
            String nouveauAuteur = scanner.nextLine();
            System.out.println("Entrez le nouvel éditeur :");
            String nouvelEditeur = scanner.nextLine();

            // Mettre à jour les informations du livre
            livreAModifier.setTitre(nouveauTitre);
            livreAModifier.setAuteur(nouveauAuteur);
            livreAModifier.setEditeur(nouvelEditeur);

            System.out.println("Le livre a bien été modifié.");
            return true;
        } else {
            System.out.println("Livre non trouvé. Aucune modification.");
            return false;
        }
    }

    // TODO tri par titre

    // TODO tri par auteur

    // TODO tri par éditeur

    // Affichage du contenu de la bibliothèque
    public void afficherContenu() {
        if (nombreDeLivres == 0) {
            System.out.println("La bibliothèque est vide.");
        } else {
            System.out.println("Contenu de la bibliothèque :");
            for (int i = 0; i < nombreDeLivres; i++) {
                System.out.println("Livre " + (i + 1) + ":");
                livres[i].afficherInformations();
                System.out.println();
            }
        }
    }
}
