package fr.cda.ihm;

import fr.cda.projet.GUISite;
import fr.cda.projet.JSONFile;
import fr.cda.projet.Mediatheque;

public class GUIAjoutMedia implements FormulaireInt {
    private GUISite formPP; // Le formulaire principal du programme
    private Mediatheque m;
    public GUIAjoutMedia(GUISite formPP,
                                Mediatheque m)
    {
        this.formPP = formPP;
        this.m = m;
        Formulaire form = new Formulaire("Ajout Emprunteur",this,320,260);
        form.addText("Categorie", "Catégorie : ", true, "");
        form.addText("SousCategorie", "Sous-catégorie : ", true, "");
        form.addText("Description", "Description : ", true, "");
        form.addButton("Valider", "Valider");
        form.afficher();
    }
        @Override
    public void submit(Formulaire form, String nom) {
        m.ajouterMedia(form.getValeurChamp("Categorie"), form.getValeurChamp("SousCategorie"), form.getValeurChamp("Description"));
        form.fermer();
    }
}
