import java.util.HashMap;
import java.util.Map;

public class Stockage<T,E>{

    private Map<T, E> stockageMap;

    public Stockage()
    {
        stockageMap = new HashMap<>();
    }

    /**
     * Retourner un element à partir de ça cle
     * @param cle
     * @return
     */
    public E getElement(T cle) {
        return stockageMap.get(cle);
    }

    /**
     * Ajouter
     * @param cle
     * @param element
     */
    public void ajouter(T cle, E element)
    {
        stockageMap.put(cle, element);
    }

    /**
     * Supprimer un element a partir de ca cle
     * @param cle
     */
    public void supprimer(T cle)
    {
        stockageMap.remove(cle);
    }

    /**
     * Acces a la map qui stocke les elements
     * @return
     */
    public Map<T, E> getStockageMap() {
        return stockageMap;
    }

}
