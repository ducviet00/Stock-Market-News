package main.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StkData {
    public Date tradeDate;
    private final double price;
    private final double open;
    private final double low;
    private final double high;
    private final double vol;
    private final double change;

    public StkData(Date tradeDate, double price, double open, double high, double low, double vol, double change) {
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
        return "tradeDate = " + getDate() +
                ", price=" + price +
                ", open=" + open +
                ", low=" + low +
                ", high=" + high +
                ", vol=" + vol +
                ", change=" + change;

    }

    public String getDate() {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(tradeDate);
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
