package sample;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

import static com.itextpdf.text.Font.FontFamily.COURIER;

public class PrintInvoice {
    public void print(String name, String sum) throws IOException, DocumentException {

        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(name+".pdf"));

        doc.open();


        Font f = new Font(COURIER, 25, Font.BOLD, BaseColor.RED);
        Paragraph paragraph = new Paragraph("  JEWELRY WORKSHOP ", f);
        paragraph.setSpacingAfter(25);
        paragraph.setSpacingBefore(25);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        Font fc = new Font(COURIER, 18, Font.BOLD, BaseColor.BLACK);
        Chunk chunk = new Chunk("************************************************",fc);
        Chunk chunk1 = new Chunk("************************************************",fc);
        Chunk chunk2 = new Chunk("************************************************",fc);
        Chunk chunk3 = new Chunk("************************************************",fc);


        File file = new File("Invoice.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuffer sb=new StringBuffer();
        String line;
        while((line=br.readLine())!=null)
        {
            sb.append(line);
            sb.append("\n");
            sb.append("\n");
        }

        File file1 = new File("table.txt");
        StringBuffer sb1=new StringBuffer();
        BufferedReader br1 = new BufferedReader(new FileReader(file1));

        String line1;
        while((line1=br1.readLine())!=null)
        {
            sb1.append(line1);
            sb1.append("\n");
            sb1.append("\n");
        }



        Font f1 = new Font(COURIER, 15, Font.BOLD, BaseColor.BLUE);

        Paragraph paragraph1 = new Paragraph();
        paragraph1.setAlignment(Element.ALIGN_LEFT);
        paragraph1.setFont(f1);
        paragraph1.add(sb.toString());


        Font f2 = new Font(COURIER, 15, Font.BOLD, BaseColor.BLACK);

        Paragraph paragraph2 = new Paragraph(sb1.toString(), f2);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        paragraph2.setSpacingBefore(25);
        paragraph2.setSpacingAfter(25);


        Paragraph paragraph3 = new Paragraph("TOTAL :  " + sum + "$", f2);
        paragraph3.setAlignment(Element.ALIGN_RIGHT);
        paragraph3.setSpacingAfter(25);

        Paragraph paragraph4 = new Paragraph("     "+"Type"+"     "+"Grams"+"     "+"Price"+"     ",f2);
        paragraph4.setAlignment(Element.ALIGN_CENTER);
        paragraph4.setSpacingBefore(25);
        paragraph4.setSpacingAfter(25);


        doc.add(paragraph);
        doc.add(chunk);
        doc.add(paragraph1);
        doc.add(chunk1);
        doc.add(paragraph4);
        doc.add(chunk2);
        doc.add(paragraph2);
        doc.add(chunk3);
        doc.add(paragraph3);
        doc.close();


    }
}