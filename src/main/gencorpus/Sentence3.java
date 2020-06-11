package main.gencorpus;

import main.data.StkData;
import main.data.Stock;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class Sentence3 extends Sentences {
    public Sentence3(Stock stock) {
        super(stock);
    }

    @Override
    public String genSentence() {


        int indexToday = 0;
        StkData today = thisStk.getDailyData(indexToday);
        StkData yesterday = thisStk.getDailyData(indexToday + 1);

        double increase = (today.getVol() - yesterday.getVol()) / yesterday.getVol() * 100;


        List<String> patterns = null;
        if (increase > 0) {
            patterns = readFile.readData("Data\\sentences_data\\Sentence 3\\S3_increase.txt");
        } else patterns = readFile.readData("Data\\sentences_data\\Sentence 3\\S3_decrease.txt");

        double volChange = Math.abs(increase);
        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, name, code, dateStr, stkData.getVol(), stkData.getChange(), volChange);

        return result;
    }
}
