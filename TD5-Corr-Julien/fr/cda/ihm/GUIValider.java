package fr.cda.ihm;

import fr.cda.projet.Emprunteur;
import fr.cda.projet.GUISite;
import fr.cda.projet.JSONFile;
import fr.cda.projet.Mediatheque;

public class GUIValider implements FormulaireInt{
    private JSONFile file;
    private GUISite formPP;
    private Mediatheque m;

    public GUIValider(GUISite formPP, Mediatheque m, Emprunteur emprunteur) {
        this.file = new JSONFile("fichier.json");
        this.formPP = formPP;
        this.m = m;
        Formulaire formulaire2 = new Formulaire("OK", this, 1100, 100);
        formulaire2.addLabel(emprunteur.getMediaEmprunter().toString());
        formulaire2.addLabel("");
        formulaire2.addLabel("");
        formulaire2.addButton("VALIDER", "Valider");
        formulaire2.afficher();
    }

    @Override
    public void submit(Formulaire form, String nom) {
        form.fermer();
        try {
            this.file.writeFile(m.getMedias(), m.getEmprunteurs());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
