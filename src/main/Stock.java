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

    public String increase() {
        int indexToday = 0;
        Data today = stkData.get(indexToday);
        Data yesterday = stkData.get(indexToday + 1);

        double increment = today.open - yesterday.price;
        double absIcm = Math.abs(increment);

        if (increment < 0) {
            if (absIcm < 1) {
                return "giảm nhẹ " + String.valueOf(absIcm);
            } else if (absIcm > 50) {
                return "giảm mạnh " + String.valueOf(absIcm);
            } else {
                return "giảm " + String.valueOf(absIcm);
            }
        } else {
            if (absIcm < 1) {
                return "tăng nhẹ " + String.valueOf(absIcm);
            } else if (absIcm > 50) {
                return "tăng mạnh " + String.valueOf(absIcm);
            } else {
                return "tăng " + String.valueOf(absIcm);
            }
        }

    }


    public void setDc(ICollector dc) {
        this.dc = dc;
    }

}
