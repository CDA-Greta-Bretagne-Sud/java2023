public class Livre {
    private String titre;
    private String auteur;
    private String editeur;

    public Livre() {
    }

    public Livre(String titre, String auteur, String editeur) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
    }

    // Création d'un livre
    public void creerLivre() {
        System.out.print("Entrez le titre du livre : ");
        this.titre = Util.scan.nextLine();

        System.out.print("Entrez le nom de l'auteur : ");
        this.auteur = Util.scan.nextLine();

        System.out.print("Entrez le nom de l'éditeur : ");
        this.editeur = Util.scan.nextLine();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public void afficherInformations() {
        System.out.println("Titre: " + titre);
        System.out.println("Auteur: " + auteur);
        System.out.println("Éditeur: " + editeur);
    }
}
