package fr.cda.projet;

import fr.cda.ihm.*;

import java.io.IOException;

// Classe de definition de l'IHM principale de l'application mediatheque
//
public class GUISite implements FormulaireInt
{
    private JSONFile file;
    private Mediatheque mediatheque;  // la mediatheque

    // Constructeur
    //
    public GUISite(Mediatheque m) {
        this.mediatheque = m;
        this.file = new JSONFile("fichier.json");

        // Creation du formulaire
        Formulaire form = new Formulaire("Mediatheque",this,1100,900);
        
        //  Creation des elements de l'IHM
        //
        form.setPosition(20,10);
        form.addLabel("Afficher tous les medias et inscrits");
        form.addButton("AFF_MEDIAINSCRITS","Tous les médias et inscrits");
        form.addLabel("Afficher tous les emprunts");
        form.addLabel("");
        form.addLabel("Ajouter un inscrit");
        form.addButton("AJOUT_INSCRIT","Ajouter un inscrit");
        form.addLabel("");
        form.addLabel("Ajouter un Media");
        form.addButton("AJOUT_MEDIA","Ajouter un media");
        form.addLabel("");
        form.addText("RechercheInscrit", "Recherche des inscrits : ", true, "");
        form.addButton("RECHERCHE_INSCRIT", "Recherher");
        form.addLabel("");
        form.addButton("EMPRUNTER", "Emprunter");
        form.addButton("RENDRE", "Rendre un livre");
        form.addLabel("");
        form.addButton("SAUVEGARDER", "Sauvegarder");
        form.addButton("OUVRIR", "Ouvrir");
        form.setPosition(20,650);
        form.addButton("FERMER","FERMER");
        form.setPosition(350,0);
        form.addZoneText("RESULTATS","Resultats",
                            true,
                            "",
                            900,700);

        // Affichage du formulaire
        form.afficher();
    }
    // Methode appellee quand on clique sur un bouton
    //
    public void submit(Formulaire form, String nomSubmit) {
        // Affichage de tous les medias et inscrits
        //
        if (nomSubmit.equals("AFF_MEDIAINSCRITS")) {
            String res = this.mediatheque.afficher();
            form.setValeurChamp("RESULTATS",res);
        }
        // Ajout inscript
        //
        if (nomSubmit.equals("AJOUT_INSCRIT")) {
                GUIAjoutinscrit ajoutinscrit = new GUIAjoutinscrit(this, mediatheque);
        }
        // Ajout media
        //
        if (nomSubmit.equals("AJOUT_MEDIA")) {
            GUIAjoutMedia ajoutMedia = new GUIAjoutMedia(this, mediatheque);
        }
        // fermer
        //
        if (nomSubmit.equals("FERMER")) {
             form.fermer();
        }
        // Rechercher inscrit
        if (nomSubmit.equals("RECHERCHE_INSCRIT")) {
            String res = this.mediatheque.rechercheInscrit(form.getValeurChamp("RechercheInscrit"));
            form.setValeurChamp("RESULTATS", res);
        }
        // Emprunter un livre
        if (nomSubmit.equals("EMPRUNTER")) {
            GUIEmprunt guiEmprunt = new GUIEmprunt(this, mediatheque);
        }
        if (nomSubmit.equals("RENDRE")) {
            GUIRendreChoixInscrit rendre = new GUIRendreChoixInscrit(this, mediatheque);
        }
        if (nomSubmit.equals("SAUVEGARDER")) {
            try {
                this.file.writeFile(mediatheque.getMedias(), mediatheque.getEmprunteurs());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (nomSubmit.equals("OUVRIR")) {
            String contenu = "";
            // On récpère les medias
            try {
                for (Media media : this.file.readFile().getMedias()) {
                    contenu += media.toString() + "\n";
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // Onrécupère les inscrits
            try {

                for (Emprunteur emprunteur : this.file.readFile().getEmprunteurs()) {
                    contenu += emprunteur.toString() + "\n";
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            form.setValeurChamp("RESULTATS", contenu);
        }
    }
}