package persistence;


import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ToRead {
    public static final String DELIMITER = "/";
    String st;

    ArrayList<String> nameTing = new ArrayList<>();
    ArrayList<Integer> quantityTing = new ArrayList<Integer>();
    ArrayList<String> perishableTing = new ArrayList<>();


    public ToRead() throws FileNotFoundException {
    }

    public ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    public void setBr() throws IOException {

        File file = new File("./data/Pantry_Items.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));


        while ((st = br.readLine()) != null) {

            System.out.println(st);
        }
    }
    //return splitString(st);

    public String getSt() {
        return st;
    }

    public String readAllLines() throws IOException {
        File file = new File("./data/Pantry_Items.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder content = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString();
    }

    public void parseFile() throws IOException {
        String[] listTing = readAllLines().split("/");


        for (int j = 0; j < listTing.length; j = j + 3) {
            nameTing.add(listTing[j]);


        }
        for (int k = 1; k < listTing.length; k = k + 3) {

            quantityTing.add(Integer.parseInt(listTing[k]));

        }
        for (int l = 2; l < listTing.length; l = l + 3) {

            perishableTing.add(listTing[l]);

        }
//        System.out.println(perishableTing.get(0));
//        System.out.println(quantityTing.get(0));
//        System.out.println(nameTing.get(0));


        //    groceryItem = new GroceryItem(nameTing.get(i), 3);
        //  inventory.addItemToInventory(groceryItem, quantityTing.get(i), Boolean.getBoolean(perishableTing.get(i)));
        //   inventory.addItemToInventory(groceryItem, quantityTing.get(i), false);
        //   inventory.addItemToInventory(groceryItem, quantityTing.get(i), Boolean.getBoolean(perishableTing.get(i)));

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





