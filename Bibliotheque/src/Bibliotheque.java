public class Bibliotheque {
    private Livre[] livres;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nbLivres; i++) {
            sb.append(livres[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
