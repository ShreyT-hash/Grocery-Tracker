package model;

import java.util.ArrayList;

public class Recipes {
//    Inventory inventory;
//    ArrayList<GroceryItem> cereal;
//    ArrayList<GroceryItem> penneArabiatta;
//    GroceryItem milk = new GroceryItem("milk", 2, 3);
//    GroceryItem cheetoes = new GroceryItem("cheetoes", 1, 3);
//    GroceryItem sugar = new GroceryItem("sugar", 1.4, 3);
//    GroceryItem cheeroes = new GroceryItem("cheeroes", 1.8, 1);
//    GroceryItem tomatoSauce = new GroceryItem("tomato sauce", 3.2, 1);
//    GroceryItem pasta = new GroceryItem("pasta", 1.4, 2);

    Recipes() {

//        cereal.add(milk);
//        cereal.add(sugar);
//        cereal.add(cheeroes);
//        penneArabiatta.add(tomatoSauce);
//        penneArabiatta.add(pasta);


    }

    public boolean containsRecipe(ArrayList<GroceryItem> a, ArrayList<GroceryItem> b) {
        if (a.containsAll(b)) {
            return true;
        } else {
            return false;
        }
    }



}
