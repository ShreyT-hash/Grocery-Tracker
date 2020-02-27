package persistence;

import model.GroceryItem;
import model.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Menu;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ToWriteTest {
    private static final String TEST_FILE = "./data/testPantry.txt";
    Inventory inventory = new Inventory();
    ToRead toRead = new ToRead();
    ToWrite write = new ToWrite();

    GroceryItem milk = new GroceryItem("milk", 2);
    GroceryItem sugar = new GroceryItem("sugar", 1.4);
    GroceryItem cheerioes = new GroceryItem("cheerioes", 1.8);

    public ToWriteTest() throws FileNotFoundException {
    }


    @BeforeEach
            void RunBefore() throws FileNotFoundException {
        inventory.addItemToInventory(milk, 1, true);
        inventory.addItemToInventory(cheerioes, 1, true);
        inventory.addItemToInventory(sugar, 2, false);
    }

    @Test
            void testToWrite() throws FileNotFoundException {
        write.writing(inventory.viewInventoryWrite(), "./data/Pantry_Items2.txt");

        try {

           //toRead.readAllLines();
            toRead.parseFile(toRead.readAllLines(new File("./data/Pantry_Items2.txt")));

            assertEquals(toRead.getNameTing().get(0), "\r\nmilk");

            assertEquals(toRead.getNameTing().get(1), "\r\ncheerioes");

            assertEquals(toRead.getNameTing().get(2), "\r\nsugar");
           assertEquals(toRead.getQuantityTing().get(0), 1);
           assertEquals(toRead.getQuantityTing().get(1), 1);
           assertEquals(toRead.getQuantityTing().get(2), 2);

            assertEquals(toRead.getPerishableTing().get(0), "true");
            assertEquals(toRead.getPerishableTing().get(1), "true");
            assertEquals(toRead.getPerishableTing().get(2), "false");
            assertEquals(inventory.getFridgeItems().size(), 3);

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }



}
    }
