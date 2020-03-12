package ui;

import model.GroceryItem;
import model.Inventory;
import persistence.ToRead;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddGroceryScene implements ActionListener {
    Inventory inventory = new Inventory();
    java.awt.Font defaultFont = new java.awt.Font("Segoe UI Light", Font.PLAIN, 30);

    UserInterface ui = new UserInterface();
    JFrame addGroceryScene = new JFrame();
    JButton addGrocery = new JButton();
    JButton viewPantry = new JButton();
    JButton viewMoney = new JButton();

    String name;
    String quantity;
    String price;
    String perishable;
    JTextField jft = new JTextField();


    public void createScene2() throws IOException {
        addGroceryScene.setSize(ui.getJframeWidth(), ui.getJframeHeight());//400 width and 500 height
        addGroceryScene.setLayout(null);//using no layout managers
        addGroceryScene.setVisible(true);


        ui.addButton(Color.pink, defaultFont, addGrocery, "Add Grocery Item", 100,
                120, 300, 70);
        ui.addButton(Color.pink, defaultFont, viewPantry, "View Pantry", 720, 120, 300,
                70);
        ui.addButton(Color.pink, defaultFont, viewMoney, "View Money Spent", 720, 120, 300,
                70);





        jft.setBounds(300, 400, 400, 300);
        jft.setText(inventory.viewInventory());
        jft.setVisible(false);
        addGroceryScene.add(addGrocery);
        addGroceryScene.add(viewPantry);
        addGroceryScene.add(jft);
        addGrocery.addActionListener(this);
        viewPantry.addActionListener(this);


    }


    public void jpaneDo() {

        this.name = JOptionPane.showInputDialog(addGroceryScene, "Enter Grocery Item Name");
        this.quantity = JOptionPane.showInputDialog(addGroceryScene, "Enter Quantity");
        this.price = JOptionPane.showInputDialog(addGroceryScene, "Enter Grocery Item Price");
        this.perishable = JOptionPane.showInputDialog(addGroceryScene,
                "Enter true if perishable, false if not");

        GroceryItem groceryItem = new GroceryItem(name, Double.parseDouble(price));
        inventory.addItemToInventory(groceryItem, Integer.parseInt(quantity), Boolean.getBoolean(perishable));
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;

    }

    public String getPerishable() {
        return perishable;
    }

    public void pantryShow() {




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Grocery Item")) {


            jpaneDo();

        }
        if (e.getActionCommand().equals("View Pantry")) {
            pantryShow();
            jft.setVisible(true);
            jft.setEditable(false);
            jft.setText(inventory.viewInventory());

        }
    }
}
