package fr.cda.projet;
import fr.cda.ihm.Formulaire;
import fr.cda.util.*;
import fr.cda.util.Terminal;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mediatheque {
    private ArrayList<Media> medias;
    private ArrayList<Emprunteur> emprunteurs;
    private int countMedia;

    public Mediatheque() {
        this.medias = new ArrayList<Media>();
        this.emprunteurs = new ArrayList<Emprunteur>();
        this.countMedia++;
    }

    public void ajouterMedia(String categorie, String sousCategorie, String description) {
        Terminal.ecrireStringln("Saisir une catégorie : ");
        this.medias.add(new Media(categorie, sousCategorie, description));
        this.countMedia++;
    }
    public String ajouterInscrit(Emprunteur e) {
        this.emprunteurs.add(e);
        return e.toString();
    }
    public String afficher() {
        StringBuilder infos = new StringBuilder();

        // Affichage des médias
        infos.append("Liste des médias\n");
        infos.append("===============================================>\n");

        for (int i = 0; i < this.medias.size(); i++) {
            infos.append("Id : ").append(medias.get(i).getIdentificateur()).append(" | ");
            infos.append("Catégorie : ").append(medias.get(i).getCategorie()).append(" | ");
            infos.append("Sous-catégorie : ").append(medias.get(i).getSousCategorie()).append(" | ");
            infos.append("Description : ").append(medias.get(i).getDescription()).append(" \n");
        }

        infos.append("\n");

        // Affichage des emprunteurs
        infos.append("Liste des emprunteurs\n");
        infos.append("===============================================>\n");

        for (int i = 0; i < this.emprunteurs.size(); i++) {
            infos.append("Id : ").append(emprunteurs.get(i).getId()).append(" | ");
            infos.append("Nom : ").append(emprunteurs.get(i).getNomEmprunteur()).append(" | ");
            infos.append("Prénom : ").append(emprunteurs.get(i).getPrenomEmprunteur()).append(" | ");
            infos.append("Date de naissance : ").append(emprunteurs.get(i).getDateDeNaissance()).append("\n");
        }

        return infos.toString();
    }
    public void _afficher() {

        for (int i = 0; i < this.medias.size(); i++) {
            Terminal.ecrireString("Id : " + medias.get(i).getIdentificateur());
            Terminal.ecrireString(" | Catégorie : " + medias.get(i).getCategorie());
            Terminal.ecrireStringln(" | Sous-catégorie : " + medias.get(i).getSousCategorie());
        }
        Terminal.ecrireStringln("");
        // Affichage des emprunteurs
        Terminal.ecrireStringln("Liste des emprunteurs");
        Terminal.ecrireStringln("===============================================>");

        for (int i = 0; i < this.emprunteurs.size(); i++) {
            Terminal.ecrireString("Id : " + emprunteurs.get(i).getId());
            Terminal.ecrireString(" | Nom : " + emprunteurs.get(i).getNomEmprunteur());
            Terminal.ecrireString(" | Prénom : " +  emprunteurs.get(i).getPrenomEmprunteur());
            Terminal.ecrireStringln(" | Date de naissasnce : " + emprunteurs.get(i).getDateDeNaissance());
        }
    }
    /*
    Recherche ds inscits par lettres
     */
    public String rechercheInscrit(String recherche) {
        StringBuilder inscrits = new StringBuilder();

        for (int i = 0; i < this.emprunteurs.size(); i++) {

            if (emprunteurs.get(i).getNomEmprunteur().toLowerCase().contains(recherche) ||
                    emprunteurs.get(i).getPrenomEmprunteur().toLowerCase().contains(recherche)) {
                inscrits.append("Id : " + emprunteurs.get(i).getId());
                inscrits.append(" Nom : " + emprunteurs.get(i).getNomEmprunteur());
                inscrits.append(" Prénom :  " + emprunteurs.get(i).getPrenomEmprunteur());
                inscrits.append(" Date de naissance : " + emprunteurs.get(i).getDateDeNaissance());
            }
        }
        return inscrits.toString();
    }

    public Emprunteur rendre(Formulaire form) {
        Emprunteur emprunteurChoisi = null;
        // Cherhcer si l'emprunteur est dans la liste
        for (Emprunteur emprunteur : this.emprunteurs) {

            if (form.getValeurChamp("LISTE_INSCRITS").equals(emprunteur.toString())) {
                System.out.println("rer");
                emprunteurChoisi = emprunteur;
            }
        }
        return emprunteurChoisi;
    }
    public Emprunteur emprunter(Formulaire formulaire) {
        Media mediaChoisi = null;
        Emprunteur emprunteurChoisi = null;
        String id = "";
        // chercher si le media est dans la liste
        for (Media media : this.medias) {

            if (formulaire.getValeurChamp("MEDIAS").equals(media.toString())) {
                System.out.println("yzyz");
                mediaChoisi = media;
                break;
            }
        }
        // Cherhcer si l'emprunteur est dans la liste
        for (Emprunteur emprunteur : this.emprunteurs) {

            if (formulaire.getValeurChamp("INSCRITS").equals(emprunteur.toString())) {
                System.out.println("rer");
                emprunteurChoisi = emprunteur;
            }
        }

        if (mediaChoisi == null) {
            formulaire.setValeurChamp("RESULTATS", "Média introuvable");

        } else {
            // Étape 4 : Emprunt du média {
            mediaChoisi.setDateEmprunt(java.time.LocalDate.now().toString());
            mediaChoisi.setNumeroEmprunter(emprunteurChoisi.getId());
            emprunteurChoisi.getMediaEmprunter().add(mediaChoisi);
        }
        return emprunteurChoisi;
    }

    public void emprunterModeConsole() {
        Scanner scanner = new Scanner(System.in);
        Emprunteur emprunteurChoisi = null;
        Media mediaChoisi = null;
        // Étape 1 : Recherche de l'emprunteur
        Terminal.ecrireString("Recherche de l'emprunteur (nom ou prénom) : ");
        String recherche = scanner.nextLine().toLowerCase();

        for (int i = 0; i < this.emprunteurs.size(); i++) {

            if (emprunteurs.get(i).getNomEmprunteur().toLowerCase().contains(recherche) ||
                    emprunteurs.get(i).getPrenomEmprunteur().toLowerCase().contains(recherche)) {
                Terminal.ecrireStringln(emprunteurs.get(i).getId() + ". " + emprunteurs.get(i).getNomEmprunteur() + " " + emprunteurs.get(i).getPrenomEmprunteur());
            }
        }


        // Étape 2 : Sélection de l'emprunteur
        Terminal.ecrireStringln("");
        Terminal.ecrireStringln("=================================================");
        Terminal.ecrireStringln("Saisissez le numéro d'inscription de l'emprunteur choisi : ");
        int numeroInscription = scanner.nextInt();

        for (Emprunteur emprunteur : this.emprunteurs) {

            if (emprunteur.getId() == numeroInscription) {
                emprunteurChoisi = emprunteur;
                break;
            }
        }

        if (emprunteurChoisi == null) {
            System.out.println("Emprunteur non trouvé.");
            return;
        }

        // Étape 3 : Recherche du média
        Terminal.ecrireStringln("=================================================");
        Terminal.ecrireStringln("");
        // on affiche les médias
        for (Media media : this.medias) {
            Terminal.ecrireString(media.getIdentificateur());
            Terminal.ecrireString(" | " + media.getCategorie());
            Terminal.ecrireString(" | " +media.getSousCategorie());
            Terminal.ecrireString(" | " +media.getDateEmprunt());
            Terminal.ecrireStringln(" | " +media.getDescription());
        }
        Terminal.ecrireString("Recherche du média (identificateur) : ");
        String recherche2 = scanner.next();
        // On boucle sur les médias
        for (Media media : this.medias) {

            if (media.getIdentificateur().equals(recherche2)) {
                mediaChoisi = media;
                break;
            }
        }

        if (mediaChoisi == null) {
            Terminal.ecrireStringln("Média non trouvé.");
            return;
        } else if (!emprunteurChoisi.getMediaEmprunter().contains(mediaChoisi)) {
            // Étape 4 : Emprunt du média {
            mediaChoisi.setDateEmprunt(java.time.LocalDate.now().toString());
            mediaChoisi.setNumeroEmprunter(emprunteurChoisi.getId());
            emprunteurChoisi.getMediaEmprunter().add(mediaChoisi);
            Terminal.ecrireStringln("Le média a été emprunté avec succès par " + emprunteurChoisi.getNomEmprunteur());
        } else if (mediaChoisi.getNumeroEmprunter() != 0) {
            Terminal.ecrireStringln("Le média est déjà emprunté!");
        } else {
            Terminal.ecrireStringln("Vous avez déjà emprunté le média!");
        }
    }
    public ArrayList<Media> getMedias() {
        return medias;
    }

    public void setMedias(ArrayList<Media> medias) {
        this.medias = medias;
    }

    public ArrayList<Emprunteur> getEmprunteurs() {
        return emprunteurs;
    }

    public void setEmprunteurs(ArrayList<Emprunteur> emprunteurs) {
        this.emprunteurs = emprunteurs;
    }

    public int getCountMedia() {
        return countMedia;
    }

    public void setCountMedia(int countMedia) {
        this.countMedia = countMedia;
    }
}
