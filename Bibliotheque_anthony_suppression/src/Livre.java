import java.util.Scanner;
public class Livre {

    //        Question 1
//        Ecrivez une classe permettant de représenter deslivres avec le titre, le nom de l’auteur et l’éditeur.
//        Les opérations consisteront en saisir un livre, ce qui crée un nouvel objet et afficher les informa- tions
//        d’un objet livre. Vous ferez attention pour chaque opération de déterminer si ce doit être une
//        méthode statique ou non.

    private String titre;
    private String auteur;
    private String editeur;

    public Livre(String titre, String auteur, String editeur) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                '}';
    }

    public void creationLivre (Scanner scan){

        //Demander de saisir les informations :
            //        try{
            System.out.println("Renseigner le titre : ");
            // Récupération de la saisie de l'utilisateur :
            String titre = scan.nextLine();
            // Affectation de la saisie à notre Titre
            setTitre(titre);

            System.out.println("Renseigner l'auteur : ");
            String auteur = scan.nextLine();
            setAuteur(auteur);

            System.out.println("Renseigner l'editeur : ");
            String editeur = scan.nextLine();
            setEditeur(editeur);
//        }catch(CaractereIncorrect e){
//            System.err.println("Erreur : "+ e.getMessage());
//        }

    }

    private void verifierCarac(String str)throws CaractereIncorrect {
        if (!str.matches("^[a-zA-Z]+$")) {
            throw new CaractereIncorrect("La saisie doit contenir uniquement des lettres.");
        }
    }

}
