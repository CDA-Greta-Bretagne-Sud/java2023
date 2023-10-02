package fr.cda.projet;
import java.util.ArrayList;


/**
 * @author Pascal
 *
 */

public class Emprunteur {
	/** Numéro de carte d'adhérant. */
    private int numero;

    /** Nom de l'emprunteur */
    private String nom;

    /** Prenom de l'emprunteur */
    private String prenom;

    /** Date de naissance.
     Format: JJ/MM/AAAA */
    private String dateNaissance;

    /** Liste des médias empruntés.
     Chaque élément est l'ident du media. */
    private ArrayList<String> mediaEmpruntes;

	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 */
	public Emprunteur(String nom, String prenom, String dateNaissance) {
		this.numero=0;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mediaEmpruntes=new ArrayList<String>();
	}
	/**
	 * @param int n
	 */
	public Emprunteur(int n) {
		this.numero=n;
	}
/**
 * 
 * @return int numero
 */

	public int getNumero() {
		return numero;
	}
/**
 * 
 * @param int numero
 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
/**
 * 
 * @return String nom
 */
	public String getNom() {
		return nom;
	}
/**
 * 
 * @param String nom
 */
	public void setNom(String nom) {
		this.nom = nom;
	}
/**
 * 
 * @return String prenom
 */
	public String getPrenom() {
		return prenom;
	}
/**
 * 
 * @param String prenom
 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * 
	 * @return String Date naissance
	 */
	public String getDateNaissance() {
		return dateNaissance;
	}
/**
 * 
 * @param dateNaissance
 */
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
/**
 * 
 * @return Arraylist
 */
	public ArrayList<String> getMediaEmpruntes() {
		return mediaEmpruntes;
	}
/**
 * 
 * @param mediaEmpruntes
 */
	public void setMediaEmpruntes(ArrayList<String> mediaEmpruntes) {
		this.mediaEmpruntes = mediaEmpruntes;
	}

	@Override
	public String toString() {
		String res="";
		res+="Emprunteur numero=" + numero + "- nom=" + nom + "- prenom=" + prenom + "\n";
		res+="dateNaissance="+ dateNaissance + "\n";
		res+="mediaEmpruntes=" + mediaEmpruntes + "\n";
		res+="------------------------------------------------------------------------------\n";
		return res;
	}
	/**
	 * 
	 * @param identMedia
	 */
	 public void addEmprunt(String identMedia)
	    {
	        mediaEmpruntes.add(identMedia);
	    }
	// Méthode utilisé par indexOf pour rechercher un emprunteur.
    // Cette méthide teste si deux emprunteurs sont identiques.
    // Deux emprunteurs sont identiques s'ils ont le même numéro

    public boolean equals(Object o)
    {
        Emprunteur e = (Emprunteur)o;
        return (e.numero==this.numero);
    } 
    
    
}
