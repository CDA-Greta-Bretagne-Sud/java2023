package modele;

import java.util.HashMap;

public class Stockage <T,E> {

    HashMap<T, E> stock = new HashMap<>();

    public E retournerElement(T key) {
        E res = stock.get(key);
        if(res == null) {
            System.out.println("non trouvé");
        }
        return res;
    }

    public void ajouter(T key, E value){
        stock.put(key, value);
    }

    public void supprimer(T key) {
        stock.remove(key);
    }

    @Override
    public String toString() {
        return "modele.Stockage{" +
                "stock=" + stock +
                '}';
    }
}
