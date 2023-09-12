

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Combien de livres au maximum la bibliothèque peut-elle contenir?");
        int tailleMax = scanner.nextInt();
        scanner.nextLine();

        Bibliotheque bibliotheque = new Bibliotheque(tailleMax);

        System.out.println("Combien de livres souhaitez-vous ajouter?");
        int nombreLivres = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nombreLivres; i++) {
            try {
                Livre livre = Livre.saisirLivre();
                bibliotheque.ajouterLivre(livre);
            } catch (SaisieInvalide e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Contenu de la Bibliothèque:");
        System.out.println(bibliotheque);
    }
}
