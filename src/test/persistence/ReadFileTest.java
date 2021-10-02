package persistence;

import model.Tracker;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// source: TellerApp ReaderTest.java

public class ReadFileTest {
    @Test
    void testFirstParseAccount() {
        try {
            List<Tracker> trackers = ReadFile.readTracker(new File("./data/FirstParseAccount.txt"));
            Tracker tracker = trackers.get(0);
            assertEquals(45, tracker.getId());
            assertEquals(500, tracker.getCalorieGoal());
            assertEquals(500, tracker.getSurplusCalories());
 //           assertEquals("e", tracker.consFood());

            Tracker nextTracker = new Tracker(100);
            assertEquals(46, nextTracker.getId());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testSecondParseAccount() {
        try {
            List<Tracker> trackers = ReadFile.readTracker(new File("./data/SecondParseAccount.txt"));
            Tracker tracker = trackers.get(0);
            assertEquals(99, tracker.getId());
            assertEquals(10, tracker.getCalorieGoal());
            assertEquals(10, tracker.getSurplusCalories());
//            assertEquals("l", tracker.getConsFood());

            Tracker nextTracker = new Tracker(100);
            assertEquals(100, nextTracker.getId());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOExceptionFail() {
        try {
            ReadFile.readTracker(new File("./path/DNEPath.txt"));
        } catch (IOException e) {
            //...
        }
    }
}
