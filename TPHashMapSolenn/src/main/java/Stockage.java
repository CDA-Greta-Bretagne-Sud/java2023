import java.util.*;

/**
 * Classe générique Stockage
 * @param <T>
 * @param <E>
 */
public class Stockage <T,E>{

    //private T cle;
    //private E elementAStocker;

    // Map pour stocker les éléments en fonction des clés
    private Map<T, E> elementAStocker;

    /**
     * Constructeur pour créer un objet Stockage
     * @param elementAStocker
     */
    public Stockage(Map<T, E> elementAStocker) {
        this.elementAStocker = elementAStocker;
    }

    public Stockage() {
        // Initialisez la structure de données dans le constructeur
        elementAStocker = new HashMap<>();
    }

    /**
     * Méthode qui retourne un élément à stocker en fonction d'une clé
     * @param cle
     * @return
     */
    public E retournerElement(T cle){
        return elementAStocker.get(cle);
    }

    /**
     * Méthode qui ajoute une clé et un élément à la classe Stockage
     * @param cle
     * @param element
     */
    public void ajouter(T cle, E element){
        elementAStocker.put(cle, element);
    }

    /**
     * Méthode qui supprime la clé et l'élément associé à la classe Stockage en fonction de la clé
     * @param cle
     */
    public void supprimer(T cle){
        elementAStocker.remove(cle);
    }

    public Map<T, E> getElementAStocker() {
        return elementAStocker;
    }

    public void setElementAStocker(Map<T, E> elementAStocker) {
        this.elementAStocker = elementAStocker;
    }

    @Override
    public String toString() {
        return "Stockage{" +
                "elementAStocker=" + elementAStocker +
                '}';
    }
}
