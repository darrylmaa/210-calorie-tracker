package model;

// Represents food item with name and calories
public class FoodItem {
    private String fname;
    private int fcalories;
    private int fservings;

    public FoodItem(String name, int calories, int servings) {
        fname = name;
        fcalories = calories;
        fservings = servings;
    }

    public String getName() {
        return fname;
    }

    public int getCalories() {
        return fcalories;
    }

    public int getServings() {
        return fservings;
    }
}
