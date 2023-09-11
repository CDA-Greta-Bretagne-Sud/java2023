import java.util.Scanner;

public class Agenda {
    private static Scanner scan =
            new Scanner(System.in);

    public static void agenda() {
        boolean[][] occupee =
                {{false, true, true, true, false, true, true, false, true, true, false},
                        {false, true, true, true, false, true, true, false, true, false, true},
                        {false, false, true, true, false, false, true, true, false, true, false},
                        {true, true, false, true, false, true, true, false, true, true, true},
                        {false, true, false, true, true, false, true, true, false, false, false}};
// question 1
        for (int i = 0; i < occupee.length; i++) {
            switch (i) {
                case 0:
                    System.out.println("lundi");
                    break;
                case 1:
                    System.out.println("Mardi");
                    break;
                case 2:
                    System.out.println("Mercredi");
                    break;
                case 3:
                    System.out.println("Jeudi");
                    break;
                case 4:
                    System.out.println("Vendredi");
                    break;
            }
            for (int plage = 0; plage < occupee[i].length; plage++) {
                if (occupee[i][plage]) {
                    System.out.print(" reservée de " + (plage + 8) + "H00 à ");
                    System.out.println((plage + 9) + "H00");
                }
            }
        }

// question 2
        int nbocc = 0;
        for (int jour = 0; jour < occupee.length; jour++) {
            for (int plage = 0; plage < occupee[jour].length; plage++) {
                if (occupee[jour][plage]) {
                    nbocc++;
                }
            }
        }
        System.out.println("Taux d’occupation: " +
                (nbocc * 100) / 50);
// question 3
        int jour;
        String rep;
        System.out.print("Entrez le jour de la réservation (lundi: 0,etc) ");
        jour = scan.nextInt();
        int plage;
        System.out.print("Entrez l’heure de début de la réservation ");
        System.out.print(" (ex: 8 pour 8H00) ");
        plage = scan.nextInt() - 8;
        if (occupee[jour][plage]) {
            System.out.println("Desole, la salle n’est pas disponible");
        } else {
            occupee[jour][plage] = true;
            System.out.println("reservation enregistree");
        }

    }


}
