package fr.cda.projet;

public class Media {
	
	private String identificateur;
	private String categorie;
	private String sousCategorie;
	private String description;
	  /** si différent de null, le numero d'inscription de l'emprunteur */
    private int emprunteur;

    /** La date d'emprunt */
    private String dateEmprunt;

	public Media(String identificateur, String categorie, String sousCategorie, String description) {
		super();
		this.identificateur = identificateur;
		this.categorie = categorie;
		this.sousCategorie = sousCategorie;
		this.description = description;
		this.emprunteur = 0;
		this.dateEmprunt = null;
	}
	public Media(String identificateur) {
		this.identificateur = identificateur;
		this.emprunteur = 0;
		this.dateEmprunt = null;
	}

	@Override
	public String toString() {
		
		String res="";
		res="Media: identificateur=" + identificateur + "\n";
		res+= "categorie=" + categorie + "- sousCategorie="+ sousCategorie +"\n" ;
		res+= "description=" + description +"\n";
		res+= "emprunteur=" + emprunteur + "\n";
		res+= "dateEmprunt="+ dateEmprunt + "\n";
		res+="-------------------------------------------------------------------\n";
		
		return res;
	}
	// Méthode utilisé par indexOf qui teste si deux médias sont identiques
    //  Deux médias sont identiques s'ils ont même identificateur
    //
    public boolean equals(Object o)
    {
        Media m = (Media)o;
        return m.identificateur.equals(this.identificateur);
    }
	public String getIdentificateur() {
		return identificateur;
	}

	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getSousCategorie() {
		return sousCategorie;
	}

	public void setSousCategorie(String sousCategorie) {
		this.sousCategorie = sousCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(int emprunteur) {
		this.emprunteur = emprunteur;
	}

	public String getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(String dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
    
    

}
