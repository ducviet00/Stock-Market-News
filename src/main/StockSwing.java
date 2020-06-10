package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class StockSwing {

    private JButton button1;
    private JFrame mainFrame;

    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel contentlabel;

    public StockSwing() {
        creatFrame();
    }

    public void creatFrame() {
        mainFrame = new JFrame("Stock Market News");
        mainFrame.setSize(800,500);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(500,350);

        contentlabel = new JLabel("Chào mừng bạn đến với chương trình.", JLabel.CENTER);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    private void showJPanel(){

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(new FlowLayout());
        panel.add(contentlabel);

        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }

    public void showButton(){
        JButton button1 = new JButton("Click");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stock stockVN = new Stock("VNIndex", "VNI");
                Stock stockHN = new Stock("HNXIndex","HNX");

                new GenReport(stockVN).generateSentences();
                new GenReport(stockHN).generateSentences();
                contentlabel.setText("aaaa");
            }
        });

        controlPanel.add(button1);
        mainFrame.setVisible(true);

    }
    public void updateTextPane(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Stock stockVN = new Stock("VNIndex", "VNI");
                Stock stockHN = new Stock("HNXIndex","HNX");

                new GenReport(stockVN).generateSentences();
                new GenReport(stockHN).generateSentences();
            }
        });
    }
    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(final int b) throws IOException {
                updateTextPane(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextPane(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }


    public static void main(String[] args) {
        StockSwing stockSwing = new StockSwing();
        stockSwing.showJPanel();
        stockSwing.showButton();
    }


}
