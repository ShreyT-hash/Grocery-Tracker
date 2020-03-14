package ui;

import model.GroceryItem;
import model.Inventory;
import persistence.ToRead;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddGroceryScene extends Canvas implements ActionListener {
    ToRead toRead = new ToRead();
    ArrayList<JButton> grocerySButtons = new ArrayList<>();

    ArrayList<JLabel> itemsList = new ArrayList<>();
    JPanel fridge = new JPanel();
    String imagePath = "C:\\Users\\shrey\\Desktop\\fridge.png";
    BufferedImage myPicture = ImageIO.read(new File(imagePath));
    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    Inventory inventory = new Inventory();
    java.awt.Font defaultFont = new java.awt.Font("Segoe UI Light", Font.PLAIN, 30);
    java.awt.Font textFont = new java.awt.Font("Segoe UI Light", Font.PLAIN, 25);


    UserInterface ui = new UserInterface();
    JFrame addGroceryScene = new JFrame();
    JButton addGrocery = new JButton("Add Groceries");
    JButton viewPantry = new JButton("View Pantry Items");
    JButton viewMoney = new JButton("View Summary");
    String name;
    String quantity;
    String price;
    String perishable;
    JLabel groceryDisplay;

    public AddGroceryScene() throws IOException {
    }


    public void createScene2() throws IOException {
        addGroceryScene.setSize(ui.getJframeWidth(), ui.getJframeHeight());//400 width and 500 height
        addGroceryScene.setLayout(null);//using no layout managers
        addGroceryScene.setVisible(true);
        fridge.add(picLabel);
        fridge.setVisible(true);

        addButtonsToFrame();
        addtoGroceryScene();

        fridge.setSize(myPicture.getWidth(), myPicture.getHeight());
        addGroceryScene.add(fridge);


    }


    public void jpaneDo() {

        this.name = JOptionPane.showInputDialog(addGroceryScene, "Enter Grocery Item Name");
        this.quantity = JOptionPane.showInputDialog(addGroceryScene, "Enter Quantity");
        this.price = JOptionPane.showInputDialog(addGroceryScene, "Enter Grocery Item Price");
        this.perishable = JOptionPane.showInputDialog(addGroceryScene,
                "Enter true if perishable, false if not");

        GroceryItem groceryItem = new GroceryItem(name, Double.parseDouble(price));
        inventory.addItemToInventory(groceryItem, Integer.parseInt(quantity), Boolean.valueOf(perishable));
        itemsList.add(new JLabel(name + " | " + quantity + " | " + perishable));


    }

    public void addButtonsToFrame() {

        grocerySButtons.add(addGrocery);
        grocerySButtons.add(viewPantry);
        grocerySButtons.add(viewMoney);

        for (JButton j : grocerySButtons) {
            addGroceryScene.add(j);

        }

    }

    public void addtoGroceryScene() {
        int newYPOS = 180;
        for (JButton j : grocerySButtons) {

            ui.addButton(Color.pink, defaultFont, j, j.getText(), 60,
                    newYPOS, 300, 70);
            newYPOS = newYPOS + 80;

        }
        for (JButton j : grocerySButtons) {

            j.addActionListener(this);

        }
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
        if (fridge.isVisible() == false) {
            fridge.setVisible(true);

            int newYPOS = 300;
            for (JLabel j : itemsList) {

                j.setBounds(500, newYPOS, 220, 70);
                j.setVisible(true);
                j.setFont(textFont);

                addGroceryScene.add(j);
                newYPOS = newYPOS + 35;


            }


//            groceryDisplay.setText(inventory.viewInventory() + "\n");
//            groceryDisplay.setBounds(500, 180, 700, 200);
//            groceryDisplay.setVisible(true);
//            addGroceryScene.add(groceryDisplay);

        } else {
            fridge.setVisible(false);


        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Groceries")) {


            jpaneDo();

        }
        if (e.getActionCommand().equals("View Pantry Items")) {
            pantryShow();


        }
    }
}

