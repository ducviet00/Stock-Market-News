import java.sql.Date;

public class Data {
    private String date;
    private double data;

    public Data(double data, String date) {
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
