package fr.cda.ihm;

import fr.cda.projet.Emprunteur;
import fr.cda.projet.GUISite;
import fr.cda.projet.JSONFile;
import fr.cda.projet.Mediatheque;

import javax.swing.*;
import java.awt.*;

public class GUIAjoutinscrit implements FormulaireInt {
    private GUISite formPP; // Le formulaire principal du programme
    private Mediatheque m;

    public GUIAjoutinscrit(GUISite formPP, Mediatheque m) {
        this.formPP = formPP;
        this.m = m;
        // Formulaire
        Formulaire form = new Formulaire("Ajout Emprunteur",this,320,260);
        form.addText("Nom", "Nom : ", true, "");
        form.addText("Prenom", "Prénom : ", true, "");
        form.addText("Date", "Date : ", true, "");
        form.addButton("Valider", "Valider");
        form.afficher();
    }

    @Override
    public void submit(Formulaire form, String nom) {
        this.m.ajouterInscrit(new Emprunteur(form.getValeurChamp("Nom"), form.getValeurChamp("Prenom"), form.getValeurChamp("Date")));
       form.fermer();
    }
}
