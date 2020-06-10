package main.GenCorpus;

import main.Data;
import main.Stock;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class Sentence2 extends Sentences {
    public Sentence2(Stock stk) {
        super(stk);
    }

    /*
     * Chốt phiên giao dịch ngày 23/10, VN-Index giảm gần 14 điểm (tương đương
     * 1,45%), còn 939,68 điểm.
     */
    @Override
    public void genSentence() {
        int indexToday = 0;

        Data today = thisStk.getDailyData(indexToday);
        Data yesterday = thisStk.getDailyData(indexToday + 1);

        double closeChange = today.getPrice() - today.getOpen();
        double changePercent = closeChange / today.getPrice() * 100;
        String closeChangeStr = String.valueOf(closeChange);

        String str = null;
        List<String> patterns = null;
        if (closeChange <= -5) {
            str = "giảm mạnh " + closeChangeStr;
            patterns = readFile.readData("Data\\sentences_data\\Sentence 2\\S2_decrease.txt");
        } else if (closeChange <= 0) {
            str = "giảm nhẹ " + closeChangeStr;
            patterns = readFile.readData("Data\\sentences_data\\Sentence 2\\S2_decrease.txt");
        } else if (closeChange <= 5) {
            str = "tăng nhẹ " + closeChangeStr;
            patterns = readFile.readData("Data\\sentences_data\\Sentence 2\\S2_increase.txt");
        } else {
            str = "tăng mạnh " + closeChangeStr;
            patterns = readFile.readData("Data\\sentences_data\\Sentence 2\\S2_increase.txt");
        }

        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, name, dateStr, data.getPrice(), changePercent, str);

        System.out.println(result);
    }
}