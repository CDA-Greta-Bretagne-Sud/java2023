import java.util.Scanner;

public class Livre {

    private String titre;
    private String auteur;
    private String editeur;

    public Livre(String titre, String auteur, String editeur) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                '}';
    }

    public static Livre saisirLivre() throws SaisieInvalide {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le titre du livre:");
        String titre = scanner.nextLine();
        if (titre.trim().isEmpty()) {
            throw new SaisieInvalide("Le titre ne peut pas être vide.");
        }

        System.out.println("Entrez le nom de l'auteur:");
        String auteur = scanner.nextLine();
        if (auteur.trim().isEmpty()) {
            throw new SaisieInvalide("Le nom de l'auteur ne peut pas être vide.");
        }

        System.out.println("Entrez le nom de l'éditeur:");
        String editeur = scanner.nextLine();
        if (editeur.trim().isEmpty()) {
            throw new SaisieInvalide("Le nom de l'éditeur ne peut pas être vide.");
        }

        Livre livre = new Livre(titre, auteur, editeur);

        // Affichage des informations du livre ajouté
        System.out.println("\nNouveau livre ajouté: ");
        System.out.println("Titre: " + livre.getTitre());
        System.out.println("Auteur: " + livre.getAuteur());
        System.out.println("Editeur: " + livre.getEditeur() + "\n");

        return livre;
    }

}
