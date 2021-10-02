package persistence;

import model.FoodItem;
import model.Tracker;
import model.exceptions.NegativeNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// source: TellerApp WriterTest
public class WriteFileTest {
    private static final String TEST_FILE = "./data/testTrackers.txt";
    private WriteFile testWriter;
    private Tracker calTrack;
    ArrayList<FoodItem> myList = new ArrayList<>();


    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new WriteFile(new File(TEST_FILE));
        calTrack = new Tracker(10000);

    }

    @Test
    void testWriteAccounts() {
        // save Trackers to file
        testWriter.write(calTrack);
        testWriter.close();

        // now read them back in and verify that the ids have the expected values
        try {
            List<Tracker> trackers = ReadFile.readTracker(new File(TEST_FILE));
            Tracker calTrack = trackers.get(0);
            assertEquals(1, calTrack.getId());
            assertEquals(10000, calTrack.getCalorieGoal());
            assertEquals(10000, calTrack.getSurplusCalories());
            calTrack.addFood("Orange", 20, 1, myList);

            assertEquals("1 serving(s) of Orange containing 20 calorie(s) per serving. <br/>", calTrack.consFood(myList));


            // verify that ID of next account created is 2 (checks that nextAccountId was restored)
            Tracker next = new Tracker(100);
            assertEquals(2, next.getId());
        } catch (IOException | NegativeNumberException e) {
            fail("IOException should not have been thrown");
        }
    }
}
