package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

// source: TellerApp Writer.java
public class WriteFile {
    private PrintWriter printWriter;

    // EFFECTS: constructs a writer that will write data to file
    public WriteFile(File file) throws FileNotFoundException, UnsupportedEncodingException {
        printWriter = new PrintWriter(file, "UTF-8");
    }

    // MODIFIES: this
    // EFFECTS: writes saveable to file
    public void write(SaveFile saveFile) {
        saveFile.save(printWriter);
    }

    // MODIFIES: this
    // EFFECTS: close print writer
    // NOTE: you MUST call this method when you are done writing data!
    public void close() {
        printWriter.close();
    }
}

