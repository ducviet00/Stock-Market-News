package main.Utils;

import main.Data;
import main.Stock;

public class IncDecSequence {

    private Stock stk;
    private String typeVolume;
    private String typePrice;
    private Data today;
    private Data yesterday;
    private int indexToday = 0;

    public IncDecSequence(Stock stock) {
        stk = stock;
        today = stk.getDailyData(indexToday);
        yesterday = stk.getDailyData(indexToday + 1);
        setType();
    }

    // increase sequence or decrease sequence
    private void setType() {
        double volChange = today.getVol() - yesterday.getVol();
        String check = checkIncreaseOrDecrease(volChange);
        typeVolume = check;

        double priceChange = today.getPrice() - yesterday.getPrice();
        check = checkIncreaseOrDecrease(priceChange);
        typePrice = check;
    }

    private String checkIncreaseOrDecrease(double change) {
        if(change < 0) return "giảm";
        else return "tăng";
    }

    // return number of volume sequence
    public int volumeSequence() {
        int seq = 2;
        String inc, nextInc;
        Data thisDay = today, beforeDay = yesterday;
        double change = thisDay.getVol() - beforeDay.getVol();
        inc = checkIncreaseOrDecrease(change);

        thisDay = beforeDay;
        beforeDay = stk.getDailyData(indexToday+2);

        change = thisDay.getVol() - beforeDay.getVol();
        nextInc = checkIncreaseOrDecrease(change);

        while(nextInc.equals(inc))
        {
            seq++;
            thisDay = beforeDay;
            beforeDay = stk.getDailyData(indexToday + seq);
            change = thisDay.getVol() - beforeDay.getVol();
            nextInc = checkIncreaseOrDecrease(change);
        }


        return seq;
    }

    // return number of price sequence
    public int priceSequence() {
        int seq = 2;
        String inc, nextInc;
        Data thisDay = today, beforeDay = yesterday;
        double change = thisDay.getPrice() - beforeDay.getPrice();
        inc = checkIncreaseOrDecrease(change);

        thisDay = beforeDay;
        beforeDay = stk.getDailyData(indexToday+2);

        change = thisDay.getPrice() - beforeDay.getPrice();
        nextInc = checkIncreaseOrDecrease(change);

        while(nextInc.equals(inc))
        {
            seq++;
            thisDay = beforeDay;
            beforeDay = stk.getDailyData(indexToday + seq);
            change = thisDay.getPrice() - beforeDay.getPrice();
            nextInc = checkIncreaseOrDecrease(change);
        }

        return seq;
    }

    public String getTypeVolume() {
        return typeVolume;
    }
    public String getTypePrice() {
        return typePrice;
    }

}
