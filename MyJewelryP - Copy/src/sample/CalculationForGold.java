package sample;

import java.io.*;

public class CalculationForGold extends JWorkshop implements IJDollar {
    public double dollar(int caliber, double ONS, double grams, double wages){
        double div;
        double result = 0;
        if (caliber == 24) {
            result = ((ONS / 31.1f)  + wages) * grams;
        } else if (caliber == 22) {
            div = (ONS / 31.1f) * 0.916f;
            result = (div+ wages)*grams;
        } else if (caliber == 21) {
            div = (ONS / 31.1f) * 0.875f;
            result = (div+ wages)*grams;
        } else if (caliber == 18) {
            div = (ONS / 31.1f) * 0.750f;
            result = (div+ wages)*grams;
        } else if (caliber == 14) {
            div = (ONS / 31.1f) * 0.585f;
            result = (div+ wages)*grams;
        } else if (caliber == 12) {
            div = (ONS / 31.1f) * 0.500f;
            result = (div+ wages)*grams;
        } else if (caliber == 8) {
            div = (ONS / 31.1f) * 0.335;
            result = (div+ wages)*grams;
        }
      return result;
    }

    @Override
    public void subtraction( String choice , double sumResult) {

        String s = String.valueOf(sumResult);
        if (choice=="Restart & Save") {
            try {
                File f = new File ("subgold.txt");
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
                File f = new File ("subgold.txt");
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
                FileReader fr= new FileReader ("subgold.txt");
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
