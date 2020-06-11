package main.app;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppGUI {
    private JPanel rootPanel;
    private JButton Start;
    private JTextPane textPane;


    public AppGUI() {
        Start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                start(e);
            }
        });
    }

    private void start(java.awt.event.MouseEvent evt) {
        textPane.setContentType("text/html");
        textPane.setText(Application.genCorpus());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Stock Market News 0.1.1");
        frame.setContentPane(new AppGUI().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 600);
    }
}
