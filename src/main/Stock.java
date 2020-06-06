package main;

import main.CollectData.*;

import java.util.List;


public class Stock {
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

        return today.getOpen() - yesterday.getPrice();
    }

    public double dailyChange() {
        Data today = stkData.get(0);

        return today.getOpen() - today.getPrice();
    }
    public Data getDailyData (int index) {
        return stkData.get(index);
    }

    public void setDc(ICollector dc) {
        this.dc = dc;
    }

}
