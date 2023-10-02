package fr.cda.projet;

public class Media {
    private String identificateur;
    private static int countMedia;
    private int numeroEmprunter;
    private String categorie;
    private String sousCategorie;
    private String description;
    private String dateEmprunt;

    // Constructeur vide
    public Media() {
    }

    public Media(String categorie, String sousCategorie, String description) {
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.description = description;
        this.identificateur = genereIdentificateur();
    }


    public Media(String identificateur, int numeroEmprunter, String categorie, String sousCategorie, String description, String dateEmprunt) {
        this.identificateur = identificateur;
        this.numeroEmprunter = numeroEmprunter;
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.description = description;
        this.dateEmprunt = dateEmprunt;
    }

    public String getIdentificateur() {
        return identificateur;
    }

    public void setIdentificateur(String identificateur) {
        this.identificateur = identificateur;
    }

    public int getCountMedia() {
        return countMedia;
    }

    public void setCountMedia(int countMedia) {
        this.countMedia = countMedia;
    }

    public String genereIdentificateur() {
        String anneeMois = java.time.LocalDate.now().toString().substring(0, 7).replace("-", "");
        int numero = countMedia++;
        return anneeMois + String.format("%05d", numero);
    }

    public int getNumeroEmprunter() {
        return numeroEmprunter;
    }

    public void setNumeroEmprunter(int numeroEmprunter) {
        this.numeroEmprunter = numeroEmprunter;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
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

    @Override
    public String toString() {
        return "Media{" +
                "identificateur='" + identificateur + '\'' +
                ", categorie='" + categorie + '\'' +
                ", sousCategorie='" + sousCategorie + '\'' +
                ", description='" + description + '\'' +
                ", numeroEmprunteur=" + numeroEmprunter +
                ", dateEmprunt='" + dateEmprunt + "\n" +
                '}';
    }
}
