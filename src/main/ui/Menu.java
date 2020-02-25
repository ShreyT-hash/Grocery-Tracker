package ui;

import model.GroceryItem;
import model.Inventory;
import model.Recipes;
import persistence.ToRead;
import persistence.ToWrite;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.URI;
import java.util.Scanner;

public class Menu {
    ToWrite toWrite;
    private static final String ACCOUNTS_FILE = "./data/Pantry_Items.txt";
    private Scanner input;
    Inventory inventory = new Inventory();


    public Menu() throws IOException {
        runGroceryApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runGroceryApp() throws IOException {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);


        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("5")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    private void displayMenu() {
        System.out.println("\nWelcome To Your Very Own Grocery Manager:");
        System.out.println("\t1 -> ADD GROCERIES");
        System.out.println("\t2 -> VIEW PANTRY");
        System.out.println("\t3 -> VIEW TOTAL MONEY SPENT");
        System.out.println("\t4 -> VIEW POSSIBLE RECIPES");
        System.out.println("\t5 -> quit");
    }

    private void processCommand(String command) throws IOException {
        if (command.equals("1")) {
            addGroceryUI();
        } else if (command.equals("2")) {
            viewPantryUI();
        } else if (command.equals("3")) {
            viewMoneySpentUI();
        } else if (command.equals("4")) {
            viewRecipesUI();
            //   System.out.println("This feature has not been implemented yet");

        } else if (command.equals("7")) {
            saveFileUI();
        } else if (command.equals("6")) {
            loadPreviousEntryItems();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    private void loadPreviousEntryItems() throws IOException {
        ToRead toRead = new ToRead();
        toRead.setBr();
    }


    private void viewRecipesUI() {
        Recipes recipes = new Recipes();
        if (recipes.containsRecipe(recipes.getCereal(), inventory.getFridgeItems())) {
            System.out.println("You can MAKE CEREAL");
        } else {
            System.out.println("Can't make anything yet");
        }
    }

    private void viewMoneySpentUI() {
        System.out.println(inventory.sumToString());
    }

    private void viewPantryUI() {
        String y = inventory.viewInventory();
        System.out.println(y);
        System.out.println(inventory.getFridgeItems().size());
        System.out.println("Total amount of perishable items are: " + inventory.perishableCount());



    }


    private void addGroceryUI() {
        boolean keepGoingAG = true;

        Inventory inventory = new Inventory();
        while (keepGoingAG == true) {
            groceryAddInput();

            System.out.println("Add another item? Enter Y or N");
            String itemNew = input.next();
            if (itemNew.equals("N")) {
                keepGoingAG = false;

            }
        }
    }

    private void groceryAddInput() {
        String tempGI;
        double tempGICost;
        int tempGIQuant;
        boolean tempGIExp;
        System.out.println("Please enter the grocery that you purchased");
        String gi = input.next();
        tempGI = gi;

        System.out.println("How much did it cost");
        double gicost = input.nextDouble();
        tempGICost = gicost;

        System.out.println("Please enter quantity purchased");
        int giquant = input.nextInt();
        tempGIQuant = giquant;

        System.out.println("The item is perishable, true or false?");
        boolean giExp = input.nextBoolean();
        tempGIExp = giExp;
        GroceryItem groceryItem = new GroceryItem(tempGI, tempGICost);
        inventory.addItemToInventory(groceryItem, tempGIQuant, tempGIExp);
    }

    private void saveFileUI() {

        ToWrite write = new ToWrite();

        write.writing(inventory.viewInventory());

//            ToWrite writer = new ToWrite(new File(ACCOUNTS_FILE));
//            writer.write(inventory);
//          //  writer.write();
//            writer.close();
//            System.out.println("Accounts saved to file " + ACCOUNTS_FILE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to save accounts to " + ACCOUNTS_FILE);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            // this is due to a programming error
    }
}





