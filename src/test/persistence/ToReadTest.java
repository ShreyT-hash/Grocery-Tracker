package persistence;
import model.GroceryItem;
import exceptions.InputException;
import model.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ToReadTest {
    Inventory inventory = new Inventory();
    ToRead toRead = new ToRead();
    ToWrite write = new ToWrite();

    GroceryItem bananas = new GroceryItem("bananas", 2);
    GroceryItem apples = new GroceryItem("apples", 1.4);
    GroceryItem rice = new GroceryItem("rice", 1.8);

    public ToReadTest() throws FileNotFoundException {
    }

    @BeforeEach
    void RunBefore() throws InputException {

        inventory.addItemToInventory(bananas, 1, true);
        inventory.addItemToInventory(apples, 1, true);
        inventory.addItemToInventory(rice, 2, false);
    }
    @Test
    void testParseAccountsFile1() throws IOException {
        write.writing(inventory.viewInventoryWrite(), "./data/Pantry_Items1.txt");
        try {


            toRead.parseFile(toRead.readAllLines(new File("./data/Pantry_Items1.txt")));


            assertEquals(toRead.getNameTing().get(2), "\r\nrice");
            assertEquals(toRead.getNameTing().get(0), "\r\nbananas");
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