import java.util.Scanner;

public class Menu extends LeveeException {

    private String[] menuChoice;

    public Menu(String[] menuChoice) {
        super(); // Appel du constructeur de la classe parente (LeveeException)
        this.menuChoice = menuChoice;
    }

    public void chooseMenu(Scanner scan) {
        // Utilisation de la méthode statique de LeveeException pour choisir le menu
        LeveeException.choisirMenu(menuChoice, scan);
    }
}
