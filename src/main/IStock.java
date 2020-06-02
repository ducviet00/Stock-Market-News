package main;

import java.util.Date;
import java.util.Map;

public interface IStock {
    public String getCode();
    public String getName();
    public Date getDate();
    public Map<Date, Data> getStkData();
    public String increase ();
    public Data getData();

}
