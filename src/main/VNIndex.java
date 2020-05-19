import java.sql.Date;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Random;


public class VNIndex extends Stock {
    public VNIndex(String name, Date date) {
        super(name, date);
    }

    public void sentence1() {
        String code = this.getName();
        ArrayList<Data> open = this.getOpen();
        Date date = this.getDate();
        Random rand = new Random();


        ArrayList<String> patterns = new ArrayList<>();
        patterns.add("{0} mở đầu phiên giao dịch giảm nhẹ 0,17 điểm xuống {2, number} điểm (-0.55%).");
        patterns.add("Mở đầu phiên giao dịch sáng nay ({1}), {0} giảm 6,04 điểm (tương đương 1,87%) xuống {2, number} điểm.");

        int index = rand.nextInt() % patterns.size();
        String pattern = patterns.get(index);
        String result = MessageFormat.format(
                pattern, code, date, open);

        System.out.println(result);
    }

    public static void main(String[] args) {
        VNIndex vni = new VNIndex("VNIndex", new Date(2020, 3, 3));
        vni.collecting();
        ArrayList<Data> a = vni.getPrice();
        System.out.println(a.toString());
    }
}
