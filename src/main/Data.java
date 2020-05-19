package main;

import java.sql.Date;

public class Data {
    double price;
    double open;
    double low;
    double high;
    double vol;
    double change;

    public Data(double price, double open, double low, double high, double vol, double change) {
        this.price = price;
        this.open = open;
        this.low = low;
        this.high = high;
        this.vol = vol;
        this.change = change;
    }

    @Override
    public String toString() {
        return "Data {" +
                ", price=" + price +
                ", open=" + open +
                ", low=" + low +
                ", high=" + high +
                ", vol=" + vol +
                ", change=" + change +
                '}';
    }


}
