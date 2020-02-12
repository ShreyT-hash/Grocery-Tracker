package model;

import java.util.ArrayList;

public class GroceryItem {
    private String name;
    private double price;
    private int quantity;


    // EFFECTS: constructs a grocery item with name and price (in cents) and the quantity purchased
    public GroceryItem(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

//    public void addQuantity(int quant) {
//        this.quantity += quant;
//    }
}
