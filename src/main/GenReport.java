package main;

import main.GenCorpus.*;

public class GenReport {
    Stock stk;
    public GenReport(Stock stock) {
        this.stk = stock;
    }
    /*
    private void sentence2() {
        Chốt phiên giao dịch ngày 23/10, VN-Index giảm gần 14 điểm (tương đương 1,45%), còn 939,68 điểm.


        double dailyChange = thisStk.dailyChange();

        List<String> patterns = readFile.readData("Data\\sentences_data\\Sentence2.txt");

        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, name, dateStr, data.price, data.change, dailyChange);

        System.out.println(result);
    }
*/
    public void generateSentences() {
        System.out.println("---------------------------:");
        Sentences sentence1 = new Sentence1(this.stk);
        Sentences sentence2 = new Sentence2(this.stk);
        Sentences sentence3 = new Sentence3(this.stk);
        Sentences sentence4 = new Sentence4(this.stk);
        Sentences sentence5 = new Sentence5(this.stk);
        //Sentences sentence6 = new Sentence6(this.stk);
        sentence1.genSentence();
        sentence2.genSentence();
        sentence3.genSentence();
        sentence4.genSentence();
        sentence5.genSentence();
        //sentence6.genSentence();
    }

}
