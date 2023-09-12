// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.util.InputMismatchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Main {
    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Lancement du programme");
        logger.debug("Lancement du programme");

        // Press Alt+Entrée with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Scanner scan = new Scanner(System.in);
        // Exo4 - Question 1
        //forme.carre(scan);

        //Exo4 - Question 2
        //forme.triangle();

        //TP6-JAVA - Exercice 4.1.1 tableau d'entiers
        //int[] tab = {12, 15, 13, 10, 8, 9, 13, 14};
        //Question 1
        //tableau.recherche(scan, tab);

        //Question 2
        //tableau.recherche2(scan, tab);

        //Question 3
        //tableau.recherche3(scan, tab);

        //Question 4
        //tableau.remplace(scan, tab);

        //Question 5
        //tableau.remplace2(scan, tab);

        //TP6-JAVA - Exercice 4.1.2 tableau entrée au clavier
        //Question 1
        //int[] Tab =new int[6];
        //tableau.remplirTableau(scan, Tab);

        //Question 2
        //tableau.rechercheMax(scan, Tab);

        //Question 3
        //char[] Tab = new char[6];
        //tableau.remplirTableauChar(scan, Tab);

        //Question 4
        //tableau.moyenne2(scan, Tab);

        //Question 5
        //int nb=tableau.saisieNombre(scan);
        //tableau.remplirTableauChar2(scan, nb);

        //TP6-JAVA - Exercice 4.1.3 nombre de lettres dans un tableau
        //Question 1
        //tableau.tableauChar(scan);

        //Question 2
        //tableau.tableauChar2(scan);

        //TP6_3-JAVA - Exercice 4.3.2 occupation de salle
        //Question 1
        //occupation.affichage(scan);

        //Question 2
        //occupation.tauxOccupation(scan);

        //Question 3
        /*boolean[][] occupee =
                {{false,true,true,true,false,true,true,false,true,false},
                        {false,true,true,true,false,true,true,false,true,false},
                        {false,false,true,true,false,false,true,false,true,false},
                        {true,true,false,true,false,true,true,false,true,true},
                        {false,true,false,true,false,true,true,false,false,false}};
        occupation.reservation(scan, occupee);*/

        //Exo sur les exceptions
        //Exo 4.1.2 exercice de lecture
        //exception.testException();

        //Exo 4.1.3 Menu
        //Question 1
        /*boolean saisieOk=true;
        do {
            try {
                System.out.print("Saisissez un nombre entre 1 et 5 pour faire votre choix : ");
                LeveeException.saisirChoix(scan.nextInt());
            } catch (ThrowExc1 e) {
                System.out.print("La valeur saisie est inférieure à 1. " + e);
                System.out.println();
                logger.info("Inférieure à 1 : " + e);
                saisieOk=false;
            } catch (ThrowExc2 e) {
                System.out.print("La valeur saisie est supérieure à 5. " + e);
                System.out.println();
                logger.info("Supérieur à 5 : " + e);
                saisieOk=false;
            } catch (PasNombre e) {
                System.out.print("La valeur saisie n'est pas un nombre. " + e);
                System.out.println();
                logger.info("PasNombre : " + e);
                saisieOk=false;
            }
        } while (!saisieOk);

        System.out.print("La valeur saisie est correcte. ");*/

        //Question 2 affichage du menu
        //String[] menu = {"Choix 1 : ", "Choix 2 : 2", "Choix 3 : 3", "Choix 4 : 4", "Choix 5 : 5"};
        //LeveeException.afficherMenu(menu);

        //Question 3 question et réponse
        //int choix=LeveeException.questionReponse(menu);

        //Récursivité
        //long n;
        //n=Recursivite.fact(4);
        //System.out.print(n);

        //Exo 3 Suite de Fibonnacci en récursive
        long n;
        n=Recursivite.suiteFibonnacci(4);
        System.out.print("La suite de Fibonnacci de 4 " + " est " + n);

        //forme.scan.close();
        scan.close();
    }
}

class Recursivite{
    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);
    public static long fact(long n){
        long res;
        if(n==0){
            res=1;
        } else {
            res=fact(n-1)*n;
        }
        return res;
    }

    public static long suiteFibonnacci(long n){
        long res;
        if(n==0){
            res=0;
        } else if (n==1) {
            res=1;
        } else {
            res=suiteFibonnacci(n-1)+suiteFibonnacci(n-2);
        }
        logger.info("F("+n+")="+res);
        return res;
    }

}

