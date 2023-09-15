public class Bibliotheque {
    /**
     * variable static nbLivrePresents présents dans la bib
     */
    public static int nbLivresPresents =0;
    /**
     * variable static Bib (tableau de livres)
     */
    public static Livre[] bib = new Livre[25];


    /**
     * Ajout d'un Livre dans la bib
     *
     * @param l
     */
    public static void ajoutLivre(Livre l) {
        if (l != null) {
            Bibliotheque.bib[nbLivresPresents] = l;
            //incrémentation de la variable static nbLivrePresents
            Bibliotheque.nbLivresPresents++;
        }
    }

    /**
     * Affichage des livres d ela bibliotheque
     *
     * @return
     */
    public static String inString() {
        //StringBuffer pour concatener des grandes chaines de caracteres
        final StringBuffer sb = new StringBuffer("Bibliotheque:" + "\n");
        for (int i = 0; i < nbLivresPresents; i++) {
            //retour a la ligne /n
            sb.append("Index:" + i + " - " + bib[i].toString() + "\n");
        }

        return sb.toString();
    }

    /**
     * *Recherche dans la Bib par titre - auteur - editeur
     *
     * @return tableau d'index
     */
    public static int[] rechercheLivre() throws LivreException {
        //rechercher livre
        int tab[] = initTab();
        int k = 0, l = 0, m = 0; char j = 0;
        Boolean ok=true;
        //Menu
        while(ok) {
            System.out.println("1- Recherche par Titre");
            System.out.println("2- Recherche par Auteur");
            System.out.println("3- Recherche par Editeur");
            System.out.print("Votre choix:");
            j = Util.scan.next().charAt(0);
            Util.scan.nextLine();
            if(j=='1' || j=='2'|| j=='3')
                ok=false;
        }
        System.out.print("Texte à chercher:");
        String t = Util.scan.nextLine();
        for (int i = 0; i < nbLivresPresents; i++) {
            //si j =1 -> titre j=2-> auteur j=3-> Editeur
            switch (j) {
                //recherche par titre
                case '1':
                    if (t.equalsIgnoreCase(Bibliotheque.bib[i].getTitre())) {
                        //on stocke l'index dans le tab
                        tab[k] = i;
                        k++;
                    }
                    break;
                //recherche par auteur
                case '2':
                    if (t.equalsIgnoreCase(Bibliotheque.bib[i].getAuteur())) {
                        //on stocke l'index dans le tab
                        tab[l] = i;
                        l++;
                    }
                    break;
                //recherche par editeur
                case '3':
                    if (t.equalsIgnoreCase(Bibliotheque.bib[i].getEditeur())) {
                        //on stocke l'index dans le tab
                        tab[m] = i;
                        m++;
                    }
                    break;
            }

        }
        //retourne  le tableau d'index
        return tab;
    }

    /**
     * Initialise un tableau d"une longeurs nbLivresPresents avec des valeurs de -1
     * @return tableau d'entier
     */
    public static int[]  initTab() {
        int tab[] = new int[nbLivresPresents];
        for (int i = 0; i < nbLivresPresents; i++) {
            tab[i] = -1;
        }
        return tab;

    }

}







