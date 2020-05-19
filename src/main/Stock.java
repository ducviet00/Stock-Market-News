package main;

import DBquery.DataCollection;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Map;


public abstract class Stock {
    private final String username = "sa";
    private final String password = "1";
    private DataCollection dc = new DataCollection("OOP", username, password);
    private final String name;
    private final String code;
    private final String date;
    private Map<String, Data> chartrtis;

    public Stock(String name, String code, String date) {
        this.code = code;
        this.name = name;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setDc(DataCollection dc) {
        this.dc = dc;
    }

    public Data getData(String date) {
        return  chartrtis.get(date);
    }

    public void collecting() {
        this.chartrtis = dc.collectData(name);
        dc.closeConnection();
    }
}
