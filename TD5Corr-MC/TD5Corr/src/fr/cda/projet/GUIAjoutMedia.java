package fr.cda.projet;


import java.util.*;
import fr.cda.ihm.*;

// Classe d'IHM permettant d'ajouter un media
//
public class GUIAjoutMedia implements FormulaireInt
{
  private GUISite formPP;  // Le formulaire principal du programme
  private Mediatheque m;   



  public GUIAjoutMedia(GUISite formPP,
                             Mediatheque m)
  {
    this.formPP    = formPP;
    this.m      = m;

 Formulaire form = new Formulaire("Ajout Média",this,320,260);

    // On permet la saisie du media
    	form.addLabel("");
        form.addText("CATEGORIE","Catégorie",true,"");
        form.addText("SOUS-CATEGORIE","Sous Catégorie",true,"");
        form.addText("DESCRIPTION","description",true,"");
      

    // Pour valider la modification des quantites
    form.addButton("VALIDER","Valider");
    //form.addButton("VALIDER","Annuler");
    
 // Position de la fenetre
    //
    form.setPosition(300,300);
    form.afficher();
  }
  
  // Les traitements de l'IHM sus selectionsuite a une action
  //
  public void submit(Formulaire form,String nomSubmit)
  {
    // Valider la saisie
    //
    if (nomSubmit.equals("VALIDER"))
      {
    
     // Ajout du media
    	this.m.ajouterMedia(form.getValeurChamp("CATEGORIE"), form.getValeurChamp("SOUS-CATEGORIE"),form.getValeurChamp("DESCRIPTION"));
      
   
      // 
       //affichage du résultat
       formPP.afficherResultat(m.afficher());
        
       form.fermer();
      }
  }
  
}
