package model;

public class InventoryItem {

    private GroceryItem groceryItem;
    private int quantity;
    boolean perishable;


    // EFFECTS: constructs an inventory item which is consists of a grocery item, its quantity and whether it is
    // perishable or not
    public InventoryItem(GroceryItem item, int quantity, boolean perishable) {
        this.groceryItem = item;
        this.quantity = quantity;
        this.perishable = perishable;
    }

    public int getQuantity() {
        return quantity;
    }

    public GroceryItem getGroceryItem() {
        return groceryItem;
    }

    public boolean isPerishable() {
        return perishable;
    }


}
