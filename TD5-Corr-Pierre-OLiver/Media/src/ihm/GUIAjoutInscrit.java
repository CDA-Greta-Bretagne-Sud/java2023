package ihm;

import projet.Emprunteur;
import projet.GUISite;
import projet.Mediatheque;

import javax.swing.*;

import java.io.IOException;

import static util.SaveToFile.writeToFile;

public class GUIAjoutInscrit implements FormulaireInt {
    private GUISite formPP; // Le formulaire principal du programme
    private Mediatheque m;

    public GUIAjoutInscrit(GUISite formPP,
                           Mediatheque m) {
        this.formPP = formPP;
        this.m = m;
        Formulaire form = new Formulaire("Ajout Emprunteur", this, 320, 300);
        form.setPosition(20, 10);
        form.addZoneText("PRENOM", "Prenom", true, "", 200, 50);
        form.addZoneText("NOM", "Nom", true, "", 200, 50);
        form.addZoneText("DATE_NAISSANCE", "Date de Naissance", true, "jj/mm/aaaa", 200, 50);
        form.addButton("SUBMIT", "Ajouter Emprunteur");
        form.afficher();
    }

    @Override
    public void submit(Formulaire form, String nom) throws IOException {
        if (nom.equals("SUBMIT")) {
            String prenom = form.getValeurChamp("PRENOM");
            String nomDeFamille = form.getValeurChamp("NOM");
            String dateNaissance = form.getValeurChamp("DATE_NAISSANCE");

            if (prenom != null && !prenom.isEmpty() &&
                    nomDeFamille != null && !nomDeFamille.isEmpty() &&
                    dateNaissance != null && !dateNaissance.isEmpty()) {

                Emprunteur nouvelEmprunteur = new Emprunteur(10, prenom, nomDeFamille, dateNaissance);
                m.addEmprunteur(nouvelEmprunteur);
                JOptionPane.showMessageDialog(null, "Emprunteur ajouté");
                formPP.updateAffMediaInscrits();
                writeToFile(m.getEmprunteurs(), m.getMedias(), "data.txt");
                form.fermer();
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
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