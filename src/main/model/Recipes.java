package model;

import java.util.ArrayList;

public class Recipes {
    ArrayList<GroceryItem> cereal;
    GroceryItem milk = new GroceryItem("milk", 2);
    GroceryItem cheetoes = new GroceryItem("cheetoes", 1);
    GroceryItem sugar = new GroceryItem("sugar", 1.4);
    GroceryItem cheerioes = new GroceryItem("cheerioes", 1.8);


    // EFFECTS: constructs a recipe which currently has a collection of grocery items
    public Recipes() {
        cereal = new ArrayList<>();
        cereal.add(sugar);

    }

    //REQUIRES: two valid collections of groceryItem to be passed as parameters so they can be compared
    //MODIFIES: this
    // EFFECTS: takes two groceryItem collections, if b contains everything in a, then returns true, else returns false
    public boolean containsRecipe(ArrayList<GroceryItem> a, ArrayList<GroceryItem> b) {
        if (a.containsAll(b)) {
            return true;
        } else {
            return false;
        }
    }


    public ArrayList<GroceryItem> getCereal() {
        return cereal;
    }
}
