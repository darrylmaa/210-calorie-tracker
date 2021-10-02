package persistence;

import java.io.PrintWriter;

// source: TellerApp Saveable.java
public interface SaveFile {
    // MODIFIES: printWriter
    // EFFECTS: writes the savefile to printWriter
    void save(PrintWriter printWriter);
}
