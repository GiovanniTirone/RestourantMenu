package it.restaurantMenu.order.utilities;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import it.restaurantMenu.order.Order;
import it.restaurantMenu.order.interfaces.IOrder;
import it.restaurantMenu.order.interfaces.IOrderFilePDF;

import java.io.File;
import java.io.IOException;

public class OrderFilePDF implements IOrderFilePDF {

    @Override
    public void createPDF(IOrder order) throws IOException {

        File file = new File("order" + Order.getStringIdOrder(order.getIdOrder()) +".pdf");
        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDoc = new PdfDocument(writer);
        //Document document = new Document(pdfDoc);
        //Document document = new Document(pdfDoc, new PageSize(88, 160));
        //Document document = new Document(pdfDoc, new PageSize(302.36f, 453.54f));
        Document document = new Document(pdfDoc, new PageSize(88, 240));
        document.setMargins(0, 0, 0, 5);
        document.setFontSize(5);
        document.add(new Paragraph().add(order.getOrderDetails()));
        document.add(Barcode.createBarcode(String.format("%08d", order.getIdOrder()), pdfDoc));
        document.close();

    }

}
