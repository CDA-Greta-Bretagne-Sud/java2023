package modele;

import java.util.HashMap;

public class Stockage <T,E>{
    HashMap<T, E> hashMap = new HashMap<>();
    public E retournerElement(T cle) {
        return hashMap.get(cle);
    }

    public void ajouter(T cle, E element) {
        hashMap.put(cle, element);
    }

    public void supprimer(T cle) {
        hashMap.remove(cle);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stockage{");
        sb.append("hashMap=").append(hashMap);
        sb.append('}');
        return sb.toString();
    }
}
