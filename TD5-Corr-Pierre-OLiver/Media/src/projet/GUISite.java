package projet;

import ihm.*;

import java.io.IOException;

import static util.SaveToFile.writeToFile;

// Classe de definition de l'IHM principale de l'application mediatheque
//
public class GUISite implements FormulaireInt {
    private Mediatheque mediatheque;  // la mediatheque
    private Formulaire form;

    // Constructeur
    //
    public GUISite(Mediatheque m) {
        this.mediatheque = m;
        this.form = new Formulaire("Mediatheque", this, 1100, 730);
        // Creation du formulaire

        //  Creation des elements de l'IHM
        //
        form.setPosition(20, 10);
        form.addLabel("Afficher tous les medias et inscrits");
        form.addButton("AFF_MEDIAINSCRITS", "Tous les médias et inscrits");
        form.addLabel("");
        form.addLabel("Ajouter un inscrit");
        form.addButton("AJOUT_INSCRIT", "Ajouter un inscrit");
        form.addLabel("");
        form.addLabel("Ajouter un Media");
        form.addButton("AJOUT_MEDIA", "Ajouter un media");
        form.addLabel("");
        form.addLabel("Déclarer un emprunt");
        form.addButton("EMPRUNT", "Déclarer un emprunt");
        form.addLabel("");
        form.addLabel("Rendre un média");
        form.addButton("RENDU", "Rendre un média");
        form.addLabel("");
        form.addZoneText("RECMEDIAFIELD", "Rechercher un Média", true, "", 200, 50);
        form.addButton("RECMEDIA", "Rechercher ");
        form.addLabel("");
        form.addZoneText("RECEMPRFIELD", "Rechercher un Emprunteur", true, "", 200, 50);
        form.addButton("RECEMPR", "Rechercher ");
        form.addLabel("");

        form.setPosition(20, 650);
        form.addButton("FERMER", "FERMER");
        form.setPosition(350, 0);
        form.addZoneText("RESULTATS", "Resultats",
                true,
                "",
                600, 700);

        // Affichage du formulaire
        form.afficher();
    }

    // Methode appellee quand on clique dans un bouton
    //
    public void updateAffMediaInscrits() {
        StringBuilder sb = new StringBuilder();

        sb.append("Médias:\n");
        for (Media media : mediatheque.medias) {
            sb.append(media.toString()).append("\n");
        }
        sb.append("\n------------------\n\n");
        sb.append("Emprunteurs:\n");
        for (Emprunteur emprunteur : mediatheque.emprunteurs) {
            sb.append(emprunteur.toString()).append("\n");
        }
        String res = sb.toString();
        form.setValeurChamp("RESULTATS", res);
    }

    public void submit(Formulaire form, String nomSubmit) {

        // Affichage de tous les medias et inscrits
        if (nomSubmit.equals("AFF_MEDIAINSCRITS")) {
            updateAffMediaInscrits();
        }
        // Ajout inscript
        //

        if (nomSubmit.equals("AJOUT_INSCRIT")) {
            GUIAjoutInscrit g = new GUIAjoutInscrit(this, mediatheque);
        }

        // Ajout media
        //
        if (nomSubmit.equals("AJOUT_MEDIA")) {
            GUIAjoutMedia m = new GUIAjoutMedia(this, mediatheque);
        }

        if (nomSubmit.equals("EMPRUNT")) {
            GUIEmprunt z = new GUIEmprunt(this, mediatheque);

        }
        if (nomSubmit.equals("RENDU")) {
            GUIRendu z = new GUIRendu(this, mediatheque);
        }
        if (nomSubmit.equals("RECMEDIA")) {

        }
        if (nomSubmit.equals("RECEMPR")) {

        }
        // fermer
        //
        if (nomSubmit.equals("FERMER")) {
            try {
                writeToFile(mediatheque.emprunteurs, mediatheque.medias, "data.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            form.fermer();
            System.exit(0);
        }

    }
}