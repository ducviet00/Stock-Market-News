package main.GenCorpus;

import main.Data.StkData;
import main.Data.Stock;
import main.ReadData.IReadData;
import main.ReadData.ReadFile;
import main.Utils.Utils;

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
        this.dateStr = Utils.date2String(stkData.tradeDate);
    }

    public String genSentence() {
        return null;
    }
}
