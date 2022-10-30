package it.restaurantMenu.menu.utilities;

import com.itextpdf.barcodes.BarcodeEAN;
import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;

public class QrCode {

    public static Image createQrCode(String code, PdfDocument pdfDoc){

        BarcodeQRCode qrCode = new BarcodeQRCode(code);
        PdfFormXObject barcodeObject = qrCode.createFormXObject(ColorConstants.BLACK, pdfDoc);
        Image barcodeImage = new Image(barcodeObject).setWidth(120f).setHeight(120f);
        return barcodeImage;
    }

}
