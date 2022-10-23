package it.restaurantMenu.menu.utilities;

import it.restaurantMenu.menu.Menu;

import java.io.File;
import java.io.IOException;

public class MenuFilePDF {

    public void createPDF(Menu menu) throws IOException {

        /*File file = new File("menu-" + menu.type.toLowerCase() + ".pdf");
        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);
        document.setMargins(0, 0, 0, 5);
        //document.setFontSize(5);
        document.add(new Paragraph().add(menu.printMenuDetails()));
        document.close();*/

    }

}
