package util;
import projet.Emprunteur;
import projet.Media;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static projet.Media.findMediaById;

public class SaveToFile {
    public static void writeToFile(List<Emprunteur> emprunteurs, List<Media> medias, String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Media m : medias) {
            lines.add("M;" + m.getId() + ";" + m.getCategorie() + ";" + m.getSousCategorie() + ";" + m.getDescription() + ";" + m.getNumeroEmprunteur() + ";" + m.isEmprunte());
        }
        for (Emprunteur e : emprunteurs) {
            StringBuilder mediaEmpruntes = new StringBuilder();
            for (Media media : e.getMediaEmpruntes()) {
                mediaEmpruntes.append(media.getId()).append(",");
            }
            if (mediaEmpruntes.length()>0) {
                mediaEmpruntes.setLength(mediaEmpruntes.length() - 1);
            }
            lines.add("E;" + e.getNumero() + ";" + e.getPrenom() + ";" + e.getNom() + ";" + e.getDateNaissance() + ";" + mediaEmpruntes);
        }
        Files.write(Paths.get(filename), lines);
    }

    public static void readFromFile(String filename, List<Emprunteur> emprunteurs, List<Media> medias) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            String[] parts = line.split(";");

            if (parts[0].equals("M")) {
                Media m = new Media(parts[1], parts[2], parts[3], parts[4]);
                m.setNumeroEmprunteur(Integer.parseInt(parts[5]));
                m.setEmprunte(Boolean.parseBoolean(parts[6]));
                medias.add(m);
            } else if (parts[0].equals("E")) {
                if (parts.length == 6) {
                    String[] mediaIds = parts[5].split(",");
                    List<Media> mediasEmpruntesList = new ArrayList<>();
                    for (String mediaId : mediaIds) {
                        System.out.println("media ID : " + mediaId);
                        Media media = findMediaById(mediaId, medias);
                        if (media != null) {
                            mediasEmpruntesList.add(media);
                        }
                    }
                    Emprunteur e = new Emprunteur(Integer.parseInt(parts[1]), parts[2], parts[3], parts[4], mediasEmpruntesList);
                    emprunteurs.add(e);
                } else {
                    Emprunteur e = new Emprunteur(Integer.parseInt(parts[1]), parts[2], parts[3], parts[4]);
                    emprunteurs.add(e);
                }
            }
        }
    }
}
