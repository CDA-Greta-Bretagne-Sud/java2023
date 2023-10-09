/**
 * Classe générique de l'objet Paire
 * @param <T>
 */
public class Paire<T> {
   private T premier;
   private  T second;

    /**
     * constructeur pour créer un objet Paire
     * @param premier
     * @param second
     */
    public Paire(T premier, T second) {
        this.premier = premier;
        this.second = second;
    }

    public T getPremier() {
        return premier;
    }

    public void setPremier(T premier) {
        this.premier = premier;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Paire{");
        sb.append("premier=").append(premier);
        sb.append(", second=").append(second);
        sb.append('}');
        return sb.toString();
    }
}
