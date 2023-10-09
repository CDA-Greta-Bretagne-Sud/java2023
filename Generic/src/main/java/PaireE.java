import java.util.List;

/**
 * classe générique Paire avec une liste
 * @param <E>
 */
public class PaireE <E>{
    E nom;
    List<?> surnoms;

    /**
     * constructeur de paire avec une liste generique
     * @param nom
     * @param surnoms
     */
    public PaireE(E nom, List<?> surnoms) {
        this.nom = nom;
        this.surnoms = surnoms;
    }

    public E getNom() {
        return nom;
    }

    public void setNom(E nom) {
        this.nom = nom;
    }

    public List<?> getSurnoms() {
        return surnoms;
    }

    public void setSurnoms(List<?> surnoms) {
        this.surnoms = surnoms;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PaireE{");
        sb.append("nom=").append(nom);
        sb.append(", surnoms=").append(surnoms);
        sb.append('}');
        return sb.toString();
    }
}
