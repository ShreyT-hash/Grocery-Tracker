package model;

import java.util.ArrayList;

public class GroceryItem {
    private String name;
    private double price;



    // EFFECTS: constructs a grocery item with name and price
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



    // Got the idea to create a groceryItem class like this one based on Assignment 2 which was done earlier this term

}
