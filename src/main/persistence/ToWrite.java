package persistence;


import java.io.*;

public class ToWrite {

    //REQUIRES: grocery items to have been added to the inventory
    //MODIFIES: this
    //EFFECTS: takes 2 strings, the user input and text file path and writes the user input to that text file
    // using a buffered writer, closes file, prints success, else throws an IOException
    public void writing(String toPutin, String fileName) {
        try {
            String toInputItems = toPutin;


            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileName)  //Set true for append mode
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
