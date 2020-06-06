package main.GenCorpus;

import main.Data;
import main.Stock;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class Sentence1 extends Sentences {
    public Sentence1(Stock stock) {
        super(stock);
    }

    @Override
    public void genSentence() {
        /*
        Mở đầu phiên giao dịch sáng nay ({2}), {1} {5} điểm (tương đương {4, number}%) xuống {3, number} điểm.
        */

        int indexToday = 0;
        Data today = thisStk.getDailyData(indexToday);
        Data yesterday = thisStk.getDailyData(indexToday + 1);

        double increase = today.getOpen() - yesterday.getPrice();


        List<String> patterns = null;
        if (increase > 0) {
            patterns = readFile.readData("Data\\sentences_data\\S1_decrease.txt");
        } else patterns = readFile.readData("Data\\sentences_data\\S1_increase.txt");

        double priceChange = Math.abs(increase);
        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, name, dateStr, data.getOpen(), data.getChange(), priceChange);

        System.out.println(result);
    }
}
