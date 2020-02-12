package model;

import java.awt.*;
import java.util.ArrayList;

public class Inventory {
    ArrayList<InventoryItem> fridgeItems;
    ArrayList<GroceryItem> toCookItems;
    StringBuilder sb = new StringBuilder();
    InventoryItem inventoryItem;

    Inventory() {

        fridgeItems = new ArrayList<>();
        toCookItems = new ArrayList<>();
    }

    public void addItemToInventory(GroceryItem gi, int quantity, boolean perishable) {
        inventoryItem = new InventoryItem(gi, quantity, perishable);
        fridgeItems.add(inventoryItem);
        toCookItems.add(gi);


    }

    public double totalPrice() {
        double sum = 0;
        for (InventoryItem ii : fridgeItems) {

            sum = sum + ii.getGroceryItem().getPrice();

        }
        return sum;

    }

    public ArrayList getFridgeItems() {
        return fridgeItems;
    }

    public ArrayList getToCookItems() {
        return toCookItems;
    }

    public String sumToString() {
        String finalSpend = "You spent $" + totalPrice() + " on groceries this time";
        return finalSpend;
    }

    public String viewInventory() {
        String inventoryDisplay = "";

        for (InventoryItem ii : fridgeItems) {

            String groceryItemName = ii.getGroceryItem().getName();
            double groceryItemQuantity = ii.getQuantity();
            boolean exp = ii.isPerishable();
            String expYn = Boolean.toString(exp);

            inventoryDisplay = "Item: "+ groceryItemName + "/ Quantity: " + groceryItemQuantity + "/ Perishable: " + expYn + "\n";
            inventoryDisplay = sb.append(inventoryDisplay).toString();
        }
        return inventoryDisplay;
    }

}