//Exo sur les exceptions
class LeveeException {
    protected static Scanner scan = new Scanner(System.in);
    private static final Logger logger = (Logger) LogManager.getLogger(LeveeException.class);
   public static int questionReponse(String[] choixMenu) {
        afficherMenu(choixMenu);
        boolean saisieOk=true;
        int choix =0;
        do {
            System.out.print("Saisissez un nombre entre 1 et 5 pour faire votre choix : ");
            choix = scan.nextInt();
            logger.info("Votre choix :" +choix);
            try {
                LeveeException.saisirChoix(choix);

            } catch (ThrowExc1 e) {
                System.out.print("La valeur saisie est inférieure à 1. " + e);
                System.out.println();
                logger.info("Inférieure à 1 : " + e);
                saisieOk=false;
            } catch (ThrowExc2 e) {
                System.out.print("La valeur saisie est supérieure à 5. " + e);
                System.out.println();
                logger.info("Supérieur à 5 : " + e);
                saisieOk=false;
            } catch (InputMismatchException e) {
                System.out.print("La valeur saisie n'est pas un nombre. " + e);
                System.out.println();
                logger.info("PasNombre : " + e);
                scan.nextLine(); //Permet d'éviter une boucle infinie
                saisieOk=false;
            } finally {
                scan.close();
            }
        } while (!saisieOk);

        System.out.print("La valeur saisie est correcte. ");
        return choix;
    }
    public static void afficherMenu(String[] choixMenu) {
        System.out.println("Menu :");
        for (int i = 0; i < choixMenu.length; i++) {
            System.out.println((i + 1) + ". " + choixMenu[i]);
        }
    }
    public static void saisirChoix(int nbSaisie) throws ThrowExc1, ThrowExc2{

                if (nbSaisie < 1 ) {
                    throw new ThrowExc1();
                } else if (nbSaisie > 5 ) {
                    throw new ThrowExc2();
                }
    }
}
class ThrowExc1 extends Exception{}
class ThrowExc2 extends Exception{}


/*    static void methode1(int p) throws Exc1, Exc2{
        System.out.print("Debut d’execution de methode1");
        if (p == 0){
            throw new Exc1 ();
        }
        System.out.print("Milieu d’execution de methode1");
        if(p ==1){
            throw new Exc2 ();
        }
        System.out.print("Fin d’execution de methode1");
    }
    static void methode2(int p) throws Exc1, Exc2, Exc3{
        System.out.print("Debut d’execution de methode2");
        if (p == 2){
            throw new Exc3();
        }
        System.out.print("Milieu d’execution de methode2");
        methode1(p);
        System.out.print("Fin d’execution de methode2");
    }
    static void methode3(int p) throws Exc1, Exc3{
        System.out.print("Debut d’execution de methode3");
        try{
            methode2(p);
        }catch(Exc2 ex){
            System.out.print("Debut d’execution de methode3");
        }
        System.out.print("Fin d’execution de methode3");
    }
    public static void testException() throws Exc1, Exc3{
        System.out.print("Entrez un nombre: ");
        methode3(scan.nextInt());
    }
}
class Exc1 extends Exception{}
class Exc2 extends Exception{}
class Exc3 extends Exception{}*/



