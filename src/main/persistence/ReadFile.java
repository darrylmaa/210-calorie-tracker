package persistence;

import model.Tracker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// source: TellerApp Reader
public class ReadFile {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of trackers parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<Tracker> readTracker(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of trackers parsed from list of strings
    // where each string contains data for one tracker
    private static List<Tracker> parseContent(List<String> fileContent) {
        List<Tracker> accounts = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            accounts.add(parseTracker(lineComponents));
        }

        return accounts;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 4 where element 0 represents the
    // id of the next tracker to be constructed, element 1 represents
    // the id, elements 2 represents the calorieGoal, element 3 represents
   // the surpCal of the account to be constructed and element 4 represents the foodList
    // EFFECTS: returns tracker constructed from components
    private static Tracker parseTracker(List<String> components) {
        int nextId = Integer.parseInt(components.get(0));
        int id = Integer.parseInt(components.get(1));
        int calorieGoal = Integer.parseInt(components.get(2));
        int surpCal = Integer.parseInt(components.get(3));
        return new Tracker(nextId, id, calorieGoal, surpCal);
    }
}


