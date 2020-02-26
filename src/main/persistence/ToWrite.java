package persistence;

import model.Inventory;

import java.io.*;

public class ToWrite {

//    private PrintWriter printWriter;
//
//    public ToWrite(File file) throws FileNotFoundException, UnsupportedEncodingException {
//        printWriter = new PrintWriter(file, "UTF-8");
//    }
//
//    // MODIFIES: this
//    // EFFECTS: writes saveable to file
//    public void write(Saveable saveable) {
//        saveable.save(printWriter);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: close print writer
//    // NOTE: you MUST call this method when you are done writing data!
//    public void close() {
//        printWriter.close();
//    }

    public void writing(String toPut) {
        try {
            String toInputItems = toPut;


            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("./data/Pantry_Items.txt")  //Set true for append mode
            );
            writer.newLine();
            writer.write(toInputItems);
            writer.close();
            System.out.println("Successfully written to file");

        } catch (IOException e) {
            System.err.println("Problem writing to the file Pantry_Items.txt");
        }
    }
}
