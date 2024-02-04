package com.herokuapp.theinternet.PDFfileReadPrint;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ExtractContent {
    static WebDriver driver = null;

    public static void main(String[] args) {

        //instantiate the driver
        driver = new ChromeDriver();
        //specify the url of the pdf file
        String url = "http://www.pdf995.com/samples/pdf.pdf";
        driver.get(url);
        try {
            String pdfContent = readPdfContent(url);
            System.out.println(pdfContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readPdfContent(String url) throws IOException {

        URL pdfUrl = new URL(url);
        InputStream in = pdfUrl.openStream();
        BufferedInputStream bf = new BufferedInputStream(in);
        PDDocument doc = PDDocument.load(bf);
        PDFTextStripper pdfStrip = new PDFTextStripper();
        pdfStrip.setStartPage(2);

        /**
         * If we wish to print the contents starting from page 2 to page 3
         * we can set the below option in our code.
         */
        //	pdfStrip.setStartPage(2);
        //	pdfStrip.setEndPage(3);

        /**
         * If we want to print the entire content of a single page,
         * we can mention the same page number as the start as well as the end page
         */
        //	pdfStrip.setStartPage(2);
        //	pdfStrip.setEndPage(2);

        String content = pdfStrip.getText(doc);
        doc.close();

        return content;
    }

    public static int getPageCount(PDDocument doc) {
        //get the total number of pages in the pdf document
        int pageCount = doc.getNumberOfPages();
        return pageCount;
    }
}