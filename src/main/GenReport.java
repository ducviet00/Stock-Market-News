package main;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

public class GenReport {
    private final String code;
    private final String name;
    private final Data data;
    private final String dateStr;
    private final Stock thisStk;
    private final IReadData readFile = new ReadFile();

    public GenReport(Stock stk) {
        this.thisStk = stk;
        this.code = stk.getCode();
        this.name = stk.getName();
        this.data = stk.getData();
        this.dateStr = Utils.date2String(data.tradeDate);

    }

    private void sentence1() {
    /*
    Mở đầu phiên giao dịch sáng nay ({2}), {1} {5} điểm (tương đương {4, number}%) xuống {3, number} điểm.
     */
        double increase = thisStk.d2Change();
        List<String> patterns = null;
        if(increase > 0){
            patterns = readFile.readData("Data\\sentences_data\\Sentence1_decrease.txt");
        } else patterns = readFile.readData("Data\\sentences_data\\Sentence1_increase.txt");

        double priceChange = Math.abs(increase);
        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, name, dateStr, data.open, data.change, priceChange);

        System.out.println(result);
    }

    private void sentence2() {
        /*
        Chốt phiên giao dịch ngày 23/10, VN-Index giảm gần 14 điểm (tương đương 1,45%), còn 939,68 điểm.
         */
        double dailyChange = thisStk.dailyChange();

        List<String> patterns = readFile.readData("Data\\sentences_data\\Sentence2.txt");

        Random rand = new Random();
        int index = rand.nextInt(patterns.size());

        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, name, dateStr, data.price, data.change, dailyChange);

        System.out.println(result);
    }

    public void generateSentences() {
        System.out.println(code + " " + dateStr + ":");
        sentence1();
        sentence2();
    }

}
