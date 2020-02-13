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
    GroceryItem cheerioes = new GroceryItem("cheerioes", 1.8);

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

    @Test
    void testConstructor(){
        Inventory inventory = new Inventory();
        assertEquals(inventory.getFridgeItems().size(), 0);
        assertEquals(inventory.getToCookItems().size(), 0);
    }
    @Test
    void testAddItem(){
        assertEquals(inventory.getFridgeItems().size(), 0);
        inventory.addItemToInventory(milk, 2, true);
        assertEquals(inventory.getFridgeItems().size(), 1);
    }

    @Test
    void testSum(){
        inventory.addItemToInventory(milk, 2, true);
        inventory.addItemToInventory(cheetoes, 4, false);
        inventory.addItemToInventory(sugar, 1, false);
        assertEquals(inventory.totalPrice(), 4.4);
    }

    @Test
    void testSumToString(){
        inventory.addItemToInventory(milk, 1, true);
        inventory.addItemToInventory(cheetoes, 4, false);
        inventory.addItemToInventory(sugar, 2, false);
        assertEquals(inventory.sumToString(), "You spent $4.4 on groceries this time");
    }


    @Test
    void testInventoryDisplay(){
        inventory.addItemToInventory(milk, 1, true);
        inventory.addItemToInventory(cheetoes, 2, false);
        inventory.addItemToInventory(cheerioes, 3, true);
        assertEquals(inventory.viewInventory(), "Item: milk/ Quantity: 1.0/ Perishable: true\n" +
                "Item: cheetoes/ Quantity: 2.0/ Perishable: false\n" +
                "Item: cheerioes/ Quantity: 3.0/ Perishable: true\n");

    }

    @Test
    void testBoolCount(){
        inventory.addItemToInventory(milk, 1, true);
        assertEquals(inventory.perishableCount(), 1);
        inventory.addItemToInventory(cheetoes, 2, false);
        assertEquals(inventory.perishableCount(), 1);
        inventory.addItemToInventory(cheerioes, 3, true);
        assertEquals(inventory.perishableCount(), 2);

    }

}
