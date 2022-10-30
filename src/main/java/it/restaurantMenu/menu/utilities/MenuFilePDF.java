package it.restaurantMenu.menu.utilities;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import it.restaurantMenu.menu.Menu;

import java.io.File;
import java.io.IOException;

public class MenuFilePDF {

    public void createPDF(Menu menu) throws IOException {

        File file = new File("menu-" + menu.type.toLowerCase() + ".pdf");
        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);
        //document.setMargins(0, 0, 0, 5);
        document.setFontSize(14);
        document.setTextAlignment(TextAlignment.CENTER);
        document.add(new Paragraph().add(menu.printMenuDetails()));
        Image qrCode = QrCode.createQrCode(menu.type, pdfDoc);
        document.add(new Paragraph().add(qrCode));
        document.close();

    }

}
