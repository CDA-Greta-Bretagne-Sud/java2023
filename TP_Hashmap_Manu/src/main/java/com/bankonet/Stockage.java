package com.bankonet;

import java.util.HashMap;
import java.util.Map;

public class Stockage<T, E> {

    private Map<T, E> stockage = new HashMap<>();

    /**
     * Renvoie l'élément associé à la clé spécifiée.
     *
     * @param key La clé utilisée pour rechercher l'élément.
     * @return L'élément de type E associé à la clé, ou null si la clé n'est pas présente.
     */
    public E retournerElement(T key){
        return stockage.get(key);
    }

    /**
     * Permet d'ajouter à la map des éléments référencés grâce à leur valeur
     * @param key La clé utilisée pour associer à l'élément
     * @param element L'élément ajouté
     */
    public void ajouter(T key, E element){
        stockage.put(key, element);
    }

    /**
     * Permet de supprimer via la clé une entrée de la Map
     * @param key La clé utilisée pour supprimer l'élément
     */
    public void supprimer(T key){
        stockage.remove(key);
    }




}


