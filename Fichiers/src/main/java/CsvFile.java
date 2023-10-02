import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFile implements Fichier {
    private String file;

    public CsvFile(String file) {
        this.file = file;
    }

    @Override
    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String ligne = null;
        String[] data = new String[3];
        while ((ligne = br.readLine()) != null) {
            //retourne loa ligne du fichier
            // et stocke chaque occurence délimité par un ,
            // dans une case du tableau
            data = ligne.split(",");

            for (String val : data) {
                System.out.print(val +" ");
            }
            System.out.println();
        }

    }

    @Override
    public void writeFile() throws IOException {
        final String DELIMITER = ",";
        final String SEPARATOR = "\n";
        // entete du fichier csv
        final String HEADER = "Nom,Prenom,Email";
        FileWriter fichier = new FileWriter(file);
        //ajout de l'entete
        fichier.append(HEADER);
        //ajout d'une nouvelle ligne
        fichier.append(SEPARATOR);
        fichier.append("Macron");
        fichier.append(DELIMITER);
        fichier.append("Brigitte");
        fichier.append(DELIMITER);
        fichier.append("b.macron@orange.fr");
        fichier.append(SEPARATOR);
        fichier.append("Hollande");
        fichier.append(DELIMITER);
        fichier.append("François");
        fichier.append(DELIMITER);
        fichier.append("f.hollande@free.fr");

        //fermer mon fichier

        fichier.close();


    }
}
