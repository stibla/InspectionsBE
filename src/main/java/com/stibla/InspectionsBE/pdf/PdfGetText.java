package com.stibla.InspectionsBE.pdf;

//import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfGetText {
    public static String getText(byte[] pdfFile) throws IOException {
        PDDocument doc = PDDocument.load(pdfFile);
        String tmpText = new PDFTextStripper().getText(doc);
        doc.close();
        return tmpText; 
        
    }
}
