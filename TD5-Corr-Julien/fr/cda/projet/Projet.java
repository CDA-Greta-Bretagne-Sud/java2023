// Projet 1 CDA
// 
// NOM,Prenom
// NOM,Prenom
//
package fr.cda.projet;

import java.io.*;


// Classe principale d'execution du projet
//
public class Projet

{
    public static void main(String a_args[]) throws IOException {
        JSONFile file = new JSONFile("fichier.json");
        // Initialisation de la médiateque avec le fichier JSON
        GUISite ihm = new GUISite(file.readFile());
    }
}
