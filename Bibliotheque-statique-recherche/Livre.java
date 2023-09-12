import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Livre {
    private Long id;
    private String titre;
    private String auteur;
    private String editeur;

    /**
     * constructeur
     * @param titre
     * @param auteur
     * @param editeur
     */
    public Livre(String titre,  String auteur, String editeur) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
    }
    public Livre(){}

    /**
     * Methode ecrireLivre
     * @throws LivreException
     */
    public  void ecrireLivre() throws LivreException {

        System.out.print("Saisissez le titre du livre:");

        if (Util.scan.hasNext()) {
            this.setTitre(Util.scan.nextLine());
        }

        System.out.print("Saisissez l'auteur du livre:");

        // Util.scan.nextLine();
        if (Util.scan.hasNext()) {
            this.setAuteur(Util.scan.nextLine());

        }
        System.out.print("Saisissez l'editeur du livre:");
       // Util.scan.nextLine();
        if (Util.scan.hasNext()) {
            this.setEditeur(Util.scan.nextLine());

        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }



    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                '}';
    }
}
