import java.util.Scanner;

public class OccupationSalle {

    public static void question1(){
        // tableau en deux dimension jour / horaire
        String[] jourSemaine = {"lundi", "mardi", "mercredi", "jeudi", "vendredi"};
        String[] heure = {"8-9", "9-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-19"};
        //boolean[][] calendrierDispo = new boolean[jourSemaine.length][heure.length];
        // affecter à chaque celule les valeurs demandés
        boolean[][] calendrierDispo = {{false, true, true, true, false, true, true, false, true, false},
                {false, true, true, true, false, true, true, false, true, false},
                {false, false, true, true, false, false, true, false, true, false},
                {true, true, false, true, false, true, true, false, true, true},
                {false, true, false, true, false, true, true, false, false, false}};

        for(int i=0; i < calendrierDispo.length; i++){
            for(int j = 0; j < calendrierDispo[i].length; j++){
                if(calendrierDispo[i][j]){
                    System.out.println("salle occupé le " + jourSemaine[i] + " de " + heure[j]);
                }
            }
        }
    }

    public static void question2(){
        String[] jourSemaine = {"lundi", "mardi", "mercredi", "jeudi", "vendredi"};
        String[] heure = {"8-9", "9-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-19"};
        int plagesReservees = 0;
        int nbPlage = 0;
        nbPlage = heure.length*jourSemaine.length;
        boolean[][] calendrierDispo = {{false, true, true, true, false, true, true, false, true, false},
                {false, true, true, true, false, true, true, false, true, false},
                {false, false, true, true, false, false, true, false, true, false},
                {true, true, false, true, false, true, true, false, true, true},
                {false, true, false, true, false, true, true, false, false, false}};
        for(int i=0; i < calendrierDispo.length; i++){
            for(int j = 0; j < calendrierDispo[i].length; j++){
                if(calendrierDispo[i][j]){
                    plagesReservees ++;
                }
            }
        }
        double tauxOccup = (double) plagesReservees / nbPlage;
        System.out.println(tauxOccup*100 + "%");
    }

    public static void question3(){
        String[] jourSemaine = {"lundi", "mardi", "mercredi", "jeudi", "vendredi"};
        String[] heure = {"8-9", "9-10", "10-11", "11-12", "13-14", "14-15", "15-16", "16-17", "17-18", "18-19"};
        boolean[][] calendrierDispo = {{false, true, true, true, false, true, true, false, true, false},
                {false, true, true, true, false, true, true, false, true, false},
                {false, false, true, true, false, false, true, false, true, false},
                {true, true, false, true, false, true, true, false, true, true},
                {false, true, false, true, false, true, true, false, false, false}};
        int choixJour = 0;
        int choixPlage = 0;

        // demander un jour
        Scanner scan = new Scanner(System.in);
        System.out.println("choisir un jour par son indice : ");
        for (int i = 0 ; i < jourSemaine.length; i++){
            System.out.print(i + " : " + jourSemaine[i] + " | ");
        }

        while (!scan.hasNextInt()) {
            System.out.println("Veuillez saisir un indice valide.");
            scan.next();
        }
        choixJour = scan.nextInt();

        // demander une plage (de 0 à longueur de liste)
        System.out.println("choisir une plage par son indice : ");
        for (int i = 0 ; i < heure.length; i++){
            System.out.print(i + " : " + heure[i] + " | ");
        }

        while (!scan.hasNextInt()) {
            System.out.println("Veuillez saisir un indice valide.");
            scan.next();
        }
        choixPlage = scan.nextInt();

        // vérifier si la plage est false ou true : si true, pas possible, si false, changer en true
        if(calendrierDispo[choixJour][choixPlage]){
            System.out.println("créneau indisponible");
            System.out.println(calendrierDispo[choixJour][choixPlage]);
        } else {
            System.out.println(calendrierDispo[choixJour][choixPlage]);
            calendrierDispo[choixJour][choixPlage] = true;
            System.out.println("Créneau réservé");
            System.out.println(calendrierDispo[choixJour][choixPlage]);
        }
    }

}
