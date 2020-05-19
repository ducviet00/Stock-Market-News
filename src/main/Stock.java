import java.util.ArrayList;
import java.sql.Date;



public abstract class Stock {
    private final String username = "sa";
    private final String password = "1";
    private DataCollection dc = new DataCollection("OOP", username, password);
    private String name;
    private Date date;
    private ArrayList<Data> price = new ArrayList<>();
    private ArrayList<Data> open = new ArrayList<>();
    private ArrayList<Data> low = new ArrayList<>();
    private ArrayList<Data> high = new ArrayList<>();
    private ArrayList<Data> vol = new ArrayList<>();
    private ArrayList<Data> change = new ArrayList<>();

    public Stock(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Data> getPrice() {
        return price;
    }

    public ArrayList<Data> getOpen() {
        return open;
    }

    public ArrayList<Data> getLow() {
        return low;
    }

    public ArrayList<Data> getHigh() {
        return high;
    }

    public ArrayList<Data> getVol() {
        return vol;
    }

    public ArrayList<Data> getChange() {
        return change;
    }

    public void setDc(DataCollection dc) {
        this.dc = dc;
    }

    public void collecting() {
        this.price = dc.collectData("Price", name);
        this.open = dc.collectData("OpenPrice", name);
        this.low = dc.collectData("Low", name);
        this.high = dc.collectData("High", name);
        dc.closeConnection();
    }
}
