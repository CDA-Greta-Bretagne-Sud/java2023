package fr.cda.projet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONFile implements Fichier{

    private String file;

    public JSONFile(String file) {
        this.file = file;
    }

    @Override
    public void writeFile(ArrayList<Media> medias, ArrayList<Emprunteur> emprunteurs) throws IOException {

        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode mediaArray = mapper.createArrayNode(); // Créez un tableau JSON pour les médias
            ArrayNode emprunteurArray = mapper.createArrayNode(); // Créez un tableau JSON pour les emprunteurs

            for (Media media : medias) {
                ObjectNode mediaNode = mapper.createObjectNode();
                mediaNode.put("identificateur", media.getIdentificateur());
                mediaNode.put("Catégorie", media.getCategorie());
                mediaNode.put("Sous-catégorie", media.getSousCategorie());
                mediaNode.put("Description", media.getDescription());
                mediaNode.put("numeroEmprunter", media.getNumeroEmprunter());
                mediaNode.put("DateEmprunt", media.getDateEmprunt());

                mediaArray.add(mediaNode); // Ajoutez le mediaNode au tableau JSON des médias
            }

            for (Emprunteur emprunteur : emprunteurs) {
                ObjectNode emprunteurNode = mapper.createObjectNode();
                emprunteurNode.put("Id" , emprunteur.getId());
                emprunteurNode.put("Nom", emprunteur.getNomEmprunteur());
                emprunteurNode.put("Prénom", emprunteur.getPrenomEmprunteur());
                emprunteurNode.put("Date de naissance", emprunteur.getDateDeNaissance());

                ArrayNode mediaEmprunteurArray = mapper.createArrayNode();

                for (Media media : emprunteur.getMediaEmprunter()) {
                    ObjectNode mediaEmprunteurNode = mapper.createObjectNode();
                    mediaEmprunteurNode.put("identificateur", media.getIdentificateur());
                    mediaEmprunteurNode.put("Catégorie", media.getCategorie());
                    mediaEmprunteurNode.put("Sous-catégorie", media.getSousCategorie());
                    mediaEmprunteurNode.put("Description", media.getDescription());
                    mediaEmprunteurNode.put("numeroEmprunter", media.getNumeroEmprunter());
                    mediaEmprunteurNode.put("DateEmprunt", media.getDateEmprunt());
                    mediaEmprunteurArray.add(mediaEmprunteurNode);
                }
                emprunteurNode.set("MediaEmprunter", mediaEmprunteurArray);

                emprunteurArray.add(emprunteurNode); // Ajoutez l'emprunteurNode au tableau JSON des emprunteurs
            }

            // Créez le nœud racine JSON et ajoutez les tableaux des médias et des emprunteurs
            ObjectNode rootNode = mapper.createObjectNode();
            rootNode.set("Medias", mediaArray);
            rootNode.set("Emprunteurs", emprunteurArray);

            // Maintenant, convertissez le nœud racine JSON en une chaîne JSON
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);

            FileWriter fichier = new FileWriter(file);
            // Écriture de la chaîne JSON dans le fichier
            fichier.write(json);
            fichier.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Mediatheque readFile() throws IOException {
        Mediatheque mediatheque = new Mediatheque();
        ObjectMapper mapper = new ObjectMapper();
        FileReader fileReader = new FileReader(file);
        try {
            // Lecture du fichier JSON en tant que JsonNode
            JsonNode rootNode = mapper.readTree(fileReader);

            // Traiter le contenu du fichier JSON et créer des objets
            if (rootNode.has("Medias")) {
                JsonNode mediaArrayNode = rootNode.get("Medias");
                if (mediaArrayNode.isArray()) {
                    for (JsonNode node : mediaArrayNode) {
                        if (node.has("identificateur")) {
                            String identificateur = node.get("identificateur").asText();
                            String categorie = node.get("Catégorie").asText();
                            String sousCategorie = node.get("Sous-catégorie").asText();
                            String description = node.get("Description").asText();
                            String numeroEmprunter = node.get("numeroEmprunter").asText();
                            String dateEmprunt = node.get("DateEmprunt").asText();

                            // Créer un objet Media à partir des données JSON
                            Media media = new Media(identificateur, Integer.parseInt(numeroEmprunter), categorie, sousCategorie, description, dateEmprunt);
                            mediatheque.getMedias().add(media);
                        }
                    }
                }
            }

            if (rootNode.has("Emprunteurs")) {
                JsonNode emprunteurArrayNode = rootNode.get("Emprunteurs");
                if (emprunteurArrayNode.isArray()) {
                    for (JsonNode node : emprunteurArrayNode) {
                        if (node.has("Id")) {
                            int id = node.get("Id").asInt();
                            String nom = node.get("Nom").asText();
                            String prenom = node.get("Prénom").asText();
                            String dateNaissance = node.get("Date de naissance").asText();

                            Emprunteur emprunteur = new Emprunteur(id, nom, prenom, dateNaissance);

                            if (node.has("MediaEmprunter")) {
                                JsonNode mediaEmprunteurArrayNode = node.get("MediaEmprunter");

                                if (mediaEmprunteurArrayNode.isArray()) {

                                    for (JsonNode mediaNode : mediaEmprunteurArrayNode) {
                                        String identificateur = mediaNode.get("identificateur").asText();
                                        String categorie = mediaNode.get("Catégorie").asText();
                                        String sousCategorie = mediaNode.get("Sous-catégorie").asText();
                                        String description = mediaNode.get("Description").asText();
                                        String numeroEmprunter = mediaNode.get("numeroEmprunter").asText();
                                        String dateEmprunt = mediaNode.get("DateEmprunt").asText();

                                        Media media = new Media(identificateur, Integer.parseInt(numeroEmprunter), categorie, sousCategorie, description, dateEmprunt);
                                        emprunteur.getMediaEmprunter().add(media);
                                    }
                                }
                            }
                            mediatheque.getEmprunteurs().add(emprunteur);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        fileReader.close();
        return mediatheque;
    }
}
