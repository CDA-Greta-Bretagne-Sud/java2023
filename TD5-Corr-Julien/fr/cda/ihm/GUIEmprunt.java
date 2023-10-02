package fr.cda.ihm;

import fr.cda.projet.Emprunteur;
import fr.cda.projet.GUISite;
import fr.cda.projet.Mediatheque;

public class GUIEmprunt implements FormulaireInt {
    private GUISite formPP;
    private Mediatheque m;
    private Formulaire form;

    public GUIEmprunt(GUISite formPP, Mediatheque m) {
        this.m = m;
        this.formPP = formPP;

        String[] inscrits = new String[this.m.getEmprunteurs().size()];
        String[] medias = new String[this.m.getMedias().size()];

        for (int i = 0; i < this.m.getMedias().size(); i++) {
            medias[i] = m.getMedias().get(i).toString();
        }

        for (int i = 0; i < this.m.getEmprunteurs().size(); i++) {
            inscrits[i] = m.getEmprunteurs().get(i).toString();
        }
        this.form = new Formulaire("Emprunt", this, 1000,800);
        this.form.addListScroll("INSCRITS", "Inscrits", true, inscrits, 900, 150);
        this.form.addListScroll("MEDIAS", "Medias", true, medias, 900, 150);
        this.form.addButton("EMPRUNT", "Emprunter");
        this.form.afficher();
    }

    @Override
    public void submit(Formulaire form, String nom) {
        Emprunteur emprunteur = m.emprunter(form);
        form.fermer();
        GUIValider valider = new GUIValider(this.formPP, m, emprunteur);
    }
}
