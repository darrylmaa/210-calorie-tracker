package model;

import model.exceptions.NegativeNumberException;
import persistence.ReadFile;
import persistence.SaveFile;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Tracker implements SaveFile {
    private List<FoodItem> foodList;      // food list
    private int calorieGoal;                // Calorie goal
    private int surplusCalories;                    // calories if surplus
    private int id;                         // unique account id for data
    private static int nextAccountId = 1;                 // tracks id of next account
    private String printList;                      // foodlist printed by cons

    // REQUIRES: iniCalorieGoal is >= 0
    // EFFECTS: Create an empty list of foods consumed for the calorie
    // tracker
    public Tracker(int iniCalorieGoal) {
        id = nextAccountId++;
        foodList = new ArrayList<>();
        calorieGoal = iniCalorieGoal;
        surplusCalories = iniCalorieGoal;
        printList = "";
    }

    //source: TellerApp Account
    // REQUIRES: calorieGoal >= 0
    // EFFECTS: constructs account with id, calorieGoal and surpCalorie.
    // Next account to be constructed is from nextAccountId.
    // Only used when constructing account from data stored in file
    public Tracker(int nextId, int id, int calorieGoal, int surplusCalories) {
        nextAccountId = nextId;
        this.id = id;
        this.calorieGoal = calorieGoal;
        this.surplusCalories = surplusCalories;
    }

    //As a user, I want to be able to add a new food to my list of common foods
    // REQUIRES: calories >= 0, servings >= 0
    // EFFECTS: Adds food to the list of foods consumed
    public void addFood(String food, int calories, int servings, ArrayList myList) throws NegativeNumberException {
        if (!(calories >= 0 && servings >= 0)) {
            throw new NegativeNumberException();
        }
        foodList = myList;
        calIntake(calories, servings);
        foodList.add(new FoodItem(food, calories, servings));
    }

    //As a user, I want to be able to accurately track my caloric intake

    //REQUIRES: foodServing > 0
    //EFFECTS: Receive an updated calorie goal after inputting a new food
    public int calIntake(int foodCalorie, int foodServing) {
        calorieGoal = calorieGoal - (foodCalorie * foodServing);
        return calorieGoal;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public int getId() {
        return id;
    }

    public int getSurplusCalories() {
        return surplusCalories;
    }

    // source: https://github.students.cs.ubc.ca/cpsc210-2019w-t2/assign2_k9w2b/blob/master/src/main/ca/ubc/cpsc210/grocery/model/GroceryBill.java - toString method
    //As a user, I want to be able to retrieve a list of all the foods I consumed throughout the day
    //EFFECTS: Provide a list of foods consumed throughout the day
    public String consFood(ArrayList myList) {
        String temp;
        foodList = myList;
        printList = "";
        for (FoodItem foodItem : foodList) {
            String name = foodItem.getName();
            int foodCals = foodItem.getCalories();
            int servs = foodItem.getServings();
            temp = servs + " serving(s) of " + name + " containing " + foodCals + " calorie(s) per serving. <br/>";
            printList = printList + temp;
        }
        return printList;
    }

    //As a user, I want to be able to know if I'm at a caloric deficit or surplus
    // EFFECTS: PRODUCES IF SURPLUS/DEFICIT/EVEN
    public String getEvenDefSur() {
        if (calorieGoal > 0) {
            return "You are at a calorie deficit of " + calorieGoal + "!";
        }
        if (calorieGoal == 0) {
            return "You have perfectly met your calorie goal!";
        } else {
            surplusCalories = calorieGoal * -1;
            return "You are at a calorie surplus of " + surplusCalories + "!";
        }
    }

    //source: TellerApp Account
    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(nextAccountId);
        printWriter.print(ReadFile.DELIMITER);
        printWriter.print(id);
        printWriter.print(ReadFile.DELIMITER);
        printWriter.print(calorieGoal);
        printWriter.print(ReadFile.DELIMITER);
        printWriter.print(surplusCalories);
    }
}
