package main.GenCorpus;

import main.Data.StkData;
import main.Data.Stock;
import main.Utils.TestIncDecSequence;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Sentence6 extends Sentences{
    public Sentence6(Stock stock) {
        super(stock);
    }

    @Override
    public String genSentence() {

        List<StkData> list = thisStk.getStkData();
        ArrayList<Double> priceList = new ArrayList<Double>();
        for(int i=0; i<=30; i++) {
            Double price = list.get(i).getPrice();
            priceList.add(price);
        }

        TestIncDecSequence test = new TestIncDecSequence(priceList);

        String tangGiam; // tăng liên tiếp hay giảm liên tiếp
        String giamTang; // ngược lại với tangGiam
        int numberSequence; // số lượng phiên liên tiếp

        // xác định giá trị của các biến tangGiam, giamTang, numberSequence
        tangGiam = test.getType();
        if (tangGiam.equals("giảm"))
            giamTang = "tăng";
        else
            giamTang = "giảm";
        numberSequence = test.countNumSequence();

        List<String> patterns = null;
        if (numberSequence >= 2) {
            patterns = readFile.readData("Data\\sentences_data\\Sentence 6\\Sentence6.txt");
        } else patterns = readFile.readData("Data\\sentences_data\\Sentence 6\\Sentence6_non.txt");


        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, name, code, dateStr, tangGiam, numberSequence, stkData.getPrice(), giamTang);
        // {0} -- code, {1} -- name, {2} -- date, {3} -- tang/giam
        // {4} -- number sequence, {5} -- price, {6} -- trái với {3}

        return result;
    }

}
