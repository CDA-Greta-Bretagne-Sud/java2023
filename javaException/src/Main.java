// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Main {
    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Lancement du programme");
        logger.debug("Lancement du programme");


        Scanner scan = new Scanner(System.in);
//        try {
//            System.out.print("Entre un entier : ");
//            ExoException.methode3(scan.nextInt());
//        } catch (Exc1 | Exc3 e){
//            System.out.print("Une exception s'est produite : " + e );
//        }


//        boolean saisieOk;
//
//        do {
//
//            try {
//                System.out.print("Entrez une valeur entre 1 et 5 : ");
//                LeveeException.saisirChoix(scan.nextInt());
//                System.out.println("Valeur saisie correcte");
//                saisieOk = true;
//            } catch (ThrowExc1 e) {
//                System.out.println("La valeur est négative " + e);
//                saisieOk = false;
//            } catch (ThrowExc2 e) {
//                System.out.println("La valeur est supérieure à 5 " + e);
//                saisieOk = false;
//            } catch (InputMismatchException e) {
//                System.out.println("La valeur n'est pas un nombre entier " + e);
//                scan.nextLine(); //Permet d'éviter une boucle infinie en consommant la nouvelle ligne
//                saisieOk = false;
//            }
//        } while (!saisieOk); //Condition de sortie
//
        String[] arrayMenu = {
                "Galette saucisse",
                "Kebab frites",
                "Hamburger",
                "Pad thai",
                "Ailes de poulet"
        };
//
//        LeveeException.afficherMenu(arrayMenu);

//        LeveeException.choisirMenu(arrayMenu, scan);

        Menu menu1 = new Menu(arrayMenu);
        Menu menu2 = new Menu(arrayMenu);
        Menu menu3 = new Menu(arrayMenu);


        menu1.chooseMenu(scan);
        menu2.chooseMenu(scan);
        menu3.chooseMenu(scan);


    }
}