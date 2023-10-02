package fr.cda.projet;

import fr.cda.ihm.*;

// Classe de definition de l'IHM principale de l'application mediatheque
//
public class GUISite implements FormulaireInt
{
    private Mediatheque mediatheque;  // la mediatheque

    // Constructeur
    //
    public GUISite(Mediatheque m)
    {
        this.mediatheque = m;

        // Creation du formulaire
        Formulaire form = new Formulaire("Mediatheque",this,1100,730);
        
        //  Creation des elements de l'IHM
        //
        form.setPosition(20,10);
        form.addLabel("Afficher tous les medias et inscrits");
        form.addButton("AFF_MEDIAINSCRITS","Tous les médias et inscrits");
        form.addLabel("");
        form.addLabel("Ajouter un inscrit");
        form.addButton("AJOUT_INSCRIT","Ajouter un inscrit");
        form.addLabel("");
        form.addLabel("Ajouter un Media");
        form.addButton("AJOUT_MEDIA","Ajouter un media");
        form.addLabel("");
        form.setPosition(20,650);
        form.addButton("FERMER","FERMER");
        form.setPosition(350,0);
        form.addZoneText("RESULTATS","Resultats",
                            true,
                            "",
                            600,700);

        // Affichage du formulaire
        form.afficher();
    }

    // Methode appellee quand on clique dans un bouton
    //
    public void submit(Formulaire form,String nomSubmit)
    {

        // Affichage de tous les medias et inscrits
        //
        if (nomSubmit.equals("AFF_MEDIAINSCRITS"))
            {
                String res = "AFF_MEDIAINSCRITS";
                form.setValeurChamp("RESULTATS",res);
            }

        // Ajout inscript
        //
        if (nomSubmit.equals("AJOUT_INSCRIT"))
            {
                String res = "AJOUT_INSCRIT";
                form.setValeurChamp("RESULTATS",res);
            }

        // Ajout media
        //
        if (nomSubmit.equals("AJOUT_MEDIA"))
            {
             
                String res =  "AJOUT_MEDIA";
                form.setValeurChamp("RESULTATS",res);
            }
        // fermer
        //
        if (nomSubmit.equals("FERMER"))
            {
             form.fermer();
            }
      
    }

}