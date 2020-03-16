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

public class AddGroceryScene implements ActionListener {
    // FONT CONSTANTS
    java.awt.Font defaultFont = new java.awt.Font("Segoe UI Light", Font.PLAIN, 30);
    java.awt.Font textFont = new java.awt.Font("Segoe UI Light", Font.PLAIN, 20);

    // ArrayLists to store JSwing components
    ArrayList<JButton> grocerySButtons = new ArrayList<>();
    ArrayList<JLabel> itemsList = new ArrayList<>();


    // To create fridge image
    String imagePath = "C:\\Users\\shrey\\Desktop\\fridge.png";
    BufferedImage myPicture = ImageIO.read(new File(imagePath));

    // Instantiating and declaring JComponents
    JPanel fridge = new JPanel();
    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    JFrame addGroceryScene = new JFrame();
    JFrame grocerySummary = new JFrame();
    JButton addGrocery = new JButton("Add Groceries");
    JButton viewPantry = new JButton("View Pantry Items");
    JButton viewMoney = new JButton("View Summary");
    JButton back = new JButton("Return To Menu");
    JButton bbutton = new JButton();
    // Instantiating and declraing model classes to use
    Inventory inventory = new Inventory();
    UserInterface ui = new UserInterface();

    JLabel totalMQ = new JLabel();
    JLabel perishableTotal = new JLabel();


    String name;
    String quantity;
    String price;
    String perishable;
    //   MenuUI menuUI = new MenuUI();

    public AddGroceryScene() throws IOException {

    }


    public void createScene2() throws IOException {
        //      menuUI.getFrameScene().setVisible(false);
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

    // What to do when add groceries button is clicked
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
        grocerySButtons.add(back);


        for (JButton j : grocerySButtons) {
            addGroceryScene.add(j);

        }

    }

    public void addtoGroceryScene() {
        int newYPosition = 180;
        for (JButton j : grocerySButtons) {

            ui.addButton(Color.pink, defaultFont, j, j.getText(), 60,
                    newYPosition, 300, 70);
            newYPosition = newYPosition + 80;

        }
        for (JButton j : grocerySButtons) {

            j.addActionListener(this);

        }
    }


    public void pantryShow() {
        if (fridge.isVisible() == false) {
            fridge.setVisible(true);

            int newYPosition = 70;
            for (JLabel j : itemsList) {

                j.setBounds(500, newYPosition, 220, 70);
                j.setVisible(true);
                j.setFont(textFont);

                addGroceryScene.add(j);
                newYPosition = newYPosition + 35;


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
        menuAction(e);
        if (e.getActionCommand().equals("View Summary")) {

            addGroceryScene.setVisible(false);
            grocerySummary.dispose();
            summaryReport();

        }
        if (e.getActionCommand().equals("Back to Pantry")) {

            grocerySummary.dispose();
            addGroceryScene.setVisible(true);


        }
    }

    private void menuAction(ActionEvent e) {
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

    private void summaryReport() {
        grocerySummary.setSize(ui.getJframeWidth(), ui.getJframeHeight());//400 width and 500 height
        grocerySummary.setLayout(null);//using no layout managers
        grocerySummary.setVisible(true);


        String totalMQRep = "Total money spent this grocery run is: " + inventory.totalPrice() + "$";
        String perishRep = "Number of perishable items in the fridge: " + inventory.perishableCount();
        totalMQ.setVisible(true);
        ui.addButton(Color.pink, defaultFont, bbutton, "Back to Pantry", 60,
                360, 300, 70);

        ui.addLabel(totalMQ, totalMQRep, 25, 150, -80, 500, 45);
        ui.addLabel(perishableTotal, perishRep, 25, 150, -220, 500, 45);
        grocerySummary.add(totalMQ);
        grocerySummary.add(perishableTotal);
        grocerySummary.add(bbutton);
        bbutton.addActionListener(this);
        // ui.addLabel(perishableTotal, perishRep, );


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
}

