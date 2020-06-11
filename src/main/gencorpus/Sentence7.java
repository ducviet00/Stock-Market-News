package main.gencorpus;

import main.data.StkData;
import main.data.Stock;
import main.utils.TestIncDecSequence;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sentence7 extends Sentences {
    public Sentence7(Stock stock) {
        super(stock);
    }

    @Override
    public String genSentence() {

        List<StkData> list = thisStk.getStkData();
        ArrayList<Double> volList = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            Double volume = list.get(i).getVol();
            volList.add(volume);
        }

        TestIncDecSequence test = new TestIncDecSequence(volList);
        String tangGiam;
        String giamTang;
        double value;
        int numberSequence;

        // xác định giá trị của các biến tangGiam, giamTang, value, numberSequence
        tangGiam = test.getType();
        if (tangGiam.equals("giảm"))
            giamTang = "tăng";
        else
            giamTang = "giảm";
        value = stkData.getVol() * 12000;
        numberSequence = test.countNumSequence();

        List<String> patterns = null;
        if (numberSequence >= 2) {
            patterns = readFile.readData("Data\\sentences_data\\Sentence 7\\Sentence7.txt");
        } else
            patterns = readFile.readData("Data\\sentences_data\\Sentence 7\\Sentence7_non.txt");

        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(pattern, name, code, dateStr, tangGiam, numberSequence, stkData.getVol(),
                value, giamTang);
        // {0} -- code, {1} -- name, {2} -- date, {3} -- tang/giam
        // {4} -- number sequence, {5} -- volume, {6} -- value, {7} -- trái với {3}

        return result;
    }
}
