package main.GenCorpus;

import main.Data;
import main.Stock;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class Sentence3 extends Sentences {
    public Sentence3(Stock stock) {
        super(stock);
    }

    @Override
    public void genSentence() {


        int indexToday = 0;
        Data today = thisStk.getDailyData(indexToday);
        Data yesterday = thisStk.getDailyData(indexToday + 1);

        double increase = (today.getVol() - yesterday.getVol())/yesterday.getVol()*100;


        List<String> patterns = null;
        if (increase > 0) {
            patterns = readFile.readData("Data\\sentences_data\\S3_increase.txt");
        } else patterns = readFile.readData("Data\\sentences_data\\S3_decrease.txt");

        double volChange = Math.abs(increase);
        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, name, dateStr, data.getVol(), data.getChange(), volChange);

        System.out.println(result);
    }
}
