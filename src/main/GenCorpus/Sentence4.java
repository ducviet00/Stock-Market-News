package main.GenCorpus;

import main.Data.StkData;
import main.Data.Stock;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class Sentence4 extends Sentences {
    public Sentence4(Stock stk) {
        super(stk);
    }

    @Override
    public String genSentence() {
        int indexToday = 0;

        StkData today = thisStk.getDailyData(indexToday);
        StkData yesterday = thisStk.getDailyData(indexToday + 1);

        double vol = today.getVol();
        //double changePercent = closeChange / today.getPrice() * 100;
        double val = stkData.getVol() * 12000;
        double volChange = today.getVol() - yesterday.getVol();

        List<String> patterns = null;

        if (vol < 10000) {
            patterns = readFile.readData("Data\\sentences_data\\Sentence 4\\S4_low.txt");
        } else if (vol < 100000) {
            patterns = readFile.readData("Data\\sentences_data\\Sentence 4\\S4_all.txt");
        } else {
            patterns = readFile.readData("Data\\sentences_data\\Sentence 4\\S4_high.txt");
        }

        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);

        String result = MessageFormat.format(
                pattern, name, code, dateStr, stkData.getPrice(), vol, val, volChange);

        // {1} -- name ; {2} -- date; {3} -- price; {4} -- vol; {5} -- value. {6} -- volChange;
        // {5} -- times
        return result;
    }
}


// trong Stock có thêm phương thức tính GetVolChange = today.vol -
// yesterday.vol --> volChange = thisStk.getVolChange()
      /*  double volChange = data.vol - data.vol;
        double val = data.vol * 12000;
        double times = data.vol / (data.vol + volChange);

        String volume = ConvertNumber.toVietnamese(data.vol);
        String value = ConvertNumber.toVietnamese(val);
        times = ConvertNumber.roundedNum(times);

        // {0} -- name ; {1} -- date; {2} -- price; {3} -- vol; {4} -- value;
        // {5} -- times
        Object[] objArray = { name, dateStr, data.price, volume, value, times };

        genSentenceInFile("Data\\sentences_data\\Sentence4_all.txt", objArray);

        if (volChange < 0)
            genSentenceInFile("Data\\sentences_data\\Sentence4_decrease.txt", objArray);

        if (volChange > 0)
            genSentenceInFile("Data\\sentences_data\\Sentence4_increase.txt", objArray);

        if (data.vol < 10000)
            genSentenceInFile("Data\\sentences_data\\Sentence4_low.txt", objArray);

        if (data.vol > 100000)
            genSentenceInFile("Data\\sentences_data\\Sentence4_high.txt", objArray);
    }
}
*/