//Exo sur les tableaux
/*class occupation{

    public static void reservation(Scanner scan, boolean[][] occupee) {
        boolean libre=false;
        int nbSaisie1;
        int nbSaisie2;

        do {
            do {
                System.out.print("Saisissez un nombre entre 1 et 5 pour le jour de la semaine: ");
                nbSaisie1 = scan.nextInt();
            } while (nbSaisie1 < 1 || nbSaisie1 > 5);

            do {
                System.out.print("Saisissez un nombre entre 1 et 10 pour la plage d'une heure désirée: ");
                nbSaisie2 = scan.nextInt();
            } while (nbSaisie2 < 1 || nbSaisie2 > 10);

            if (occupee[nbSaisie1-1][nbSaisie2-1]==false){
                occupee[nbSaisie1-1][nbSaisie2-1]=true;
                libre=true;
            }
        } while (libre==false);

        occupation.affichage(scan, occupee);
    }

    public static void tauxOccupation(Scanner scan){
        boolean[][] occupee =
                {{false,true,true,true,false,true,true,false,true,false},
                        {false,true,true,true,false,true,true,false,true,false},
                        {false,false,true,true,false,false,true,false,true,false},
                        {true,true,false,true,false,true,true,false,true,true},
                        {false,true,false,true,false,true,true,false,false,false}};


        for (int i=0; i<= occupee.length-1; i++) {
            int reserve=0;
            for(int j=0; j<=occupee[i].length-1; j++) {
                if (occupee[i][j] == true) {
                    reserve += 1;
                }
            }
            int resultat = reserve*100/occupee[i].length;
            System.out.println();
            if (i==0) {
                System.out.print("Le taux d'occupation le lundi est de " + resultat + "%");
            } else if (i==1) {
                System.out.print("Le taux d'occupation le mardi de " + resultat + "%");
            } else if (i==2) {
                System.out.print("Le taux d'occupation le mercredi de " + resultat + "%");
            } else if (i==3) {
                System.out.print("Le taux d'occupation le jeudi de " + resultat + "%");
            } else if (i==4) {
                System.out.print("Le taux d'occupation le vendredi de " + resultat + "%");
            }
        }
    }

    public static void affichage(Scanner scan, boolean[][] occupee){
        boolean[][] occupee =
                {{false,true,true,true,false,true,true,false,true,false},
                        {false,true,true,true,false,true,true,false,true,false},
                        {false,false,true,true,false,false,true,false,true,false},
                        {true,true,false,true,false,true,true,false,true,true},
                        {false,true,false,true,false,true,true,false,false,false}};

        for (int i=0; i<= occupee.length-1; i++) {
            System.out.println();
            if (i==0) {
                System.out.print("salle occupee le lundi ");
            } else if (i==1) {
                System.out.print("salle occupee le mardi ");
            } else if (i==2) {
                System.out.print("salle occupee le mercredi ");
            } else if (i==3) {
                System.out.print("salle occupee le jeudi ");
            } else if (i==4) {
                System.out.print("salle occupee le vendredi ");
            }

            for(int j=0; j<=occupee[i].length-1; j++) {
                if (occupee[i][j]==true){
                    if (j == 0) {
                        System.out.print("de 8H00 à 9H00");
                    } else if (j == 1) {
                        System.out.print("de 9H00 à 10H00");
                    } else if (j == 2) {
                        System.out.print("de 10H00 à 11H00");
                    } else if (j == 3) {
                        System.out.print("de 11H00 à 12H00");
                    } else if (j == 4) {
                        System.out.print("de 12H00 à 13H00");
                    } else if (j == 5) {
                        System.out.print("de 13H00 à 14H00");
                    } else if (j == 6) {
                        System.out.print("de 14H00 à 15H00");
                    } else if (j == 7) {
                        System.out.print("de 15H00 à 16H00");
                    } else if (j == 8) {
                        System.out.print("de 16H00 à 17H00");
                    } else if (j == 9) {
                        System.out.print("de 17H00 à 18H00");
                    } else if (j == 10) {
                        System.out.print("de 18H00 à 19H00");
                    }
                    System.out.println();
                }
            }
        }
    }
}

class tableau{

    public static void tableauChar2(Scanner scan){

        char[] tab = new char[10];
        for(int i=0; i<= tab.length-1; i++) {
            do {
                System.out.print("Saisissez un caractère : ");
                tab[i]= scan.next().charAt(0);
            } while (Character.isLetter(tab[i])==false);
        }

        int countMinuscule = 0;
        int countMajuscule = 0;

        for (int i=0; i<= tab.length-1; i++) {
            if (Character.isUpperCase(tab[i])) {
                countMajuscule += 1;
                } else  {
                countMinuscule += 1;
                }
        }

        System.out.println();
        System.out.print("Le nombre de minuscules est : "+ countMinuscule + " et le nombre de majuscules est : "+ countMajuscule);

    }
    public static void tableauChar(Scanner scan){
        //Initialisation
        char[] tabMinuscule = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] tabMajuscule = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        char[] tab = new char[10];
        for(int i=0; i<= tab.length-1; i++) {
            System.out.print("Saisissez un caractère : ");
            tab[i]= scan.next().charAt(0);
        }

        int countMinuscule = 0;
        int countMajuscule = 0;

        for (int i=0; i<= tab.length-1; i++) {
            for(int j=0; j<= tabMinuscule.length-1; j++) {
                if (tab[i]==tabMinuscule[j]) {
                    countMinuscule += 1;
                } else if (tab[i]==tabMajuscule[j]) {
                    countMajuscule += 1;
                }
            }
        }

        System.out.println();
        System.out.print("Le nombre de minuscules est : "+ countMinuscule + " et le nombre de majuscules est : "+ countMajuscule);

    }


    public static int saisieNombre(Scanner scan){
        int nbSaisie;
        System.out.print("Saisissez un nombre : ");
        nbSaisie = scan.nextInt();
        return nbSaisie;
    }

    public static void remplirTableauChar2(Scanner scan, int nombre){
        char[] Tab = new char[nombre];
        for(int i=0; i<= Tab.length-1; i++) {
            System.out.print("Saisissez un caractère : ");
            Tab[i]= scan.next().charAt(0);
        }

        for(int i=0; i<= Tab.length-1; i++) {
            System.out.print(Tab[i] + " ");
        }
    }

    public static void moyenne2(Scanner scan, int[] Tab) {
        tableau.remplirTableau(scan, Tab);
        System.out.println();

        double somme=0;
        for(int i=0; i<= Tab.length-1; i++) {
            somme = somme + Tab[i];
        }
        System.out.printf("La moyenne est : %0.2", somme/Tab.length);
    }

    public static void rechercheMax(Scanner scan, int[] Tab){
        tableau.remplirTableau(scan, Tab);
        System.out.println();

        int max = Tab[0];
        for(int i=0; i<= Tab.length-1; i++) {
            if (Tab[i]>max) {
                max = Tab[i];
            }
        }
        System.out.print("Le max est : "+ max);
    }

    public static void remplirTableauChar(Scanner scan, char[] Tab){

        for(int i=0; i<= Tab.length-1; i++) {
            System.out.print("Saisissez un caractère : ");
            Tab[i]= scan.next().charAt(0);
        }

        for(int i=0; i<= Tab.length-1; i++) {
            System.out.print(Tab[i] + " ");
        }
    }

    public static void remplirTableau(Scanner scan, int[] Tab){

        for(int i=0; i<= Tab.length-1; i++) {
            System.out.print("Saisissez un nombre entier : ");
            Tab[i] = scan.nextInt();
        }
        for(int i=0; i<= Tab.length-1; i++) {
            System.out.print(Tab[i] + " ");
        }
    }

    public static void recherche(Scanner scan, int[] tab){
        boolean test=false;
        int nbSaisie;
        System.out.print("Saisissez un nombre entier : ");
        nbSaisie = scan.nextInt();
        for(int i=0; i<=tab.length-1; i++){
            if (tab[i]==nbSaisie){
                test=true;
            }
        }
        if (test==true){
            System.out.print("Oui, ce nombre entier est dans le tableau.");
        }
        else{
            System.out.print("Non, ce nombre entier n'est pas dans le tableau.");
        }
    }

    public static void recherche2(Scanner scan, int[] tab){
        boolean test=false;
        int nbSaisie; int indice=-1;
        System.out.print("Saisissez un nombre entier : ");
        nbSaisie = scan.nextInt();
        for(int i=0; i<=tab.length-1; i++){
            if (tab[i]==nbSaisie){
                test=true;
                indice=i;
            }
        }
        if (test==true){
            System.out.print("Oui, ce nombre entier est dans le tableau, au rang " + indice + ".");
        }
        else{
            System.out.print("Non, ce nombre entier n'est pas dans le tableau.");
        }
    }

    public static void recherche3(Scanner scan, int[] tab){
        boolean test=false;
        int nbSaisie; int indice=-1;
        System.out.print("Saisissez un nombre entier : ");
        nbSaisie = scan.nextInt();
        for(int i=0; i<=tab.length-1; i++){
            if (tab[i]==nbSaisie){
                test=true;
                indice=i;
                break;
            }
        }
        if (test==true){
            System.out.print("Oui, ce nombre entier est dans le tableau, au rang " + indice + ".");
        }
        else{
            System.out.print("Non, ce nombre entier n'est pas dans le tableau.");
        }
    }

    public static void remplace(Scanner scan, int[] tab){
        int nbSaisie; int indice=-1;
        System.out.print("Saisissez un nombre entier : ");
        nbSaisie = scan.nextInt();

        do {
            System.out.print("Saisissez un indice : ");
            indice = scan.nextInt();
        }
        while (indice<0 || indice> tab.length);

        System.out.print("Avant transformation: ");
        for(int i=0; i<=tab.length-1; i++){
            System.out.print(tab[i] + " ");
        }
        System.out.println();

        System.out.print("Après transformation: ");
        tab[indice]=nbSaisie;
        for(int i=0; i<=tab.length-1; i++){
            System.out.print(tab[i] + " ");
        }
    }

    public static void remplace2(Scanner scan, int[] tab){
        int indice=-1;int indice2=-1;
        int tampon=0;
        do {
            System.out.print("Saisissez un indice1 : ");
            indice = scan.nextInt();
        }
        while (indice<0 || indice> tab.length);

        do {
            System.out.print("Saisissez un indice2 : ");
            indice2 = scan.nextInt();
        }
        while (indice2<0 || indice2> tab.length);

        System.out.print("Avant transformation: ");
        for(int i=0; i<=tab.length-1; i++){
            System.out.print(tab[i] + " ");
        }
        System.out.println();

        System.out.print("Après transformation: ");
        tampon=tab[indice];
        tab[indice]=tab[indice2];
        tab[indice2]=tampon;
        for(int i=0; i<=tab.length-1; i++){
            System.out.print(tab[i] + " ");
        }
    }
}


class forme{

    protected static Scanner scan = new Scanner(System.in);

    public static void carre(){
        int taille;
        System.out.print("Saisissez la dimension du carré : ");
        taille = scan.nextInt();

        for (int i=0; i<taille; i++){
            for (int j=0; j<taille; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void triangle(){
        int nbLigne;
        System.out.print("Saisissez le nombre de ligne : ");
        nbLigne = scan.nextInt();

        for (int i=1; i<nbLigne+1; i++){
            int nbEspace = nbLigne-i;
            int nbEtoile = 2*i-1;
            for (int j=0; j<nbEspace; j++){
                System.out.print(" ");
            }
            for (int j=0; j<nbEtoile; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}*/

