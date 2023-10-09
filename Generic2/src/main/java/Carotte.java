public class Carotte implements Legume{
    private String nom;
    private String variete;

    public Carotte(String nom, String variete) {
        this.nom = nom;
        this.variete = variete;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVariete() {
        return variete;
    }

    public void setVariete(String variete) {
        this.variete = variete;
    }

    @Override
    public String getLegume() {
        return this.getVariete();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Carotte{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", variete='").append(variete).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
