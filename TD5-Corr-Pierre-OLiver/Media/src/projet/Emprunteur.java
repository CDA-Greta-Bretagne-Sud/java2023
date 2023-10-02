package projet;

import java.util.ArrayList;
import java.util.List;

public class Emprunteur {
    public static int nombreEmprunteur = 0;
    private int numero;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private List<Media> mediaEmpruntes = new ArrayList<Media>();

    public Emprunteur(int numero, String nom, String prenom, String dateNaissance, List<Media> mediaEmpruntes) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.mediaEmpruntes = mediaEmpruntes;
    }

    public Emprunteur(int numero, String nom, String prenom, String dateNaissance) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public void emprunter(Media m) {
        this.mediaEmpruntes.add(m);
    }

    public static int getNombreEmprunteur() {
        return nombreEmprunteur;
    }

    public static void setNombreEmprunteur(int nombreEmprunteur) {
        Emprunteur.nombreEmprunteur = nombreEmprunteur;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Media> getMediaEmpruntes() {
        return mediaEmpruntes;
    }

    public void setMediaEmpruntes(List<Media> mediaEmpruntes) {
        this.mediaEmpruntes = mediaEmpruntes;
    }

    @Override
    public String toString() {
        return

                prenom + " " + nom;
    }
}
