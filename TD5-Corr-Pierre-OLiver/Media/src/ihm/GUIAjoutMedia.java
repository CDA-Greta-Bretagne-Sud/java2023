package ihm;

import projet.GUISite;
import projet.Media;
import projet.Mediatheque;
import util.SaveToFile;

import javax.swing.*;

import java.io.IOException;

import static util.SaveToFile.writeToFile;

public class GUIAjoutMedia implements FormulaireInt {
    private GUISite formPP; // Le formulaire principal du programme
    private Mediatheque m;

    public GUIAjoutMedia(GUISite formPP, Mediatheque m) {
        this.formPP = formPP;
        this.m = m;
        Formulaire form = new Formulaire("Ajout Media", this, 420, 380);
        form.setPosition(20, 10);
        form.addZoneText("ID", "Nom", true, "", 200, 50);
        form.addZoneText("CATEGORIE", "Categorie", true, "", 200, 50);
        form.addZoneText("SOUSCATEGORIE", "Sous-Categorie", true, "", 200, 50);
        form.addZoneText("DESCRIPTION", "Description", true, "", 200, 50);
        form.addButton("SUBMIT", "Ajouter Media");
        form.afficher();
    }

    @Override
    public void submit(Formulaire form, String nom) throws IOException {
        if (nom.equals("SUBMIT")) {
            String id = form.getValeurChamp("ID");
            String categorie = form.getValeurChamp("CATEGORIE");
            String sousCategorie = form.getValeurChamp("SOUSCATEGORIE");
            String description = form.getValeurChamp("DESCRIPTION");

            if (id != null && !id.isEmpty() &&
                    categorie != null && !categorie.isEmpty() &&
                    sousCategorie != null && !sousCategorie.isEmpty() &&
                    description != null && !description.isEmpty()) {
                Media nouveauMedia = new Media(id, categorie, sousCategorie, description);
                m.addMedia(nouveauMedia);
                JOptionPane.showMessageDialog(null, "Media ajouté avec succès!");
                formPP.submit(form, nom);
                formPP.updateAffMediaInscrits();
                writeToFile(m.getEmprunteurs(), m.getMedias(), "data.txt");
                form.fermer();
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs!");
            }
        }
    }

    public GUISite getFormPP() {
        return formPP;
    }

    public void setFormPP(GUISite formPP) {
        this.formPP = formPP;
    }

    public Mediatheque getM() {
        return m;
    }

    public void setM(Mediatheque m) {
        this.m = m;
    }
}
