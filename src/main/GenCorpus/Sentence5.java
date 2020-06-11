package main.GenCorpus;

import main.Data.StkData;
import main.Data.Stock;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class Sentence5 extends Sentences {
    public Sentence5(Stock stock) {
        super(stock);
    }

    //Câu 5: Trong vòng ? ngày qua, chỉ số ? đạt mức thấp nhất tại ?, và đạt ngưỡng cao nhất tại ?.
    // {0} - name; {1} - maxPrice; {2} - minPrice; {3} - chosenPeriod; với chosenPeriod là số ngày tính lùi về tính từ hiện tại

    public String genSentence() {
        int indexToday = 0;
        int chosenPeriod = 0;
        StkData today = thisStk.getDailyData(indexToday);
        double minStat = today.getLow();
        double maxStat = today.getHigh();

        for (int i1 = 0; i1 < chosenPeriod; i1++) {
            today = thisStk.getDailyData(i1);
            if (minStat > today.getLow()) {
                minStat = today.getLow();
            }
            if (maxStat < today.getHigh()) {
                maxStat = today.getHigh();
            }
        }

        List<String> patterns = null;
        if (minStat == maxStat) {
            patterns = readFile.readData("Data\\sentences_data\\Sentence 5\\sentence5ex.txt");
        } else patterns = readFile.readData("Data\\sentences_data\\Sentence 5\\sentence5.txt");
        if (chosenPeriod == 0)
            patterns = readFile.readData("Data\\sentences_data\\Sentence 5\\sentence5exx.txt");

        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, maxStat, minStat, chosenPeriod);

        return result;
    }
}