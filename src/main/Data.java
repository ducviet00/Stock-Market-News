package main;

import java.util.Date;

public class Data {
    public Date tradeDate;
    private final double price;
    private final double open;
    private final double low;
    private final double high;
    private final double vol;
    private final double change;

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

    public double getPrice() {
        return price;
    }

    public double getOpen() {
        return open;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }

    public double getVol() {
        return vol;
    }

    public double getChange() {
        return change;
    }
}
