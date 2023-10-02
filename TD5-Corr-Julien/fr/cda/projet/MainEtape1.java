package fr.cda.projet;

public class MainEtape1 {
    public static void main(String[] args) {
        Mediatheque mediatheque = new Mediatheque();
        // Création des medias
        Media media1 = new Media("Livre", "Roman", "description Blabla");
        Media media2 = new Media("DVD", "Film", "description Blabla");
        Media media3 = new Media("Jeux", "Stratégie", "description Blabla");

        mediatheque.getMedias().add(media1);
        mediatheque.getMedias().add(media2);
        mediatheque.getMedias().add(media3);

        // Création des emprunteurs
        Emprunteur emprunteur1 = new Emprunteur("Bernard", "Jean", "08/07/1932");
        Emprunteur emprunteur2 =new Emprunteur("Morville", "Didier", "04/11/1969");
        Emprunteur emprunteur3 = new Emprunteur("Renard", "Jules", "03/03/1990");

        mediatheque.getEmprunteurs().add(emprunteur1);
        mediatheque.getEmprunteurs().add(emprunteur2);
        mediatheque.getEmprunteurs().add(emprunteur3);

        //mediatheque.afficher();

    }
}
