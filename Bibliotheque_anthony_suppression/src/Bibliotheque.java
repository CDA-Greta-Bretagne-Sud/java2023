import java.util.Scanner;
public class Bibliotheque {

//    Question 2
//    Une bibliothèque est une collection de plusieurs livres. Les livres seront représentés au moyen de
//    la classe écrite pour répondre à la question 1. Ecrivez une classe bibliothèque permettant de stocker
//    plusieurs livres, avec deux opérations : ajouter un livre, afficher le contenu de la bibliothèque. Vous
//    écrirez une méthode main qui crée un ou deux livres, une bibliothèque et qui appelle les différentes
//    méthodes disponibles.

    private Livre[] livres;
    private int nombreLivres;
//------------Constructeur------------//

    public Bibliotheque(Livre[] livres, int nombreLivres) {
        this.livres = livres;
        this.nombreLivres = nombreLivres;
    }

//------------Get & set------------//
    public Livre[] getLivres() {
        return livres;
    }
    public void setLivres(Livre[] livres) {
        this.livres = livres;
    }
    public int getNombreLivres() {
        return nombreLivres;
    }
    public void setNombreLivres(int nombreLivres) {
        this.nombreLivres = nombreLivres;
    }
//--------Methodes--------------//

    // On définis la taille maximum de la bibliothèque grace au nombre de livre que l'on a précédement saisies.
    public Bibliotheque(int capacite){
        livres = new Livre[capacite];
        nombreLivres = 0;
    }
    // On ajoute des livres à la bibliothèque égale aux nombres de livre définis avant.
    public void ajouterLivre(Livre livre){
        if(nombreLivres < livres.length){
            livres[nombreLivres] = livre;
            nombreLivres ++;
        }else{
            System.out.println("La capacite max de la bibliothèque est atteinte !");
        }
    }
    // On affiche les livres contenu dans la bibliothèque.
    public void afficherContenuBibliotheque(){
        //parcourir les livres et les afficher :
        for (int i=0; i < livres.length; i++){
            Livre livre = livres[i];
            if(livre == null){
                break; //Arrêter la boucle lorsque l'on rencontre un livre à null, problème rencontrer après la suppression d'un livre
            }
            System.out.println("Livre " + (i + 1) + " : ");
            System.out.println("Titre : " + livre.getTitre());
            System.out.println("Auteur : " + livre.getAuteur());
            System.out.println("Éditeur : " + livre.getEditeur());
        }
    }
    // On recherche un livre dans la bibliothèque
    public int rechercherUnLivre(Scanner scan){
        // Demander à l'utilisateur de rechercher un livre
        String saisie = null;
        System.out.println("Renseigner le titre du livre, l'auteur ou l'editeur que vous recherchez : ");
        saisie = scan.nextLine();
        Livre livreTrouve = null; // Initialisation d'un objet livre à null pour le livre à trouver.
        int index = 0;
        for (int i=0; i<livres.length; i++){
            Livre livre = livres[i];
            if(livre.getTitre().equals(saisie)
                    || livre.getAuteur().equals(saisie)
                    || livre.getEditeur().equals(saisie)){
                livreTrouve = livre; // On met à jour la variable livreTrouve avec le livre qui correspond
                index = i;
            }
        }
        if(livreTrouve == null){
            System.out.println("Aucun livre ne correspnd à la recherche !"); // Si aucun livre n'est trouvé.
        }else{
            System.out.println("Livre trouver : "+livreTrouve); //On affiche les livre trouvé.
        }
        return index;
    }

//    public void editerUnLivre(Scanner scan, Livre livre){
//        //Demander à l'utilisateur de choisir ce qu'il modifie :
//        System.out.println("Que voulez-vous modifier ?");
//        System.out.println("[1] Titre");
//        System.out.println("[2] Auteur");
//        System.out.println("[3] Editeur");
//
//        int saisie = 0;
//        scan.nextLine(); // Pour consommer la nouvelle ligne restante
//        //Switch case pour la modification !:
//        case 1:
//        System.out.print("Nouveau titre : ");
//        String nouveauTitre = scan.nextLine();
//        livre.setTitre(nouveauTitre);
//        System.out.println("Titre mis à jour avec succès !");
//        break;
//        case 2:
//        System.out.print("Nouvel auteur : ");
//        String nouvelAuteur = scan.nextLine();
//        livre.setAuteur(nouvelAuteur);
//        System.out.println("Auteur mis à jour avec succès !");
//        break;
//        case 3:
//        System.out.print("Nouvel éditeur : ");
//        String nouvelEditeur = scan.nextLine();
//        livre.setEditeur(nouvelEditeur);
//        System.out.println("Éditeur mis à jour avec succès !");
//        break;
//        default:
//        System.out.println("Choix invalide. Aucune mise à jour effectuée.");
//    }

    public void supprimeUnLivre(Livre titre){
        int index = -1; // Initialise l'index à -1 (non trouvé)
        // vérification si le livre existe bien dans la bibliothèque :
        for (int i=0; i<livres.length; i++){
            Livre livre = livres[i];
            if(livre.getTitre().equals(titre)){
                index = i;
                break;
            }else{
                System.out.println("Le livre n'existe pas !");
            }
            //Si le livre est trouvé donc différent de -1, on le supprime du tableau !
            if(index != -1){
                for(int j = index; j<nombreLivres -1; j++){
                    livres[j] = livres[j+1];
                }
                livres[nombreLivres - 1] = null; // Supprimez la référence au dernier élément (doublon)
                nombreLivres--; // Décrémentez le nombre de livres dans la bibliothèque
                System.out.println("Livre supprimé avec succès !");
            }
        }
    }

//    public void supprimeUnLivreParChoix(Scanner scan, String option, int index){
//        // vérification si le livre existe bien dans la bibliothèque :
//        //Si le livre est trouvé donc différent de -1, on le supprime du tableau !
//        if(index != -1){
//            for(int j = index; j<nombreLivres -1; j++){
//                livres[j] = livres[j+1];
//            }
//            livres[nombreLivres - 1] = null; // Supprimez la référence au dernier élément (doublon)
//            nombreLivres--; // Décrémentez le nombre de livres dans la bibliothèque
//            System.out.println("Livre supprimé avec succès !");
//            afficherContenuBibliotheque();
//        }
//    }

    public void supprimeUnLivreParChoix(int index){
        // vérification si le livre existe bien dans la bibliothèque :
        //Si le livre est trouvé donc différent de -1, on le supprime du tableau !
            livres[index] = livres[nombreLivres -1];
            livres[nombreLivres - 1] = null; // Supprimez la référence au dernier élément (doublon)
            nombreLivres--; // Décrémentez le nombre de livres dans la bibliothèque
            System.out.println("Livre supprimé avec succès !");
            afficherContenuBibliotheque();
        }
}
