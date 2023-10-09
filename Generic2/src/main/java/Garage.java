public class Garage {

    private String nom;
    private int surface;
    private String adresse;

    public Garage(String nom, int surface, String adresse) {
        this.nom = nom;
        this.surface = surface;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Garage{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", surface=").append(surface);
        sb.append(", adresse='").append(adresse).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
