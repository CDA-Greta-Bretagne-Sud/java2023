public class Bibliotheque {
    public static Livre[] bib = new Livre[25];
    public static int nbLivresPresents;
    //ajouter livre
    public static void ajoutLivre(Livre l) {
        if (l != null) {
            Bibliotheque.bib[nbLivresPresents] = l;
            Bibliotheque.nbLivresPresents++;
        }
    }
    //afficher livre
    public static String inString() {
        final StringBuffer sb = new StringBuffer("Bibliotheque{");
        for (int i = 0; i < nbLivresPresents; i++) {
            sb.append(bib[i].toString() + "/n");
        }
        sb.append('}');
        return sb.toString();
    }
}
//TODO editer Livre

//TODO supprimer Livre

//TODO rechercher livre par titre

//TODO rechercher par auteur

//TODO rechercher par editeur





