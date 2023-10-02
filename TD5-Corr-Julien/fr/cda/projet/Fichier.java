package fr.cda.projet;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;

public interface Fichier {
/*
methode delecture de fichier
 */
   public Mediatheque readFile() throws IOException;
    /*
    méthode ecriture de fichier
     */
    public void writeFile(ArrayList<Media> medias, ArrayList<Emprunteur> emprunteurs) throws IOException;}
