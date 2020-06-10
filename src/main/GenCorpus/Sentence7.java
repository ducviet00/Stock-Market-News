package main.GenCorpus;

import main.Stock;
import main.Utils.IncDecSequence;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class Sentence7 extends Sentences{
    public Sentence7(Stock stock) {
        super(stock);
    }

    @Override
    public void genSentence() {

        IncDecSequence ids = new IncDecSequence(stk);
        String tangGiam = ids.getTypeVolume();
        int numberSequence = ids.volumeSequence();
        double value = data.getVol() * 12000;


        List<String> patterns = null;
        if (numberSequence >= 3) {
            patterns = readFile.readData("Data\\sentences_data\\Sentence7.txt");
        }


        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, name, dateStr, tangGiam, numberSequence, data.getVol(), value);
        // {0} -- code, {1} -- name, {2} -- date, {3} -- tang/giam
        // {4} -- number sequence, {5} -- volume, {6} -- value

        System.out.println(result);
    }
}
