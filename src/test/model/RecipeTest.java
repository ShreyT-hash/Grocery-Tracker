package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    ArrayList <GroceryItem> penneArabiatta = new ArrayList<>();
    ArrayList <GroceryItem> cereal = new ArrayList<>();
    Inventory inventory = new Inventory();
    Recipes recipes = new Recipes();
    GroceryItem milk = new GroceryItem("milk", 2);
    GroceryItem cheetoes = new GroceryItem("cheetoes", 1);
    GroceryItem sugar = new GroceryItem("sugar", 1.4);
    GroceryItem cheerioes = new GroceryItem("cheeroes", 1.8);

    GroceryItem tomatoSauce = new GroceryItem("tomato sauce", 3.2);
    GroceryItem pasta = new GroceryItem("pasta", 1.4);

    @BeforeEach
    void RunBefore(){

        penneArabiatta.add(tomatoSauce);
        penneArabiatta.add(pasta);

        cereal.add(sugar);
        cereal.add(cheerioes);
        cereal.add(milk);

    }

    @Test
    void testCheckRecipe() {
        inventory.addItemToInventory(milk, 1, true);
        inventory.addItemToInventory(cheerioes, 1, true);
        inventory.addItemToInventory(sugar, 2, false);
        inventory.addItemToInventory(pasta, 2, false);

        assertFalse(recipes.containsRecipe(inventory.getToCookItems(), penneArabiatta));
        assertTrue(recipes.containsRecipe(inventory.getToCookItems(), cereal));

    }
}
