import java.util.HashMap;
import java.util.Map;

public class Stockage<T, E> {
    private Map<T, E> elements = new HashMap<>();

    public E retournerElement(T cle) {
        return elements.get(cle);
    }

    public void ajouter(T cle, E element) {
        elements.put(cle, element);
    }

    public void supprimer(T cle) {
        elements.remove(cle);
    }
}

