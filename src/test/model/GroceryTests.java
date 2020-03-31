package model;

import exceptions.InputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GroceryTests {

    ArrayList <GroceryItem> penneArabiatta = new ArrayList<>();
    ArrayList <GroceryItem> cereal = new ArrayList<>();
    Inventory inventory = new Inventory();

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
    void testExceptionGetsThrown()  {
        try {
            inventory.addItemToInventory(milk, -3, true);
            fail("Should not be here");
            inventory.addItemToInventory(cheerioes, 1, true);
            inventory.addItemToInventory(sugar, 2, false);
            inventory.addItemToInventory(pasta, 2, false);
        }
        catch (InputException ie){
            System.out.println("Success");
        }


    }

    @Test
    void testExceptionNotThrown()  {
        try {
            inventory.addItemToInventory(milk, 9, true);

            inventory.addItemToInventory(cheerioes, 1, true);
            inventory.addItemToInventory(sugar, 2, false);
            inventory.addItemToInventory(pasta, 2, false);
        }
        catch (InputException ie){
            fail("Should not be here");
        }


    }


    @Test
    void testConstructor(){
        Inventory inventory = new Inventory();
        assertEquals(inventory.getFridgeItems().size(), 0);
        assertEquals(inventory.getToCookItems().size(), 0);
    }
    @Test
    void testAddItem() throws InputException {
        assertEquals(inventory.getFridgeItems().size(), 0);
        inventory.addItemToInventory(milk, 2, true);
        assertEquals(inventory.getFridgeItems().size(), 1);
    }

    @Test
    void testSum() throws InputException {
        inventory.addItemToInventory(milk, 2, true);
        inventory.addItemToInventory(cheetoes, 4, false);
        inventory.addItemToInventory(sugar, 1, false);
        assertEquals(inventory.totalPrice(), 9.4);
    }

    @Test
    void testSumToString() throws InputException {
        inventory.addItemToInventory(milk, 1, true);
        inventory.addItemToInventory(cheetoes, 4, false);
        inventory.addItemToInventory(sugar, 2, false);
        assertEquals(inventory.sumToString(), "You spent $8.8 on groceries this time");
    }


    @Test
    void testInventoryDisplay() throws InputException {
        inventory.addItemToInventory(milk, 1, true);
        inventory.addItemToInventory(cheetoes, 2, false);
        inventory.addItemToInventory(cheerioes, 3, true);
        assertEquals(inventory.viewInventory(), "Item: milk/ Quantity: 1.0/ Perishable: true\n" +
                "Item: cheetoes/ Quantity: 2.0/ Perishable: false\n" +
                "Item: cheerioes/ Quantity: 3.0/ Perishable: true\n");

    }

    @Test
    void testBoolCount() throws InputException {
        inventory.addItemToInventory(milk, 1, true);
        assertEquals(inventory.perishableCount(), 1);
        inventory.addItemToInventory(cheetoes, 2, false);
        assertEquals(inventory.perishableCount(), 1);
        inventory.addItemToInventory(cheerioes, 3, true);
        assertEquals(inventory.perishableCount(), 2);

    }

}
