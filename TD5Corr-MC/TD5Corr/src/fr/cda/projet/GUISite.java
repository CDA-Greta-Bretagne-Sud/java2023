package fr.cda.projet;

import fr.cda.ihm.*;

import java.io.IOException;

// Classe de definition de l'IHM principale de l'application mediatheque
//
public class GUISite implements FormulaireInt {
	private Mediatheque mediatheque; // la mediatheque
    private Formulaire form;    // Le formulaire

	// Constructeur
	//
	public GUISite(Mediatheque m) {
		this.mediatheque = m;

		// Creation du formulaire
		form = new Formulaire("Mediatheque", this, 1100, 730);

		// Creation des elements de l'IHM
		//
		form.setPosition(20, 10);
		form.addLabel("Afficher tous les medias et inscrits");
		form.addButton("AFF_MEDIAINSCRITS", "Tous les médias et inscrits");
		form.addLabel("");
		form.addLabel("Ajouter un inscrit");
		form.addButton("AJOUT_INSCRIT", "Ajouter un inscrit");
		form.addLabel("");
		form.addLabel("Ajouter un Media");
		form.addButton("AJOUT_MEDIA", "Ajouter un media");
		form.addLabel("");
		//form.addLabel("Rechercher un inscrit par nom:");
        form.addText("RECHERCHEINSCRIT","Rechercher inscrit par nom:",true,"");
        form.addButton("RECHERCHE_INSCRIT", "Rechercher");
    	//form.addLabel("Rechercher un média par id:");
        form.addText("RECHERCHEMEDIA","Rechercher média par catégorie:",true,"");
        form.addButton("RECHERCHE_MEDIA", "Rechercher");
        form.addLabel("");
        form.addButton("EMPRUNTER", "Emprunter");
		form.addLabel("");
		form.addButton("SAUVEGARDER", "Sauvegarder");
		form.addLabel("");
		form.addButton("OUVRIR", "Ouvrir");
		form.setPosition(20, 450);
		form.addButton("FERMER", "FERMER");
		form.setPosition(350, 0);
		form.addZoneText("RESULTATS", "Resultats", true, "", 600, 700);

		// Affichage du formulaire
		form.afficher();
	}

	// Methode appellee quand on clique dans un bouton
	//
	public void submit(Formulaire form, String nomSubmit) throws IOException {

		// Affichage de tous les medias et inscrits
		//
		if (nomSubmit.equals("AFF_MEDIAINSCRITS")) {
			String res = this.mediatheque.afficher();
			form.setValeurChamp("RESULTATS", res);
		}

		// Ajout inscript
		//
		if (nomSubmit.equals("AJOUT_INSCRIT")) {
			GUIAjoutInscrit ihm = new GUIAjoutInscrit(this, this.mediatheque);
		}

		// Ajout media
		//
		if (nomSubmit.equals("AJOUT_MEDIA")) {

			GUIAjoutMedia ihm = new GUIAjoutMedia(this, this.mediatheque);
		}
		if (nomSubmit.equals("RECHERCHE_MEDIA")) {
			
			String mediaRecherche=form.getValeurChamp("RECHERCHEMEDIA");
			
			String res = this.mediatheque.RechercheMedia(mediaRecherche);
			form.setValeurChamp("RESULTATS", res);
		}
		if (nomSubmit.equals("RECHERCHE_INSCRIT")) {
			
			String inscritRecherche=form.getValeurChamp("RECHERCHEINSCRIT");
			
			String res = this.mediatheque.RechercheInscrit(inscritRecherche);
			form.setValeurChamp("RESULTATS", res);
		}
		if (nomSubmit.equals("EMPRUNTER")) {
			GUIAjoutEmprunt GUIemp = new GUIAjoutEmprunt(this, this.mediatheque);
		}
		if (nomSubmit.equals("SAUVEGARDER")){
			mediatheque.sauverDonnees();
		}
		if (nomSubmit.equals("OUVRIR")){
			String res = mediatheque.ouvrirFichierTexte();
			form.setValeurChamp("RESULTATS", res);
		}
		// fermer
		//
		if (nomSubmit.equals("FERMER")) {
			form.fermer();
		}

	}

	// Cette methode permet a l'IHM l'ajout d'un media ou d'un inscrit
	// un texte dans la zone resultat
	//
	public void afficherResultat( String res) {
		
		form.setValeurChamp("RESULTATS", res);

	}

}