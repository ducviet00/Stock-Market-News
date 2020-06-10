package main.GenCorpus;

import main.Utils.IncDecSequence;
import main.Stock;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class Sentence6 extends Sentences{
    public Sentence6(Stock stock) {
        super(stock);
    }

    @Override
    public void genSentence() {

        IncDecSequence ids = new IncDecSequence(stk);
        String tangGiam = ids.getTypePrice(); // price dang tang lien tiep hay giam lien tiep
        int numberSequence = ids.priceSequence(); // so phien lien tiep


        List<String> patterns = null;
        if (numberSequence >= 3) {
            patterns = readFile.readData("Data\\sentences_data\\Sentence6.txt");
        }


        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, name, dateStr, tangGiam, numberSequence, data.getPrice());
        // {0} -- code, {1} -- name, {2} -- date, {3} -- tang/giam
        // {4} -- number sequence, {5} -- price

        System.out.println(result);
    }
}
