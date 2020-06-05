package main;

import main.CollectData.*;

import java.util.List;


public class Stock {
    private final String username = "sa";
    private final String password = "1";
    private ICollector dc = new CollectCSV();
    private final String name;
    private final String code;
    private List<Data> stkData;

    public Stock(String name, String code) {
        this.code = code;
        this.name = name;
        this.stkData = dc.collectData(name);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Data> getStkData() {
        return stkData;
    }

    public Data getData() {
        return stkData.get(0);
    }

    public double d2Change() {
        int indexToday = 0;
        Data today = stkData.get(indexToday);
        Data yesterday = stkData.get(indexToday + 1);

        return today.open - yesterday.price;
    }

    public double dailyChange() {
        Data today = stkData.get(0);

        return today.open - today.price;
    }

    public void setDc(ICollector dc) {
        this.dc = dc;
    }

}