/*class verifDate{
    public static void(){
        boolean dateCorrecte = false;

        do {
            Scanner scan = new Scanner(System.in);
            int annee;
            System.out.print("Saisissez une année : ");
            annee = scan.nextInt();

            int mois;
            System.out.print("Saisissez un mois : ");
            mois = scan.nextInt();

            int jour;
            System.out.print("Saisissez un jour : ");
            jour = scan.nextInt();

            //Erreurs rencontrées :
            //Année bissextile : Si mois = 2 alors 1<= jour <= 29 - Année non bissextile : Si mois = 2 alors 1<= jour <= 28
            //Mois : 1<= mois <= 12
            //Jour : 1<= jour <= 31 => Si mois = 1, 3, 5, 7, 8, 10, 12
            //Jour : 1<= jour <= 30 => Si mois = 4, 6, 9, 11
            if (Bissextile.calculBissextile(annee)==true){
                if (mois==2) {
                    if ((jour>=1) && (jour <= 29)){
                        dateCorrecte=true;
                    }
                    else {
                        System.out.print("Le nombre de jour pour le mois de février ");
                    }
                }
                else {

                }
            }
            else {
                if (mois==2) {
                    if ((jour>=1) && (jour <= 28)){
                        dateCorrecte=true;
                    }
                }
                else {

                }
            }

        }
        while (dateCorrecte!=true);

        //afficher la date saisie
        System.out.print("La date saisie est valide : " +jour + "/" + mois + "/" + annee);

        scan.close();
    }
}

class Fibonnacci{
    public static boolean calculFibonnacci(int count){
        int nbr1=0, nbr2=1, nbr3=0;
        //afficher 0 et 1
        System.out.print(nbr1+" "+nbr2);

        //La boucle commence par 2 car 0 et 1 sont deja affiches
        for(int i=2; i<count; ++i)
        {
            nbr3 = nbr1 + nbr2;
            nbr1 = nbr2;
            nbr2 = nbr3;
            System.out.print(" "+nbr3);
        }
        return true;
    }
}

class Bissextile{
    private boolean resultat;
    public Bissextile(int y){
        resultat=this.calculBissextile(y);
    }

    /*public  prochainesAnneesBissextiles(int A, int n){
        for (int i=1; i<=n; i++){
            A+= i;
            resutat=this.calculBissextile(A);
        }
    }

    public static boolean calculBissextile(int A){
        if (A%4==0) {
            if ((A%100==0) && (A%400!=0)) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
    public boolean isResultat() {
        return resultat;
    }
    public void setResultat(boolean resultat) {
        this.resultat = resultat;
    }
}

class Factoriel{

    //utiliser plutôt private que public pour des raisons de sécurité
    //Générer Getter et Setter avec un clic droit sur resultat
    private int resultat;

    public Factoriel(int y){
        resultat=this.calculFactoriel(y);
    }
    public int calculFactoriel(int x){
        int r = 1;

        for (int i=2; i<=x; i++){
            r*= i;
        }
        return r;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}*/

