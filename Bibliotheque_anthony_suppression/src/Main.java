import java.util.Scanner;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

//        TODO Créer un menu pour le choix des options
//        TODO revoir la recherche, s'inspirer du github

//        TODO Créer l'édition

        System.out.println("Combien de livre voulez vous créer ?");
        int n = scan.nextInt();
        scan.nextLine();

        Livre[] livres = new Livre[n];

        for(int i = 0; i<n; i++){
            System.out.println("Saisie du livre #"+(i+1));
            Livre livre = new Livre("", "", "");
            livre.creationLivre(scan);
            livres[i] = livre;
        }

        Bibliotheque biblio = new Bibliotheque(n);
        for(int i = 0; i<n; i++){
            biblio.ajouterLivre(livres[i]);
        }

//        Menu menu = new Menu(biblio, scan);
//        menu.executerMenu();

// Afficher tout le contenu de la bibliothèque (les livres et leurs attribus)
        System.out.println("Contenu de la bibliothèque");
        biblio.afficherContenuBibliotheque();

// Rechercher un livre dans la bibliothèque
        System.out.println("Rechercher un livre de la bibliothèque :");
        int index = biblio.rechercherUnLivre(scan);

// Supprimer un livre dans la bibliothèque
        while(true){
            System.out.println("Supprimer le livre (oui ou non): ");
            String option = scan.next();
            if(option.equals("oui")){
                biblio.supprimeUnLivreParChoix(index);
                break; //Ajout d'un break sinon on nous propose de supprimer le livre suivant
            }else if(option.equals("non")){
                break;
            }else{
                System.out.println("Réponse invalide");
            }
        }


        //Affichage des informations saisie par l'utilisateur :
//        System.out.println("Information des livres saisies :");
//        for (int i = 0; i<=n; i++){
//            Livre livre = livres[i];
//            System.out.println("Livre #" + (i+1));
//            System.out.print("Titre : " + livre.getTitre()+ " . ");
//            System.out.print("Auteur : " + livre.getAuteur()+ " . ");
//            System.out.print("Éditeur : " + livre.getEditeur());
//
//        }

        scan.close();

    }
}