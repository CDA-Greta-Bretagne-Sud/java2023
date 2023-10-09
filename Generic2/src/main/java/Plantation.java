public class Plantation <T> {

    private T typePlantation;

    private String adresseJardin;

    public Plantation(T typePlantation, String adresseJardin) {
        this.typePlantation = typePlantation;
        this.adresseJardin = adresseJardin;
    }

    public T getTypePlantation() {
        return typePlantation;
    }

    public void setTypePlantation(T typePlantation) {
        this.typePlantation = typePlantation;
    }

    public String getAdresseJardin() {
        return adresseJardin;
    }

    public void setAdresseJardin(String adresseJardin) {
        this.adresseJardin = adresseJardin;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Plantation{");
        sb.append("typePlantation=").append(typePlantation);
        sb.append(", adresseJardin='").append(adresseJardin).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

