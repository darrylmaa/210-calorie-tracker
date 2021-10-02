package model;

import com.sun.org.apache.xpath.internal.operations.Neg;
import model.exceptions.NegativeNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalorieTrackerTest {
    Tracker ct1;
    public static final int iniCalorieGoal = 10000;
    ArrayList<FoodItem> myList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        ct1 = new Tracker(iniCalorieGoal);
    }

    @Test
    void testConstructor() {
        assertEquals(10000, ct1.getCalorieGoal());
        assertEquals("", ct1.consFood(myList));
    }

    @Test
    void testAddFoodToList() {
        try {
            ct1.addFood("Orange", 200, 1, myList);
            ct1.addFood("Apple", 50, 1, myList);

            assertEquals("1 serving(s) of Orange containing 200 calorie(s) per serving. <br/>1 serving(s) of Apple containing 50 calorie(s) per serving. <br/>", ct1.consFood(myList));
        } catch (NegativeNumberException e) {
            fail();
        }
    }

    @Test
    void testCalExceptionThrow() {
        try {
            ct1.addFood("Orange", -1, 1, myList);
        } catch (NegativeNumberException e) {
            //exception caught
        }
    }

    @Test
    void testServExceptionThrow() {
        try {
            ct1.addFood("Apple", 100, -1, myList);
        } catch (NegativeNumberException e) {
            //exception caught
        }
    }

    @Test
    void testCalIntakeIsCorrect() {
        try {
            ct1.addFood("Orange", 200, 1, myList);
            assertEquals(9800, ct1.getCalorieGoal());
        } catch (NegativeNumberException e) {
            fail();
        }
    }


    @Test
    void testCalSurplus() {
        try {
            ct1.addFood("Chicken", 5000, 4, myList);
            assertEquals("You are at a calorie surplus of 10000!", ct1.getEvenDefSur());
        } catch (NegativeNumberException e) {
            fail();
        }
    }

    @Test
    void testCalDeficit() {
        try {
            ct1.addFood("Salmon", 500, 1, myList);
            assertEquals("You are at a calorie deficit of 9500!", ct1.getEvenDefSur());
        } catch (NegativeNumberException e) {
            fail();
        }
    }

    @Test
    void testCalEven() {
        try {
            ct1.addFood("Chicken", 5000, 2, myList);
            assertEquals("You have perfectly met your calorie goal!", ct1.getEvenDefSur());
        } catch (NegativeNumberException e) {
            fail();
        }
    }
}