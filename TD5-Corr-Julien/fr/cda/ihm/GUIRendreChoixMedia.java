package fr.cda.ihm;

import fr.cda.projet.Emprunteur;
import fr.cda.projet.GUISite;
import fr.cda.projet.JSONFile;
import fr.cda.projet.Mediatheque;

public class GUIRendreChoixMedia implements FormulaireInt{
    private GUISite panelPP;
    private Mediatheque m;
    public GUIRendreChoixMedia(GUISite panelPP, Mediatheque m, Emprunteur emprunteur) {
        this.panelPP = panelPP;
        this.m = m;
        String[] medias = new String[emprunteur.getMediaEmprunter().size()];
        Formulaire formulaire = new Formulaire("Choix média : ", this, 1000, 800);
        formulaire.addListScroll("LISTE_MEDIAS", "Liste des médias : ", true, medias, 1000, 800);
        formulaire.afficher();
    }

    @Override
    public void submit(Formulaire form, String nom) {

    }
}
