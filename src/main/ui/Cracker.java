package ui;

import javax.swing.*;

public class Cracker extends JFrame {

    public Cracker() {
        super("Calorie Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CalorieTrackerPanel tp = new CalorieTrackerPanel();
        tp.init();
        add(tp);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Cracker();
    }
}
