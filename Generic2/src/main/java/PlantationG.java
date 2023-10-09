public class PlantationG <T1,T2>{

    private T1 typePlantation;
   private T2 adresseJardin;

    public PlantationG(T1 typePlantation, T2 adresseJardin) {
        this.typePlantation = typePlantation;
        this.adresseJardin = adresseJardin;
    }

    public T1 getTypePlantation() {
        return typePlantation;
    }

    public void setTypePlantation(T1 typePlantation) {
        this.typePlantation = typePlantation;
    }

    public T2 getAdresseJardin() {
        return adresseJardin;
    }

    public void setAdresseJardin(T2 adresseJardin) {
        this.adresseJardin = adresseJardin;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PlantationG{");
        sb.append("typePlantation=").append(typePlantation);
        sb.append(", adresseJardin=").append(adresseJardin);
        sb.append('}');
        return sb.toString();
    }
}
