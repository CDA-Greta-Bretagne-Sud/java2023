package projet;

import java.util.Date;
import java.util.List;

public class Media {
    public static int nombres = 00000;
    // Format id => AAAA-MM-NNNNN
    private String id;
    private String categorie;
    private String sousCategorie;
    private String description;
    private int numeroEmprunteur = 0;
    private Date dateEmprunt = null;
    private boolean emprunte=false;



    public Media(String id, String categorie, String sousCategorie, String description, int numeroEmprunteur, Date dateEmprunt, Boolean emprunte) {
        this.id = id;
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.description = description;
        this.numeroEmprunteur = numeroEmprunteur;
        this.dateEmprunt = dateEmprunt;
        this.emprunte = emprunte;
    }
    public Media(String id, String categorie, String sousCategorie, String description) {
        this.id = id;
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.description = description;
    }
    public static Media findMediaById(String id, List<Media> medias) {
        for (Media m : medias) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    public static int getNombres() {
        return nombres;
    }

    public static void setNombres(int nombres) {
        Media.nombres = nombres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public boolean isEmprunte() {
        return emprunte;
    }

    public void setEmprunte(boolean emprunte) {
        this.emprunte = emprunte;
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

    public int getNumeroEmprunteur() {
        return numeroEmprunteur;
    }

    public void setNumeroEmprunteur(int numeroEmprunteur) {
        this.numeroEmprunteur = numeroEmprunteur;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    @Override
    public String toString() {
        return   "'" + id + '\'' +
                ", categorie :'" + categorie;

    }
}
