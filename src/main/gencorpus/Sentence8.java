package main.gencorpus;

import main.data.Stock;
import main.utils.DateUtils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Sentence8 extends Sentences {

    public Sentence8(Stock stock) {
        super(stock);
    }

    @Override
    public String genSentence() {

        int increaseCount = 0, decreaseCount = 0;
        for (int i = 0; i < 7; i++) {
            double x = thisStk.getDailyData(i).getPrice() - thisStk.getDailyData(i + 1).getPrice();
            if (x > 0) decreaseCount++;
            if (x < 0) increaseCount++;
        }

        Date lastWeek = thisStk.getDailyData(7).tradeDate;
        String dateLastWeek = DateUtils.date2String(lastWeek);
        String tangGiam;
        double change;
        double changeNum;

        change = stkData.getPrice() - thisStk.getDailyData(7).getPrice();
        changeNum = Math.abs(change);
        if (change > 0) tangGiam = "tăng";
        else tangGiam = "giảm";


        List<String> patterns = null;
        patterns = readFile.readData("Data\\sentences_data\\Sentence 8\\Sentence8.txt");

        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, name, code, dateStr, dateLastWeek, increaseCount, decreaseCount, tangGiam, changeNum);
        // {0} -- code, {1} -- name, {2} -- this date, {3} -- last week date, {4} -- số phiên tăng
        // {5} -- số phiên giảm, {6} -- tăng hay giảm, {7} -- lượng tăng/giảm

        return result;
    }

}
