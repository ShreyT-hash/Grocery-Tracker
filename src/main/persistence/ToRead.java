package persistence;


import model.Inventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.util.ArrayList;

public class ToRead {
    public static final String DELIMITER = "/";
    String st;
    Inventory inventory = new Inventory();

    ArrayList<String> nameTing = new ArrayList<>();
    ArrayList<Integer> quantityTing = new ArrayList<Integer>();
    ArrayList<String> perishableTing = new ArrayList<>();


    //EFFECTS: constructs a reader that will read data from a file and throw an exception if file does not exist
    public ToRead() throws FileNotFoundException {
    }

    // MODIFIES: this
    //EFFECTS: while there are lines with data on them, reads all the lines in the newly created Pantry_Items text file
    public void setBr() throws IOException {

        File file = new File("./data/Pantry_Items.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));


        while ((st = br.readLine()) != null) {

            System.out.println(st);
        }


    }


    // MODIFIES: this
    //EFFECTS: reads all the lines which have data on them
    // using a buffered reader in a given file and appends and returns it to a string
    // Used code to change fileData into a string using a buffered reader
    // from this website: https://www.baeldung.com/reading-file-in-java
    public String readAllLines(File file) throws IOException {


        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder content = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString();
    }

    // MODIFIES: this
    //EFFECTS: parses string by taking a string, splitting it at every "/" and storing it in an Array called listTing
   // 3 for loops are then used used to store listTing arrayValues into their respective arraylists
    public void parseFile(String str) throws IOException {
        String[] listTing = str.split("/");


        for (int j = 0; j < listTing.length; j = j + 3) {
            nameTing.add(listTing[j]);


        }
        for (int k = 1; k < listTing.length; k = k + 3) {

            quantityTing.add(Integer.parseInt(listTing[k]));

        }
        for (int l = 2; l < listTing.length; l = l + 3) {

            perishableTing.add(listTing[l]);

        }
    }

    public ArrayList<Integer> getQuantityTing() {
        return quantityTing;
    }

    public ArrayList<String> getNameTing() {
        return nameTing;
    }

    public ArrayList<String> getPerishableTing() {
        return perishableTing;
    }
}





