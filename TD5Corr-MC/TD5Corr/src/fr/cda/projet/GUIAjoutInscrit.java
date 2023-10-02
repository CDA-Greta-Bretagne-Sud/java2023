package fr.cda.projet;


import java.util.*;
import fr.cda.ihm.*;

// Classe d'IHM permettant d'ajouter un media
//
public class GUIAjoutInscrit implements FormulaireInt
{
  private GUISite formPP;  // Le formulaire principal du programme
  private Mediatheque m;   



  public GUIAjoutInscrit(GUISite formPrincipal,
                             Mediatheque m)
  {
    this.formPP    = formPrincipal;
    this.m      = m;

 Formulaire form = new Formulaire("Ajout Emprunteur",this,320,260);

    // On permet la saisie de l'inscrit
    	form.addLabel("");
        form.addText("NOM","Nom",true,"");
        form.addText("PRENOM","Prénom",true,"");
        form.addText("DATENAISSANCE","Date de naissance",true,"");
        
      /**  //test
       String [] listeEmp= {"toto","titi","tata"};
        form.addListScroll("liste","titre", true,listeEmp , 100,50);*/
      

    // Pour valider la modification 
    form.addButton("VALIDER","Valider");
    form.addButton("ANNULER","Annuler");
    
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
    	String nom=form.getValeurChamp("NOM");
    	String prenom=form.getValeurChamp("PRENOM");
    	String dateNaiss=form.getValeurChamp("DATENAISSANCE");
    	if (nom.equals("")||prenom.equals("")||dateNaiss.equals("")) {
    		System.out.println("Erreur: le champ texte est vide");
            this.formPP.afficherResultat("Erreur: le champ texte est vide");
    	}
        else
            {
        	Emprunteur e=new Emprunteur(nom,prenom,dateNaiss);
            // Ajout de l'emprunteur
           	this.m.ajouterInscrit(e);
            // 
            //affichage du résultat
            this.formPP.afficherResultat(m.afficher());
             
           form.fermer();
             
            }
   
     
      }
    else if   (nomSubmit.equals("ANNULER"))
        {
            this.formPP.afficherResultat("Annulation de l'ajout de l'inscrit");
           form.fermer();
        }
  }
  
}
