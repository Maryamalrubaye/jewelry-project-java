package sample;

import java.io.*;

public class CalculationForSilver extends JWorkshop implements IJDollar {
        @Override
        public double dollar(int caliber, double ONS, double grams, double wages) {
            double div;
            div = (ONS / 31.1f) * 0.925f;
            double result = (div + wages)*grams;
            return result;
        }
        @Override
        public void subtraction(String choice , double sumResult) {
            String s = String.valueOf(sumResult);
            if (choice=="Restart & Save") {
                try {
                    File f = new File ("subSilver.txt");
                    FileWriter writer = new FileWriter(f);
                    BufferedWriter b = new BufferedWriter(writer);
                    b.write(s);
                    b.close();
                    writer.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else if (choice=="Save") {
                try {
                    File f = new File ("subSilver.txt");
                    FileWriter writer = new FileWriter(f,true);
                    BufferedWriter  b= new BufferedWriter(writer);
                    b.write(" \n" +s);
                    b.close();
                    writer.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        @Override
        public String total() {
            double sum=0;
            try {
                FileReader fr= new FileReader ("subSilver.txt");
                BufferedReader br= new BufferedReader(fr);
                String s;
                while ((s=br.readLine()) != null) {
                    System.out.println(s);
                    double d= Double.parseDouble(s);
                    sum+=d;
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Double.toString(sum);


        }

    }

