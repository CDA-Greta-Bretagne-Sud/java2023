// Projet 1 CDA
// 
// NOM,Prenom
// NOM,Prenom
//
package fr.cda.projet;

import java.io.*;
import java.util.*;

import fr.cda.util.*;

// Classe principale d'execution du projet
//
public class Projet
{
    public static void main(String[] a_args) throws IOException {
        Terminal.ecrireStringln("Execution du projet ");

        Mediatheque mediatheque = new Mediatheque();
        //Ajout de plusieurs m�dias
        String m1=mediatheque.ajouterMedia("LIVRE",
                                 "ROMAN",
                                 "Les Miserables");
        String m2=mediatheque.ajouterMedia("LIVRE",
                                 "ROMAN",
                                 "La Gloire de mon pere");
        String m3=mediatheque.ajouterMedia("LIVRE",
                                 "ROMAN",
                                 "Harry Potter : La pierre philosophale");
        String m4=mediatheque.ajouterMedia("DVD",
                                 "Aventure",
                                 "Inception");
        String m5=mediatheque.ajouterMedia("DVD",
                                 "Aventure",
                                 "Harry Potter : L'apprenti sorcier");
        
        // Cr�ation de 3 emprunteurs et ajout dans la m�diat�que
        Emprunteur e1 = new Emprunteur("LAFONT","Paul","31/10/1979");
        Emprunteur e2 = new Emprunteur("ABBE","Zoe","01/12/1985");
        Emprunteur e3 = new Emprunteur("ROUFAT","Martin","02/03/1965");
      
        mediatheque.ajouterInscrit(e1);
        mediatheque.ajouterInscrit(e2);
        mediatheque.ajouterInscrit(e3);
        
      //emprunt
        mediatheque.emprunter(m5, 3);
        mediatheque.emprunter(m4, 1);
        mediatheque.emprunter(m3, 2);
        
        GUISite ihm = new GUISite(mediatheque);
//        mediatheque.writeJson();
    }
}
