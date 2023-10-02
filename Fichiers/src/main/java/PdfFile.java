import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.IOException;

public class PdfFile implements Fichier {

    private String file;

    public PdfFile(String file) {
        this.file = file;
    }

    @Override
    public void readFile() throws IOException {
        PdfReader pr = new PdfReader(file);
        PdfDocument doc = new PdfDocument(pr);
        int num = doc.getNumberOfPages();

        for (int i = 1; i <= num; i++) {
            String str = PdfTextExtractor.getTextFromPage(doc.getPage(i));
            System.out.println(str);
        }
        doc.close();
    }

    @Override
    public void writeFile() throws IOException {
        //gestionnaire de l'ecriture dans le fichier pdf
        PdfWriter writer = new PdfWriter(file);
        //creation d'un document avec plusieurs page
        PdfDocument pdfDoc = new PdfDocument(writer);
        //creation du contenu de la page du document
        Document doc = new Document(pdfDoc);

        PdfFont myFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        Paragraph p1 = new Paragraph();
        p1.add("Coucou les CDA , ceci esty mon premier paragraphe:");
        p1.setTextAlignment(TextAlignment.CENTER);
        p1.setFont(myFont);
        p1.setFontSize(28);
        doc.add(p1);

        Paragraph p2 = new Paragraph();
        p2.add("Utilisation d'Itext");
        p2.setFontSize(18);
        doc.add(p2);
        //TODO  faire la meme chose qu'avec le document word
        doc.close();
    }
}
