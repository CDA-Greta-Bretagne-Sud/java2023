import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Instanciation d'un livre par la méthode creerLivre() de la classe Livre
//        Livre livre = Livre.creerLivre();
//        System.out.println(livre);


//        Saisie de la taille de la bibliotheque
//        System.out.println("Combien de livres au maximum la bibliothèque peut-elle contenir?");
//        int tailleMax = Util.scan.nextInt();
//        Util.scan.nextLine();
//

////        Instanciation d'une bibliotheque
//        Bibliotheque bibliotheque = new Bibliotheque(tailleMax);
//

////        Saisie du nombre de livres à ajouter
//        System.out.println("Combien de livres souhaitez-vous ajouter?");
//        int nombreLivres = Util.scan.nextInt();
//        if(tailleMax<nombreLivres){
//            System.out.println("Impossible d'ajouter plus de " + tailleMax + " livres, c'est la taille maximale de la bibliotheque.");
//        } else {
//            Util.scan.nextLine();
//
//    //        Instanciation et ajout des livres à la bibliotheque
//            for (int i = 0; i < nombreLivres; i++) {
//                Livre livre = Livre.creerLivre();
//                bibliotheque.ajouterLivre(livre);
//            }
//
//            System.out.println("Contenu de la Bibliothèque:");
//            System.out.println(bibliotheque);
//        }


//        Instanciations de livres pour les tests
        Livre l1 = new Livre("Titre1", "Auteur1", "Editeur1");
        Livre l2 = new Livre("Titre2", "Auteur2", "Editeur2");
        Livre l4 = new Livre("Titre1", "Auteur1", "Editeur1");
        Livre l3 = new Livre("Titre3", "Auteur3", "Editeur3");
        Livre l5 = new Livre("Titre1", "Auteur2", "Editeur3");
        Livre l6 = new Livre("Titre3", "Auteur2", "Editeur1");

//        Instanciation de la bibliotheque de taille 6 pour les tests
        Bibliotheque bibliotheque = new Bibliotheque(6);

//        Ajout des livres à la bibliotheque
        bibliotheque.ajouterLivre((l1));
        bibliotheque.ajouterLivre((l2));
        bibliotheque.ajouterLivre((l3));
        bibliotheque.ajouterLivre((l4));
        bibliotheque.ajouterLivre((l5));
        bibliotheque.ajouterLivre((l6));

//        Scan du titre à rechercher par la méthode rechercheLivreTitre
        String titreRecherche;
        System.out.print("Veuillez entrer le nom de titre à rechercher : ");
        titreRecherche = Util.scan.nextLine();

//        Nombre de résultats obtenus suite à cette recherche
        int tailleRecherche = bibliotheque.rechercheLivreTitre(titreRecherche).length;

//        Affichage conditionnel en fonction du nombre de résultats obtenus
        if (tailleRecherche==0){
            System.out.println("Aucun livre ne correspond à cette recherche.");
        } else if(tailleRecherche==1){
            System.out.println("Il n'y a qu'un seul livre comportant ce nom : " + '\n' + "  " +  bibliotheque.livres[bibliotheque.rechercheLivreTitre(titreRecherche)[0]]);
        } else {
            System.out.println("Voici tous les livres comportant ce nom : ");
            for (int i = 0; i < tailleRecherche; i++) {
                System.out.println("  " + bibliotheque.livres[bibliotheque.rechercheLivreTitre((titreRecherche))[i]]);
            }
        }

//        Affichage du tableau d'index des livres
//        System.out.println(Arrays.toString(bibliotheque.rechercheLivreTitre(titreRecherche)));

//        int choix;
//        String [] choixDispo = {"Titre", "Auteur", "Editeur"};
//        System.out.println("Veuillez choisir votre méthode de recherche parmi les suivants : ");
//        for (int i = 0; i < choixDispo.length; i++) {
//            System.out.println("  " + (i+1) + ". " + choixDispo[i]);
//        }
//        choix = Util.scan.nextInt();
//        switch (choix){
//            case 1:
//                System.out.println("Choix 1");
//                break;
//            case 2:
//                System.out.println("Choix 2");
//                break;
//            case 3:
//                System.out.println("Choix 3");
//                break;
//        }


        Util.scan.close();
    }
}