import java.util.Arrays;

public class Bibliotheque {
    Livre[] livres;
    private int nbLivres;  // Nombre de livres actuellement dans la bibliothèque

    public Bibliotheque(int tailleMax) {
        livres = new Livre[tailleMax];
        nbLivres = 0;
    }

    public void ajouterLivre(Livre livre) {
        if (nbLivres < livres.length) {
            livres[nbLivres] = livre;
            nbLivres++;
        } else {
            System.out.println("Bibliothèque pleine. Impossible d'ajouter plus de livres.");
        }
    }

    public void editerLivre(){
        int index;
        System.out.println("Contenu de la bibliothèque pré-modification : ");
        System.out.println(this);
        System.out.print("Veuillez sélectionner l'index du livre que vous souhaitez modifier : ");
        index = Util.scan.nextInt();
        Util.scan.nextLine();
        System.out.println("Vous avez sélectionné le livre suivant : " + '\n' + "  " + livres[index]);
        String titre, auteur, editeur;
        System.out.print("Veuillez entrer le nouveau titre : ");
        titre = Util.scan.nextLine();
        System.out.print("Veuillez entrer le nouvel auteur : ");
        auteur = Util.scan.nextLine();
        System.out.print("Veuillez entrer le nouvel editeur : ");
        editeur = Util.scan.nextLine();
        livres[index].setTitre(titre);
        livres[index].setAuteur(auteur);
        livres[index].setEditeur(editeur);
        System.out.println("Contenu de la bibliothèque après modification : ");
        System.out.println(this);
    }

    public int[] rechercheLivreTitre(String titre){
        int cpt= 0;
        int cptIndexTab = 0;
        for (int i = 0; i < nbLivres; i++) {
            if(livres[i].getTitre().equals(titre)){
                cpt++;
            }
        }
        int [] tabIndex = new int[cpt];
        for (int i = 0; i < nbLivres; i++) {
            if(livres[i].getTitre().equals(titre)){
                tabIndex[cptIndexTab] = i;
                cptIndexTab++;
            }
        }
        return tabIndex;
    }
//    TODO supprimer livre
//    TODO recherche livre par auteur
//    TODO recherche livre par editeur

    @Override
    public String toString() {
        String affichage = "";
        for (int i = 0; i < nbLivres; i++) {
            affichage = affichage + "  " + i + ". " + livres[i].toString() + '\n';
        }
        return affichage;
    }

}
