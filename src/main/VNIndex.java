package main;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;


public class VNIndex extends Stock {
    public VNIndex(String name, String code, String date) {
        super(name, code, date);
    }

    public void sentence1() {
        String code = this.getName();
        String date = this.getDate();
        Data data = this.getData(date);

        List<String> patterns = ReadFile.readFile("Data\\sentences_data\\Sentence1.txt");

        Random rand = new Random();
        int index = rand.nextInt() % patterns.size();

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, date, data.open);

        System.out.println(result);
    }


    public static void main(String[] args) {
        // Format date : yyyy-mm-dd
        VNIndex vni = new VNIndex("VNIndex", "VNI", "2020-04-21");
        vni.collecting();
        Data x = vni.getData("2020-04-21");
        System.out.println(x.toString());

    }
}
