import java.sql.Date;

public class Data {
    public double data;
    public Date date;

    public Data(double data, Date date) {
        this.data = data;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data{" +
                "date=" + date +
                " - " + data +
                "}\n";
    }
}
