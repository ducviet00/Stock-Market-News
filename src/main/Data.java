package main;

import java.util.Date;

public class Data {
    Date tradeDate;
    double price;
    double open;
    double low;
    double high;
    double vol;
    double change;

    public Data(Date tradeDate, double price, double open, double high, double low, double vol, double change) {
        this.tradeDate = tradeDate;
        this.price = price;
        this.open = open;
        this.high = high;
        this.low = low;
        this.vol = vol;
        this.change = change;
    }

    @Override
    public String toString() {
        return "Data{" +
                "tradeDate=" + tradeDate +
                ", price=" + price +
                ", open=" + open +
                ", low=" + low +
                ", high=" + high +
                ", vol=" + vol +
                ", change=" + change +
                '}';
    }
}
