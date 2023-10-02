package fr.cda.projet;


import java.util.*;
import fr.cda.ihm.*;

/** Classe d'IHM permettant d'ajouter un media
 * 
 * @author Pascal
 *
 */
public class GUIAjoutEmprunt implements FormulaireInt
{
  private fr.cda.projet.GUISite formPP;  // Le formulaire principal du programme
  private Mediatheque m;   



  public GUIAjoutEmprunt(fr.cda.projet.GUISite formPrincipal,
                         Mediatheque m)
  {
    this.formPP    = formPrincipal;
    this.m      = m;

 Formulaire form = new Formulaire("Ajouter un Emprunt",this,320,260);

    // listes de selection pour emprunteurs et medias
    
    	String[] listeEmprunts=this.m.ListeEmprunteurs();
    	 form.addListScroll("LISTEEMPRUNTS","Emprunteur", true,listeEmprunts , 300,100);
    		String[] listeMedias=this.m.ListeMedia();
       	 form.addListScroll("LISTEMEDIAS","Médias", true,listeMedias , 300,100);
     
      

    // Pour valider la modification 
    form.addButton("VALIDER","Valider");
    form.addButton("ANNULER","Annuler");
    
 // Position de la fenetre
    //
    form.setPosition(300,300);
    form.afficher();
  }
  
/**Les traitements de l'IHM sus selectionsuite a une action
 * 
 */
  public void submit(Formulaire form,String nomSubmit)
  {
    // Valider la saisie
    //
    if (nomSubmit.equals("VALIDER"))
      {
    	String emprunteur=form.getValeurChamp("LISTEEMPRUNTS");
    	String media=form.getValeurChamp("LISTEMEDIAS");
  
    	if (emprunteur.equals("")||media.equals("")) {
    		System.out.println("Erreur: le champ texte est vide");
            this.formPP.afficherResultat("Erreur: Vous devez selectionner un media et un emprunteur");
    	}
        else
            {
        	//récupreration id emprunt
        	StringTokenizer st = new StringTokenizer(emprunteur);
        	int idEmprunt= Integer.valueOf(st.nextToken());
        	//recuperation id-media
        	StringTokenizer sm = new StringTokenizer(media);
        	String idMedia=sm.nextToken();
        	this.m.emprunter(idMedia, idEmprunt);
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
