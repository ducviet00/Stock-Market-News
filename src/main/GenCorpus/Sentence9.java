package main.GenCorpus;

import main.Data.Stock;
import main.Utils.Utils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Sentence9 extends Sentences {
    public Sentence9(Stock stk) {
        super(stk);
    }

    public String genSentence() {

        Date lastWeek = thisStk.getDailyData(7).tradeDate;
        String dateLastWeek = Utils.date2String(lastWeek);
        String tangGiam;
        double weekChange, weekChangeRatio, weekChangeAverage;

        weekChange = stkData.getPrice() - thisStk.getDailyData(7).getPrice();
        weekChangeRatio = weekChange * 100 / thisStk.getDailyData(7).getPrice();
        weekChangeAverage = weekChange / 7;
        if(weekChange > 0) tangGiam = "tăng";
        else tangGiam = "giảm";

        List<String> patterns = null;
        patterns = readFile.readData("Data\\sentences_data\\Sentence 9\\Sentence9.txt");

        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(pattern, name, code, dateStr, dateLastWeek, tangGiam, weekChange,
                stkData.getPrice(), weekChangeRatio, weekChangeAverage);
        // {0} -- code, {1} -- name, {2} -- date, {3} -- last week date, {4} -- tang giam
        // {5} -- luong tang giam, {6} -- price, {7} -- % tang giam, {8} -- luong tang giam trung binh moi phien

        return result;
    }
}
