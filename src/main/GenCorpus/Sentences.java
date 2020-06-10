package main.GenCorpus;

import main.Data;
import main.ReadData.IReadData;
import main.ReadData.ReadFile;
import main.Stock;
import main.Utils.Utils;

public abstract class Sentences {
    protected Stock stk;
    protected final String code;
    protected final String name;
    protected final Data data;
    protected final String dateStr;
    protected final Stock thisStk;
    protected final IReadData readFile = new ReadFile();

    public Sentences(Stock stk) {
        this.thisStk = stk;
        this.code = stk.getCode();
        this.name = stk.getName();
        this.data = stk.getData();
        this.dateStr = Utils.date2String(data.tradeDate);
    }

    public void genSentence() {
    }
}
