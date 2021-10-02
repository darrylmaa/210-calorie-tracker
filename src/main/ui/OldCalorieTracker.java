//package ui;
//
//
//import jdk.internal.util.xml.impl.Input;
//import model.FoodItem;
//import model.Tracker;
//import persistence.ReadFile;
//import persistence.WriteFile;
//
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.List;
//import java.util.Scanner;
//
//

//public class OldCalorieTracker {}

//    private Scanner input;
//    private Tracker calTracker;
//    private static final String ACCOUNTS_FILE = "./data/taccounts.txt";
//    ArrayList<FoodItem> myList = new ArrayList<>();
//
//    boolean stop = true;
//
//    // source: https://github.students.cs.ubc.ca/CPSC210/TellerApp/blob/master/src/main/ca/ubc/cpsc210/bank/ui/TellerApp.java
//    // EFFECTS: runs the calorie tracker
//    public CalorieTracker() {
//        runTracker();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads accounts from ACCOUNTS_FILE, if that file exists;
//    // otherwise initializes accounts with default values
//    public void loadAccounts() {
//        try {
//            List<Tracker> trackers = ReadFile.readTracker(new File(ACCOUNTS_FILE));
//            calTracker = trackers.get(0);
//        } catch (IOException e) {
//            init();
//        }
//    }
//
//    // EFFECTS: saves state of account to ACCOUNTS_FILE
//    public void saveAccounts() {
//        try {
//            WriteFile writer = new WriteFile(new File(ACCOUNTS_FILE));
//            writer.write(calTracker);
//            writer.close();
//            System.out.println("Accounts saved to file " + ACCOUNTS_FILE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to save accounts to " + ACCOUNTS_FILE);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            // this is due to a programming error
//        }
//    }
//
//    // MODIFIES : this
//    // EFFECTS : initializes tracker
//    public void init() {
//        calTracker = new Tracker(10000);
//
//    }
//
//    // EFFECTS: begins the application
//    public void runTracker() {
//
//        String direction = null;
//        input = new Scanner(System.in);
//
//        loadAccounts();
//
//        while (stop) {
//            display();
//            direction = input.next();
//            direction = direction.toLowerCase();
//
//            if (direction.equals("q")) {
//                stop = false;
//            } else {
//                nextDirection(direction);
//            }
//        }
//
//        System.out.println("Farewell");
//    }
//
////    // MODIFIES: this
////    // EFFECTS: processes and provides next step depending on choice
////    public void nextDirection(String direction) {
////
////        if (direction.equals("c")) {
////            printCal();
////            // else if (direction.equals("settings")) {
////            // openSettings();
////        } else if (direction.equals("a")) {
////            openNewFoodDialogue();
////        } else if (direction.equals("q")) {
////            quitProgram();
////        } else if (direction.equals("s")) {
////            saveAccounts();
////        } else if (direction.equals("d")) {
////            printConsFood();
////        } else {
////            System.out.println("Invalid Choice");
////        }
////
////    }
////
////    // EFFECTS: PRODUCES BEGINNING DISPLAY
////    public void display() {
////        System.out.println("c -> Current calorie count");
////        System.out.println("a -> Add new consumed food");
////        System.out.println("d -> Print the list of foods consumed so far");
////        System.out.println("s -> Save calorie count to file");
////        System.out.println("q -> Quit");
////    }
//
//
//    // REQUIRES: AT LEAST 1 CHARACTER
//    // MODIFIES: this
//    // EFFECTS: OPENS Food Dialogue
////    private void openNewFoodDialogue() {
////        System.out.println("Please enter the food item");
////        String food = input.nextLine();
////        if (food == null || food == "" || food.matches(".*\\d.*")) {
////            System.out.println("Please review your entry");
////        } else {
////            System.out.println("Please enter the calories (only integers)");
////            int calories = -1;
////            try {
////                calories = input.nextInt();
////            } catch (InputMismatchException e) {
////                input.next();
////            }
////            if (calories < 0) {
////                System.out.println("Please review your entry");
////            } else {
////                System.out.println("Please enter the servings (only integers)");
////                int servings = -1;
////                try {
////                    servings = input.nextInt();
////                } catch (InputMismatchException e) {
////                    input.next();
////                }
////                if (servings < 0) {
////                    System.out.println("Please review your entry");
////                } else {
////                    calTracker.addFood(food, calories, servings, myList);
////                    printCal();
////                }
////            }
////        }
////    }
//
//    public void openNewFoodDialogue() {
//        Scanner sc = new Scanner(System.in);
//        boolean onfd = true;
//        while (onfd) {
//            System.out.println("Please enter the food item");
//            String food = sc.nextLine();
//            if (food == null || food == "" || food.matches(".*\\d.*")) {
//                System.out.println("Please review your entry\n");
//            } else {
//                System.out.println("Please enter the calories (only integers)");
//                int calories = -1;
//                try {
//                    calories = input.nextInt();
//                } catch (InputMismatchException e) {
//                    input.next();
//                }
//                if (calories < 0) {
//                    System.out.println("Please review your entry\n");
//                } else {
//                    System.out.println("Please enter the servings (only integers)");
//                    int servings = -1;
//                    try {
//                        servings = input.nextInt();
//                    } catch (InputMismatchException e) {
//                        input.next();
//                    }
//                    if (servings < 0) {
//                        System.out.println("Please review your entry\n");
//                    } else {
//                        calTracker.addFood(food, calories, servings, myList);
//                        printCal();
//                        onfd = false;
//                    }
//                }
//            }
//        }
//    }
////    public void openNewFoodDialogue() {
////        Scanner sc = new Scanner(System.in);
////        boolean onfd = true;
////        while (onfd) {
////            System.out.println("Please enter the food item");
////        String food = sc.nextLine();
////        if (food == null || food == "" || food.matches(".*\\d.*")) {
////            System.out.println("Please review your entry\n");
////        } else {
////            System.out.println("Please enter the calories (only integers)");
////            int calories = -1;
////            try {
////                calories = input.nextInt();
////            } catch (InputMismatchException e) {
////                input.next();
////            }
////            if (calories < 0) {
////                System.out.println("Please review your entry\n");
////            } else {
////                System.out.println("Please enter the servings (only integers)");
////                int servings = -1;
////                try {
////                    servings = input.nextInt();
////                } catch (InputMismatchException e) {
////                    input.next();
////                }
////                if (servings < 0) {
////                    System.out.println("Please review your entry\n");
////                } else {
////                    calTracker.addFood(food, calories, servings, myList);
////                    printCal();
////                    onfd = false;
////                }
////            }
////        }
////    }
////}
//
//
//    public void printConsFood() {
//        calTracker.consFood(myList);
//        System.out.println(calTracker.getConsFood());
//
//    }
//
////    public void quitProgram() {
////        stop = false;
////    }
//
//    public void printCal() {
//
//        System.out.println(calTracker.getEvenDefSur());
//
//    }
//
////    public static boolean isNumeric(String str) {
////        try {
////            Double.parseDouble(str);
////            return true;
////        } catch (NumberFormatException e) {
////            return false;
////        }
////    }
//}
