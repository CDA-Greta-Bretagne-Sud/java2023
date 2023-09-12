import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LeveeException {

//    static Scanner scan = new Scanner(System.in);

    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);

    static void saisirChoix(int valeurSaisie) throws ThrowExc1, ThrowExc2{

        if (valeurSaisie < 1) {
            throw new ThrowExc1();
        } else if (valeurSaisie > 5) {
            throw new ThrowExc2();
        }

    }

    static void afficherMenu(String[] arrayMenu ) {

        for (int menuIndex = 0; menuIndex < arrayMenu.length; menuIndex++) {
            System.out.println("Menu "+ (menuIndex + 1) + " : " + arrayMenu[menuIndex]);
        }

    }

    static void choisirMenu (String[] arrayChoice, Scanner scan){

        boolean saisieOk;

        do {

            try {

                LeveeException.afficherMenu(arrayChoice);
                System.out.print("Choisir menu entre 1 et 5 : ");
                int choice = scan.nextInt();
                saisirChoix(choice);
                logger.info("Choix " + choice + " validé");
                logger.debug("Choix " + choice + " validé");
                System.out.println("Vous avez choisi le menu " + choice + " : " + arrayChoice[choice - 1]);
                saisieOk = true;
            } catch (ThrowExc1 e) {
                logger.info("Valeur négative entrée par l'utilisateur");
                logger.debug("Valeur négative entrée par l'utilisateur");
                System.out.println("La valeur est négative " + e);
                saisieOk = false;
            } catch (ThrowExc2 e) {
                logger.info("Valeur supérieure au nombre d'index entrée par l'utilisateur");
                logger.debug("Valeur supérieure au nombre d'index entrée par l'utilisateur");
                System.out.println("La valeur est supérieure à 5 " + e);
                saisieOk = false;
            } catch (InputMismatchException e) {
                logger.info("Valeur n'étant pas un integer entrée par l'utilisateur");
                logger.debug("Valeur n'étant pas un integer entrée par l'utilisateur");
                System.out.println("La valeur n'est pas un nombre entier " + e);
                scan.nextLine(); //Permet d'éviter une boucle infinie en consommant la nouvelle ligne
                saisieOk = false;
            }
        } while  (!saisieOk);  //Condition de sortie

    }

}

class ThrowExc1 extends Exception{};
class ThrowExc2 extends Exception{};
