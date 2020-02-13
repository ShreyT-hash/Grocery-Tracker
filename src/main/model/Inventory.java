package model;

import java.awt.*;
import java.util.ArrayList;


public class Inventory {
    ArrayList<InventoryItem> fridgeItems;
    ArrayList<GroceryItem> toCookItems;
    StringBuilder sb = new StringBuilder();
    InventoryItem inventoryItem;

    // EFFECTS: creates an inventory with an empty list of fridge items and recipe ingredients
    public Inventory() {

        fridgeItems = new ArrayList<>();
        toCookItems = new ArrayList<>();
    }

    // REQUIRES: a valid grocery item to be inputted
    // MODIFIES: this
    // EFFECTS: adds recipe ingredient list, creates a new inventory item and then adds it to the fridgeItem list
    public void addItemToInventory(GroceryItem gi, int quantity, boolean perishable) {

        toCookItems.add(gi);
        inventoryItem = new InventoryItem(gi, quantity, perishable);
        fridgeItems.add(inventoryItem);


    }

    // REQUIRES: frigeItems to not be an empty list
    // MODIFIES: this
    // EFFECTS: returns the total amount of money spent on grocery items
    public double totalPrice() {
        double sum = 0;
        for (InventoryItem ii : fridgeItems) {

            sum = sum + ii.getGroceryItem().getPrice();

        }
        return sum;

    }


    // MODIFIES: this
    // EFFECTS: returns the total amount of money spent on grocery items in a string format
    public String sumToString() {
        String finalSpend = "You spent $" + totalPrice() + " on groceries this time";
        return finalSpend;
    }

    // MODIFIES: this
    // EFFECTS: returns a string that displays everything that is in the inventory, including quantity and
    // whether it is perishable or not
    public String viewInventory() {
        String inventoryDisplay = "";

        for (InventoryItem ii : fridgeItems) {

            String groceryItemName = ii.getGroceryItem().getName();
            double groceryItemQuantity = ii.getQuantity();
            boolean exp = ii.isPerishable();
            String expYn = Boolean.toString(exp);

            inventoryDisplay = "Item: " + groceryItemName + "/ Quantity: " + groceryItemQuantity + "/ Perishable: "
                    + expYn + "\n";
            inventoryDisplay = sb.append(inventoryDisplay).toString();
        }
        return inventoryDisplay;
    }

    // MODIFIES: this
    // EFFECTS: returns an integer that tells the user the total number of perishable items currently in their fridge
    public int perishableCount() {
        int boolCount = 0;
        for (InventoryItem inventoryItem : fridgeItems) {

            if (inventoryItem.isPerishable()) {
                boolCount++;
            }


        }
        return boolCount;

    }

    public ArrayList getFridgeItems() {
        return fridgeItems;
    }

    public ArrayList getToCookItems() {
        return toCookItems;
    }


}
