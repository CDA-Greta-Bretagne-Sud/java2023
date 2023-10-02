package fr.cda.projet;

import java.util.ArrayList;

public class Emprunteur {

    private static int nombreEmprunteur = 1;
    private int id;
    private String nomEmprunteur;
    private String prenomEmprunteur;
    private ArrayList<Media> mediaEmprunter;
    private String dateDeNaissance;
    // Liste des identificateurs des médias

    public Emprunteur(String nomEmprunteur, String prenomEmprunteur, String dateDeNaissance) {
        this.mediaEmprunter = new ArrayList<Media>();
        this.nomEmprunteur = nomEmprunteur;
        this.prenomEmprunteur = prenomEmprunteur;
        this.dateDeNaissance = dateDeNaissance;
        this.id = nombreEmprunteur;
        nombreEmprunteur++;
    }

    public Emprunteur(int id, String nom, String prenom, String dateNaissance) {
        this.id = id;
        this.nomEmprunteur = nom;
        this.prenomEmprunteur = prenom;
        this.mediaEmprunter = new ArrayList<Media>();
        this.dateDeNaissance = dateNaissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEmprunteur() {
        return nomEmprunteur;
    }

    public void setNomEmprunteur(String nomEmprunteur) {
        this.nomEmprunteur = nomEmprunteur;
    }

    public String getPrenomEmprunteur() {
        return prenomEmprunteur;
    }

    public void setPrenomEmprunteur(String prenomEmprunteur) {
        this.prenomEmprunteur = prenomEmprunteur;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public ArrayList<Media> getMediaEmprunter() {
        return mediaEmprunter;
    }

    public void setMediaEmprunter(ArrayList<Media> mediaEmprunter) {
        this.mediaEmprunter = mediaEmprunter;
    }

    @Override
    public String toString() {
        return "Emprunteur{" +
                "id=" + id +
                ", nomEmprunteur='" + nomEmprunteur + '\'' +
                ", prenomEmprunteur='" + prenomEmprunteur + '\'' +
                ", mediaEmprunter=" + mediaEmprunter +
                ", dateDeNaissance='" + dateDeNaissance + '\'' +
                '}';
    }
}
