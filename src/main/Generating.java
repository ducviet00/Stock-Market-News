package main;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class Generating {
    private final String code;
    private final String name;
    private final String date;
    private Data data;
    private final IReadData readFile = new ReadFile();

    public Generating(IStock stk){
        code = stk.getCode();
        name = stk.getName();
        date = stk.getDate();
        data = stk.get1DayData();
    }
    private void sentence1() {

        List<String> patterns = readFile.readData("Data\\sentences_data\\Sentence1.txt");

        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, name, date, data.open);

        System.out.println(result);
    }

    private void sentence2() {
        /*
        Chốt phiên giao dịch ngày 23/10, VN-Index giảm gần 14 điểm (tương đương 1,45%), còn 939,68 điểm.
         */

        List<String> patterns = readFile.readData("Data\\sentences_data\\Sentence2.txt");

        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, name, date, data.price, data.change);

        System.out.println(result);
    }

    public void generateSentences(){
        System.out.println(code + " " + date + ":");
        sentence1();
        sentence2();
    }

}
