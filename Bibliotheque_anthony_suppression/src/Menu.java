//import java.util.Scanner;
//public class Menu {
//
//    private Bibliotheque bibliotheque;
//    private Scanner scanner;
//
//    public Menu(Bibliotheque bibliotheque, Scanner scan){
//        this.bibliotheque = bibliotheque;
//        this.scanner = scan;
//    }
//
//    public void afficherMenu(){
//        System.out.println("Menu  : ");
//        System.out.println("[1. Ajouter un livre]");
//        System.out.println("[2. recherche un livre]");
//        System.out.println("[3. Editer un livre]");
//        System.out.println("[4. afficher le contenu de la bibliothèque]");
//        System.out.println("[5. Supprimer un livre]");
//        System.out.println("[6. Quitter le menu]");
//    }
//
//    public void executerMenu(){
//        boolean quitter = false;
//        while(!quitter){
//            afficherMenu();
//            System.out.println("Choisissez une option : ");
//            int choix = scanner.nextInt();
//            scanner.nextLine(); //pour consommer la nouvelle ligne
//                switch (choix){
//                    case 1: //Ajouter un livre
//                        ajouterLivre();
//                        break;
//                    case 2 : // rechercher un livre
//                        rechercherLivre();
//                        break;
////                    case 3 : // Editer un livre
////                        editerLivre();
////                        break;
//                    case 4 : // Afficher le contenu de la bibliotheque
//                        bibliotheque.afficherContenuBibliotheque();
//                        break;
//                    case 5 : // Supprimer un livre de la bibliothèque
//                        supprimerLivre();
//                        break;
//                    case 6 : // Quitter le menu
//                        quitter = true;
//                        break;
//                    default :
//                        System.out.println("Option invalide, veuillez réessayer !");
//                }
//        }
//    }
//
//    private void ajouterLivre() {
//        // Demandez à l'utilisateur de saisir les informations pour créer un livre
//        System.out.print("Renseigner le titre : ");
//        String titre = scanner.nextLine();
//        System.out.print("Renseigner l'auteur : ");
//        String auteur = scanner.nextLine();
//        System.out.print("Renseigner l'éditeur : ");
//        String editeur = scanner.nextLine();
//
//        Livre livre = new Livre(titre, auteur, editeur);
//        bibliotheque.ajouterLivre(livre);
//    }
//
//    private void supprimerLivre() {
//        // Demandez à l'utilisateur de saisir le titre du livre à supprimer
//        System.out.print("Renseigner le titre du livre à supprimer : ");
//        String titre = scanner.nextLine();
//        int index = bibliotheque.rechercherUnLivre(scanner);
//
//        if (index != -1) {
//            bibliotheque.supprimeUnLivreParChoix(scanner, "oui", index);
//        } else {
//            System.out.println("Le livre n'a pas été trouvé dans la bibliothèque.");
//        }
//    }
//
//    private void rechercherLivre() {
//        // Demandez à l'utilisateur de saisir le titre du livre à rechercher
//        System.out.print("Renseigner le titre du livre que vous recherchez : ");
//        String titre = scanner.nextLine();
//        int index = bibliotheque.rechercherUnLivre(scanner);
//
//        if (index != -1) {
//            System.out.println("Livre trouvé :");
//            System.out.println(bibliotheque.getLivres()[index]);
//        } else {
//            System.out.println("Aucun livre ne correspond à la recherche.");
//        }
//    }
//
//
//
//
//
//}
