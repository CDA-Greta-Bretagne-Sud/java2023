public class Tomate implements Legume{
    private String variete;
    private String couleur;

    public Tomate(String variete, String couleur) {
        this.variete = variete;
        this.couleur = couleur;
    }

    public String getVariete() {
        return variete;
    }

    public void setVariete(String variete) {
        this.variete = variete;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String getLegume() {
        return null;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Tomate{");
        sb.append("variete='").append(variete).append('\'');
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
