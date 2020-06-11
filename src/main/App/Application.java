package main.App;

import main.Data.Stock;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static String genCorpus() {

        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("VNIndex", "VNI"));
        stocks.add(new Stock("Ngân hàng Thương mại Cổ phần Đầu tư và Phát triển Việt Nam", "BID"));
        stocks.add(new Stock("Tập đoàn Bảo Việt", "BVH"));
        stocks.add(new Stock("Công ty Cổ phần Xây dựng COTECCONS", "CTD"));
        stocks.add(new Stock("Ngân hàng Thương mại Cổ phần Công Thương Việt Nam", "CTG"));
        stocks.add(new Stock("Ngân hàng Thương mại Cổ phần Xuất Nhập khẩu Việt Nam", "EIB"));
        stocks.add(new Stock("Công ty Cổ phần FPT", "FPT"));
        stocks.add(new Stock("Tổng Công ty Khí Việt Nam - Công ty Cổ phần", "GAS"));
        stocks.add(new Stock("Ngân hàng TMCP Phát triển TP.Hồ Chí Minh", "HDB"));
        stocks.add(new Stock("Công ty Cổ phần Tập đoàn Hòa Phát", "HPG"));
        stocks.add(new Stock("Ngân hàng Thương mại Cổ phần Quân Đội", "MBB"));
        stocks.add(new Stock("Công ty Cổ phần Tập đoàn MaSan", "MSN"));
        stocks.add(new Stock("Công ty Cổ phần Đầu tư Thế Giới Di Động", "MWG"));
        stocks.add(new Stock("Công ty Cổ phần Tập đoàn Đầu tư Địa ốc No Va", "NVL"));
        stocks.add(new Stock("Tập đoàn Xăng dầu Việt Nam", "PLX"));
        stocks.add(new Stock("Công ty Cổ phần Vàng bạc Đá quý Phú Nhuận", "PNJ"));
        stocks.add(new Stock("Tổng Công ty Điện lực Dầu khí Việt Nam - CTCP", "POW"));
        stocks.add(new Stock("Công ty Cổ phần Cơ Điện Lạnh", "REE"));
        stocks.add(new Stock("Công ty Cổ phần Xây dựng FLC FAROS", "ROS"));
        stocks.add(new Stock("Tổng Công ty Cổ phần Bia – Rượu – Nước giải khát Sài Gòn", "SAB"));
        stocks.add(new Stock("Công ty Cổ phần Thành Thành Công - Biên Hòa", "SBT"));
        stocks.add(new Stock("Công ty Cổ phần Chứng khoán SSI", "SSI"));
        stocks.add(new Stock("Ngân hàng Thương mại Cổ phần Sài Gòn Thương Tín", "STB"));
        stocks.add(new Stock("Ngân hàng TMCP Kỹ Thương Việt Nam", "TCB"));
        stocks.add(new Stock("Ngân hàng TMCP Ngoại Thương Việt Nam", "VCB"));
        stocks.add(new Stock("Công ty Cổ phần Vinhomes", "VHM"));
        stocks.add(new Stock("Tập đoàn Vingroup - Công ty Cổ phần", "VIC"));
        stocks.add(new Stock("Công ty Cổ phần Hàng không VietJet", "VJC"));
        stocks.add(new Stock("Công ty Cổ phần Sữa Việt Nam", "VNM"));
        stocks.add(new Stock("Công ty Cổ phần Sữa Việt Nam", "VPB"));
        stocks.add(new Stock("Công ty Cổ phần Vincom Retail", "VRE"));

        int growth = 0;
        int fall = 0;
        for (Stock stock : stocks) {
            if (stock.getCode() == "VNI") continue;
            if (stock.getDailyData(0).getChange() > 0)
                growth++;
            else if (stock.getDailyData(0).getChange() < 0){
                fall ++;
            }
        }
        String date = stocks.get(0).getDailyData(0).getDate();
        String corpus = "<h2> Ngày giao dịch " + date + " trong rổ cổ phiếu VN30 có: <br/></h2>" +
                "   -   " + String.valueOf(growth) + " mã tăng giá. <br/>" +
                "   -   " + String.valueOf(30 - growth - fall) + " mã đứng giá.<br/>" +
                "   -   " + String.valueOf(fall) + " mã giảm giá. <br/>" +
                "<h2>Chi tiết như sau: <br/> </h2>";

        for (Stock stock : stocks) {
            GenReport genReport = new GenReport(stock);
            corpus = corpus.concat(genReport.generateSentences());
            corpus = corpus.concat("<br/>");
        }
        //corpus = corpus.concat("</html>");
        return "<html>" + corpus + "</html>";
    }

    public static void main(String[] args) {
        System.out.println(genCorpus());
    }
}