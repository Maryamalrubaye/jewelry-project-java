package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileTable {
    public void getWriter(String type, String grams, String price) {
        String tableFile = "table.txt";
        BufferedWriter writer = null;
        Boolean append = true;

        try {
            writer = new BufferedWriter(new FileWriter(tableFile,append));
            writer.write( "     "+type + "     " + grams + "     " + price+ "     ");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
