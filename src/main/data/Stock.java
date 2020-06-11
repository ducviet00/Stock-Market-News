package main.data;

import main.collectdata.CollectCSV;
import main.collectdata.ICollector;

import java.util.List;


public class Stock {
    private ICollector dc = new CollectCSV();
    private final String name;
    private final String code;
    private List<StkData> stkData;

    public Stock(String name, String code) {
        this.code = code;
        this.name = name;
        this.stkData = dc.collectData(code);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<StkData> getStkData() {
        return stkData;
    }

    public StkData getData() {
        return stkData.get(0);
    }

    public StkData getDailyData(int index) {
        return stkData.get(index);
    }

    public void setDc(ICollector dc) {
        this.dc = dc;
    }

    @Override
    public String toString() {
        return name + ": " +
                getDailyData(0).getDate();
    }
}
