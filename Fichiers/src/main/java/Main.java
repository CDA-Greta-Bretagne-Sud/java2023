import java.io.IOException;

public class Main {

    public static void main(String[] titi) {

        System.out.println("ecriture et lecture de fichiers");

        try {
            Fichier tab[] = new Fichier[5];
            Fichier f1 = new CsvFile("fichier.csv");
            Fichier f2 = new PdfFile("fichier.pdf");
            Fichier f3 = new JSONFile("fichier.json");
            Fichier f4 = new WordFile("fichier.docx");
            Fichier f5 = new ExcelFile("fichier.xlsx");
            tab[0] = f1;
            tab[1] = f2;
            tab[2] = f3;
            tab[3] = f4;
            tab[4] = f5;


            for (Fichier f : tab) {
                f.writeFile();
                f.readFile();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
