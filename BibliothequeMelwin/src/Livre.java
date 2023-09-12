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

    static Livre creerLivre(){
        String titre, auteur, editeur;
        System.out.println("Veuillez entrer un titre : ");
        titre = Util.scan.nextLine();
        System.out.println("Veuillez entrer un auteur : ");
        auteur = Util.scan.nextLine();
        System.out.println("Veuillez entrer un editeur : ");
        editeur = Util.scan.nextLine();
        if(titre.isEmpty() | auteur.isEmpty() | editeur.isEmpty()){
            System.out.println("Veuillez ne pas laisser de champs vide");
            creerLivre();
        }
        return new Livre(titre,auteur,editeur);
    }

    @Override
    public String toString() {
        return "Titre du livre : " + this.titre + " - Nom de l'auteur : " + this.auteur + " - Nom de l'editeur : " + this.editeur;
    }
}
