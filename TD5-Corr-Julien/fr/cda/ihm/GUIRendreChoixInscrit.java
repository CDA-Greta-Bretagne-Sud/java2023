package fr.cda.ihm;

import fr.cda.projet.Emprunteur;
import fr.cda.projet.GUISite;
import fr.cda.projet.JSONFile;
import fr.cda.projet.Mediatheque;

public class GUIRendreChoixInscrit implements FormulaireInt{
    private GUISite panelPP;
    private Mediatheque m;
    private Formulaire form;
    private JSONFile file;

    public GUIRendreChoixInscrit(GUISite panelPP, Mediatheque m) {
        this.panelPP = panelPP;
        this.m = m;
        this.file = file;
        // Je récupère la liste des inscrits dans un tableau de strings
        String[] inscrits = new String[this.m.getEmprunteurs().size()];

        for (int i = 0; i < this.m.getEmprunteurs().size(); i++) {
            inscrits[i] = m.getEmprunteurs().get(i).toString();
        }
        this.form = new Formulaire("Choix Emprunteur : ",this,1000,800);
        this.form.addListScroll("LISTE_INSCRITS", "Liste des inscrits : ", true, inscrits, 1000, 600);
        this.form.addButton("CHOIX_INSCRIT", "Choisir");
        this.form.afficher();
    }

    @Override
    public void submit(Formulaire form, String nom) {
        Emprunteur emprunteur = m.rendre(this.form);
        GUIRendreChoixMedia choixMedia = new GUIRendreChoixMedia(this.panelPP, this.m, emprunteur);
    }
}
