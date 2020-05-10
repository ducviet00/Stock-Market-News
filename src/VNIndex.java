import java.sql.Date;
import java.util.ArrayList;

public class VNIndex extends Stock {
    public VNIndex(String name, Date date) {
        super(name, date);
    }

    public static void main(String[] args) {
        VNIndex vni = new VNIndex("VNIndex", new Date(2020, 3, 3));
        vni.collecting();
        ArrayList<Data> a = vni.getPrice();
        System.out.println(a.toString());
    }
}
