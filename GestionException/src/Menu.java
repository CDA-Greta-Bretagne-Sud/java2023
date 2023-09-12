import java.util.Scanner;

public class Menu {
    private static Scanner scan =
            new Scanner(System.in);

    String[] tabChoix;
    String question;

    Menu(String q, String[] t) throws NPasBon {
        if (t.length > 9) {
            throw new NPasBon();
        }
        tabChoix = t;
        question = q;
    }

    void affiche() {
        System.out.println(question);
        for (int i = 0; i < tabChoix.length; i++) {
            System.out.println(tabChoix[i] + ": tapez " + (i + 1));
        }
        System.out.print("Entrez votre choix: ");
    }

    int charToInt(char c) throws PasNombre {
        if (c == '1') {
            return 1;
        } else if (c == '2') {
            return 2;
        } else if (c == '3') {
            return 3;
        } else if (c == '4') {
            return 4;
        } else if (c == '5') {
            return 5;
        } else if (c == '6') {
            return 6;
        } else if (c == '7') {
            return 7;
        } else if (c == '8') {
            return 8;
        } else if (c == '9') {
            return 9;
        } else if (c == '0') {
            return 0;
        }
        throw new PasNombre();
    }

    int saisir() throws PasNombre, HorsIntervalle {
        char rep = scan.next().charAt(0);
        int repInt;
        repInt = charToInt(rep);
        if ((repInt == 0) || (repInt > tabChoix.length)) {
            throw new HorsIntervalle();
        }
        return repInt;
    }

    int executerMenu() throws PasNombre, HorsIntervalle {
        affiche();
        return saisir();
    }
}

