package main.gencorpus;

import main.data.StkData;
import main.data.Stock;
import main.readdata.IReadData;
import main.readdata.ReadFile;
import main.utils.DateUtils;

public abstract class Sentences {
    protected Stock stk;
    protected final String code;
    protected final String name;
    protected final StkData stkData;
    protected final String dateStr;
    protected final Stock thisStk;
    protected final IReadData readFile = new ReadFile();

    public Sentences(Stock stk) {
        this.thisStk = stk;
        this.code = stk.getCode();
        this.name = stk.getName();
        this.stkData = stk.getData();
        this.dateStr = DateUtils.date2String(stkData.tradeDate);
    }

    public String genSentence() {
        return null;
    }
}
