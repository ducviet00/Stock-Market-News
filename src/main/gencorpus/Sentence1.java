package main.gencorpus;

import main.data.StkData;
import main.data.Stock;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class Sentence1 extends Sentences {
    public Sentence1(Stock stock) {
        super(stock);
    }

    @Override
    public String genSentence() {
        /*
        Mở đầu phiên giao dịch sáng nay ({2}), {1} {5} điểm (tương đương {4, number}%) xuống {3, number} điểm.
        */

        int indexToday = 0;
        StkData today = thisStk.getDailyData(indexToday);
        StkData yesterday = thisStk.getDailyData(indexToday + 1);

        double increase = today.getOpen() - yesterday.getPrice();


        List<String> patterns = null;
        if (increase < 0) {
            patterns = readFile.readData("Data\\sentences_data\\Sentence 1\\S1_decrease.txt");
        } else if (increase > 0) {
            patterns = readFile.readData("Data\\sentences_data\\Sentence 1\\S1_increase.txt");
        } else {
            patterns = readFile.readData("Data\\sentences_data\\Sentence 1\\S1_equal.txt");
        }
        double priceChange = Math.abs(increase);
        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, name, code, dateStr, stkData.getOpen(), stkData.getChange(), priceChange);

        return result;
    }
}
