package ui;

import model.GroceryItem;
import exceptions.InputException;
import model.Inventory;
import persistence.ToWrite;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddGroceryScene implements ActionListener {
    // FONT CONSTANTS
    java.awt.Font defaultFont = new java.awt.Font("Segoe UI Light", Font.PLAIN, 30);
    java.awt.Font textFont = new java.awt.Font("Segoe UI Light", Font.PLAIN, 20);

    // ArrayLists to store JSwing components
    ArrayList<JButton> grocerySButtons = new ArrayList<>();
    ArrayList<JLabel> itemsList = new ArrayList<>();


    // To create fridge image
    String imagePath = "./data/fridge.png";
    BufferedImage myPicture = ImageIO.read(new File(imagePath));

    // Instantiating and declaring JComponents
    JPanel fridge = new JPanel();
    JLabel header = new JLabel();
    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    JFrame addGroceryScene = new JFrame();
    JFrame grocerySummary = new JFrame();
    JButton addGrocery = new JButton("Add Groceries");
    JButton viewPantry = new JButton("View Pantry Items");
    JButton viewMoney = new JButton("View Summary");
    JButton saveItems = new JButton("Save Items");
    JButton back = new JButton("Return To Menu");

    JButton bbutton = new JButton();
    // Instantiating and declaring model classes to use
    Inventory inventory = new Inventory();
    UserInterface ui = new UserInterface();

    JLabel totalMQ = new JLabel();
    JLabel perishableTotal = new JLabel();


    String name;
    String quantity;
    String price;
    String perishable;
    //   MenuUI menuUI = new MenuUI();


    // EFFECTS: throws IOException
    public AddGroceryScene() throws IOException {

    }


    // REQUIRES: a path for the fridge.png image and a buffered image method to be declared as a field,
    // also have all the JSwing components that are to be added to be instantiated and declared.
    // MODIFIES: addGroceryScene JFrame
    // EFFECTS: sets up the current scene with relevant parameters (Jlabels, JButtons etc.)
    public void createScene2() {
        ui.setBasicScene(addGroceryScene);
        fridge.add(picLabel);
        fridge.setVisible(true);
        addButtonsToFrame();
        addtoGroceryScene();
        fridge.setSize(myPicture.getWidth(), myPicture.getHeight());
        addGroceryScene.add(fridge);
    }


    // MODIFIES: this
    // EFFECTS: has a optionPane box pop up that prompts users to enter specific attributes about the groceries
    public void jpaneDo() throws InputException {

        this.name = JOptionPane.showInputDialog(addGroceryScene, "Enter Grocery Item Name");
        this.quantity = JOptionPane.showInputDialog(addGroceryScene, "Enter Quantity");
        this.price = JOptionPane.showInputDialog(addGroceryScene, "Enter Grocery Item Price");
        this.perishable = JOptionPane.showInputDialog(addGroceryScene,
                "Enter true if perishable, false if not");

        GroceryItem groceryItem = new GroceryItem(name, Double.parseDouble(price));

        inventory.addItemToInventory(groceryItem, Integer.parseInt(quantity), Boolean.valueOf(perishable));

        itemsList.add(new JLabel(name + " | " + quantity + " | " + perishable));


    }


    // REQUIRES: The relevant JButtons to be instantiated and labelled
    // MODIFIES: grocerySButtons collection
    // EFFECTS: adds the corresponding buttons for the menu to the menuButtons collection
    public void addButtonsToFrame() {

        grocerySButtons.add(addGrocery);
        grocerySButtons.add(viewPantry);
        grocerySButtons.add(viewMoney);
        grocerySButtons.add(saveItems);
        grocerySButtons.add(back);


        for (JButton j : grocerySButtons) {
            addGroceryScene.add(j);

        }

        for (JButton j : grocerySButtons) {

            j.addActionListener(this);

        }

    }


    // MODIFIES: addGroceryScene, JFrame
    // EFFECTS: adds an action listener and sets all the buttons at certain vertical distance from each other
    public void addtoGroceryScene() {
        int newYPosition = 100;
        for (JButton j : grocerySButtons) {

            ui.addButton(Color.pink, defaultFont, j, j.getText(), 60,
                    newYPosition, 300, 70);
            newYPosition = newYPosition + 80;

        }

    }


    // MODIFIES: addGroceryScene JFrame
    // EFFECTS: makes the fridge image disappear/ appear and displays all the groceries added to the collection
    public void pantryShow() {
        if (fridge.isVisible() == false) {
            fridge.setVisible(true);
            ui.addLabel(header, "Item | Quantity |  Perishable? ", 25, 390,
                    -50, 400, 40);
            addGroceryScene.add(header);
            header.setVisible(true);
            int newYPosition = 70;
            for (JLabel j : itemsList) {

                j.setBounds(500, newYPosition, 220, 70);
                j.setVisible(true);
                j.setFont(textFont);

                addGroceryScene.add(j);
                newYPosition = newYPosition + 35;


            }


        } else {
            fridge.setVisible(false);


        }

    }

    // REQUIRES: Action Listeners to be added to the buttons and the string = the Action Event command
    // MODIFIES: this
    // EFFECTS: if a button is clicked, performs the corresponding method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Groceries")) {
            try {
                jpaneDo();
            } catch (InputException qu) {
                System.out.println("Please enter a valid quantity/price input");
            }

        }
        if (e.getActionCommand().equals("View Pantry Items")) {
            pantryShow();
        }

        viewAndSaveItems(e);

        if (e.getActionCommand().equals("Back to Pantry")) {
            grocerySummary.dispose();
            addGroceryScene.setVisible(true);
        }
        goToMenu(e);
    }

    private void viewAndSaveItems(ActionEvent e) {
        if (e.getActionCommand().equals("View Summary")) {
            addGroceryScene.setVisible(false);
            grocerySummary.dispose();
            summaryReport();
        }
        if (e.getActionCommand().equals("Save Items")) {

            ToWrite toWrite = new ToWrite();
            toWrite.writing(inventory.viewInventoryWrite(), "./data/Pantry_Items.txt");
            JOptionPane.showMessageDialog(addGroceryScene, "Successfully written to file 'Pantry Items'!");
        }
    }


    // EFFECTS: helper for ActionPerformed, if Return To Menu button is clicked, set current frame's visibiility
    // to false, create a new Menu frame and go to it. Restart the whole program.
    private void goToMenu(ActionEvent e) {
        if (e.getActionCommand().equals("Return To Menu")) {
            addGroceryScene.setVisible(false);
            grocerySummary.setVisible(false);
            MenuUI menuUI = null;
            try {
                menuUI = new MenuUI();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            menuUI.popMenu();
        }
    }

    // MODIFIES: grocerySummary JFrame
    // EFFECTS: creates grocerySummary JFrame which has price and perishable item information. Sets up/ adds
    // all the components and calls on inventory functions to do the calculations.
    private void summaryReport() {
        ui.setBasicScene(grocerySummary);

        totalMQ.setVisible(true);
        ui.addButton(Color.pink, defaultFont, bbutton, "Back to Pantry", 60,
                360, 300, 70);

        ui.addLabel(totalMQ, inventory.sumToString(), 25, 150, -80, 500, 45);
        ui.addLabel(perishableTotal, inventory.perishToString(), 25, 150, -220, 500, 45);
        bbutton.addActionListener(this);
        grocerySummary.add(totalMQ);
        grocerySummary.add(perishableTotal);
        grocerySummary.add(bbutton);

    }


}

