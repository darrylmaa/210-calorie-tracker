package ui;

import model.FoodItem;
import model.Tracker;
import model.exceptions.NegativeNumberException;
import persistence.ReadFile;
import persistence.WriteFile;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.List;

public class CalorieTrackerPanel extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private static final String ACCOUNTS_FILE = "./data/taccounts.txt";
    private Tracker tracker;
    ArrayList<FoodItem> myList = new ArrayList<>();
    JButton jb1 = new JButton("Current calorie count");
    JButton jb2 = new JButton("Add new consumed food");
    JButton jb3 = new JButton("Print list of foods consumed");
    JButton jb4 = new JButton("Save");
    JButton jb5 = new JButton("Back");
    JButton jb6 = new JButton("Submit");
    JButton jb7 = new JButton("Wholesome");
    JButton jb8 = new JButton("Load");
    JTextField jtFoodItem = new JTextField("");
    JTextField jtCals = new JTextField("");
    JTextField jtServs = new JTextField("");
    JLabel jl1 = new JLabel(new ImageIcon(".\\data\\wholesome.jpg"));
    JLabel jl2 = new JLabel("Food item");
    JLabel jl3 = new JLabel("Calories (only integers)");
    JLabel jl4 = new JLabel("Servings (only integers)");
    JLabel jl5 = new JLabel("");
    JLabel jl6 = new JLabel("");

    public CalorieTrackerPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(0, 2));
        setFonts();
        menu();

        //current calorie count
        jb1.addActionListener(e -> currentCount());

        //add consumed food
        jb2.addActionListener(e -> consumedFood());

        //print list of food
        jb3.addActionListener(e -> jl5.setText("<html>" + tracker.consFood(myList) + "</html>"));

        //save
        jb4.addActionListener(e -> saveAccount());

        //return
        jb5.addActionListener(e -> menu());

        //submit
        jb6.addActionListener(e -> submit());

        //wholesome
        jb7.addActionListener(e -> wholesomePicture());

        //load
        jb8.addActionListener(e -> loadAccount());
    }

    // MODIFIES : this
    // EFFECTS : initializes tracker
    public void init() {
        tracker = new Tracker(10000);
    }

    // EFFECTS: saves state of account to ACCOUNTS_FILE
    public void saveAccount() {
        try {
            WriteFile writer = new WriteFile(new File(ACCOUNTS_FILE));
            writer.write(tracker);
            writer.close();
            jl5.setText("Accounts saved to file " + ACCOUNTS_FILE);
        } catch (FileNotFoundException e) {
            jl5.setText("Unable to save accounts to " + ACCOUNTS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    // EFFECTS: loads state of account
    public void loadAccount() {
        try {
            List<Tracker> trackers = ReadFile.readTracker(new File(ACCOUNTS_FILE));
            tracker = trackers.get(0);
            jl5.setText("Account successfully loaded!");
        } catch (IOException e) {
            init();
            jl5.setText("Unable to load account.");
        }
    }

    // EFFECTS: Adds new food from add food menu entries
    public void openNewFoodDialogue(String food, int calorie, int serving) throws NegativeNumberException {
        tracker.addFood(food, calorie, serving, myList);
        tracker.getEvenDefSur();
    }

    //current calorie count
    private void currentCount() {
        jl5.setText(tracker.getEvenDefSur());
        repaint();
        revalidate();
    }

    //add consumed food
    private void consumedFood() {
        removeAll();
        setLayout(new GridLayout(0, 2));
        add(jl2);
        add(jtFoodItem);
        add(jl3);
        add(jtCals);
        add(jl4);
        add(jtServs);
        add(jb5);
        add(jb6);
        add(jl6);
        jl6.setText("");
        repaint();
        revalidate();
    }

    //submit
    private void submit() {
        if (!(jtFoodItem.getText().equals(""))) {
            String name = jtFoodItem.getText();
            try {
                int cals = Integer.parseInt(jtCals.getText());
                int servs = Integer.parseInt(jtServs.getText());
                openNewFoodDialogue(name, cals, servs);
                jtFoodItem.setText("");
                jtCals.setText("");
                jtServs.setText("");
                menu();
            } catch (NumberFormatException | NegativeNumberException e) {
                jl6.setText("<html> Please review your entry </html>");
            }
        } else {
            jl6.setText("<html> Please review your entry </html>");
        }
    }

    //wholesome lad
    private void wholesomePicture() {
        removeAll();
        add(jl1);
        add(jb5);
        repaint();
        revalidate();
    }

    //menu
    private void menu() {
        removeAll();
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb7);
        add(jb8);
        add(jl5);
        revalidate();
        repaint();
    }

    //fonts
    private void setFonts() {
        jl2.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        jl3.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        jl4.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        jl5.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        jl6.setFont(new Font("Comic Sans MS", Font.PLAIN, 75));
        jb1.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        jb2.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        jb3.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        jb4.setFont(new Font("Comic Sans MS", Font.PLAIN, 150));
        jb5.setFont(new Font("Comic Sans MS", Font.PLAIN, 150));
        jb6.setFont(new Font("Comic Sans MS", Font.PLAIN, 100));
        jb7.setFont(new Font("Comic Sans MS", Font.PLAIN, 75));
        jb8.setFont(new Font("Comic Sans MS", Font.PLAIN, 150));
        jtFoodItem.setFont(new Font("Comic Sans MS", Font.PLAIN, 75));
        jtCals.setFont(new Font("Comic Sans MS", Font.PLAIN, 100));
        jtServs.setFont(new Font("Comic Sans MS", Font.PLAIN, 100));
    }

}

