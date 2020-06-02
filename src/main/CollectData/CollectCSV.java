package main.CollectData;

import main.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CollectCSV implements ICollector {

    public List<Data> collectData(String filename) {
        List<Data> collected = new ArrayList<>();
        try {
            String filePath = "Data/" + filename + ".csv";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatter2 = new SimpleDateFormat("MMM dd, yyyy");
            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(";");
                try {
                    Date date = formatter2.parse(temp[0]);
                    //String date = formatter1.format(tempdate);
                    double price = Double.parseDouble(temp[1]);
                    double open = Double.parseDouble(temp[2]);
                    double high = Double.parseDouble(temp[3]);
                    double low = Double.parseDouble(temp[4]);
                    double vol = Double.parseDouble(temp[5]);
                    double change = Double.parseDouble(temp[6]);
                    Data t = new Data(date, price, open, high, low, vol, change);
                    collected.add(t);
                } catch (Exception ignored) {
                    System.out.println(ignored);
                    System.out.println(temp[0]);
                }
            }
            bufferedReader.close();


        } catch (FileNotFoundException fex) {
            System.out.println("File not found: " + fex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return collected;
    }

    public static void main(String[] args) throws ParseException {
        ICollector collector = new CollectCSV();
        List<Data> test = collector.collectData("VNIndex");
        System.out.println("size: " + test.size());
        System.out.println(test.get(test.size()-1));

    }

}
