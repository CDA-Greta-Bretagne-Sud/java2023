import projet.Emprunteur;
import projet.GUISite;
import projet.Media;
import projet.Mediatheque;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.SaveToFile.readFromFile;

public class Main {
    public static void main(String[] args) {
        List<Emprunteur> emprunteurs = new ArrayList<>();
        List<Media> medias = new ArrayList<>();
        Mediatheque m = new Mediatheque(medias, emprunteurs);
        try {
            readFromFile("data.txt", emprunteurs, medias);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GUISite ihm = new GUISite(m);
    }
}