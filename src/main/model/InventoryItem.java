package model;

public class InventoryItem {

    private GroceryItem groceryItem;
    private int quantity;
    boolean perishable;

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
