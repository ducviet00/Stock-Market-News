package main;

public class Application {
    public static void main(String[] args) {
        IStock vni = new Stock("VNIndex", "VNI", "2020-04-21");
        IStock hnx = new Stock("HNXIndex", "HNX","2020-04-21");
        vni.get1DayData();
        Generating gen = new Generating(vni);
        gen.generateSentences();
        gen = new Generating(hnx);
        gen.generateSentences();
    }
}
