package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Application {
/*    public static Date str2Date(String str) {

        Scanner scanner = new Scanner(System.in);
        String strDate = scanner.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }*/

    public static void main(String[] args) throws ParseException {

        Stock vni = new Stock("VNIndex", "VNI");
        Stock hnx = new Stock("HNXIndex", "HNX");

        List<Stock> stocks = new ArrayList<>();
        stocks.add(vni);
        stocks.add(hnx);

        for (Stock stock : stocks) {
            GenReport genReport = new GenReport(stock);
            genReport.generateSentences();
        }
    }
}
