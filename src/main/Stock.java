package main;

import DBquery.DataCollection;


import java.util.Map;


public class Stock implements IStock {
    private final String username = "sa";
    private final String password = "1";
    private DataCollection dc = new DataCollection("OOP", username, password);
    private final String name;
    private final String code;
    private final String date;
    private Map<String, Data> stkData;

    public Stock(String name, String code, String date) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.stkData = dc.collectData(name);
        dc.closeConnection();
    }
    @Override
    public String getCode() {
        return code;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDate() {
        return date;
    }

    public void setDc(DataCollection dc) {
        this.dc = dc;
    }

    public Map<String, Data> getStkData() {
        return stkData;
    }
    @Override
    public Data get1DayData() {
        return stkData.get(date);
    }
}
