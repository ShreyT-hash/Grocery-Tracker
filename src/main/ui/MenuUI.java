package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MenuUI implements ActionListener {
    java.awt.Font defaultFont = new java.awt.Font("Segoe UI Light", Font.PLAIN, 30);
    UserInterface ui = new UserInterface();
    JLabel welcomeLabel = new JLabel();
    JFrame frameScene = new JFrame();
    JButton addGroceries = new JButton("Add Groceries");
    JButton viewPantry = new JButton("Go To My Pantry");
    JButton viewMoney = new JButton("View Money");
    JButton viewRecipes = new JButton("View Recipes");
    JButton loadItems = new JButton("Load Items");
    JButton saveItems = new JButton("Save Items");
    JButton quitB = new JButton("Quit Application");
    ArrayList<JButton> menuButtons = new ArrayList<>();
    AddGroceryScene ags = new AddGroceryScene();



    public void addButtonsToFrame() {
       // menuButtons.add(addGroceries);
       // menuButtons.add(viewMoney);
        menuButtons.add(viewPantry);
        menuButtons.add(viewRecipes);
        menuButtons.add(loadItems);
        menuButtons.add(saveItems);
        menuButtons.add(quitB);
        for (JButton j : menuButtons) {
            frameScene.add(j);

        }

    }

    public void popMenu() {
        frameScene.setSize(ui.getJframeWidth(), ui.getJframeHeight());//400 width and 500 height
        frameScene.setLayout(null);//using no layout managers
        frameScene.setVisible(true);//making the frame visible

        ui.addLabel(welcomeLabel, "Welcome To Your Very Own Grocery Manager",
                40, 185, 130, 900, 500);

        addButtonsToFrame();
        addToInitialScene();

//        frameScene.add(addGroceries);
//        frameScene.add(viewPantry);
//        frameScene.add(viewMoney);
//        frameScene.add(viewRecipes);
//        frameScene.add(loadItems);
//        frameScene.add(saveItems);
//        frameScene.add(quitB);
//
        frameScene.add(welcomeLabel);
    }

    public void addToInitialScene() {
        int newYPOS = 176;
        for (JButton j : menuButtons) {

            ui.addButton(Color.green, defaultFont, j, j.getText(), 400,
                    newYPOS, 300, 45);
            newYPOS = newYPOS + 55;

        }
        for (JButton j : menuButtons) {

            j.addActionListener(this);

        }

//        ui.addButton(Color.green, defaultFont, addGroceries, "Add Groceries", 400,
//                200, 300, 45);
//
//        ui.addButton(Color.green, defaultFont, viewPantry, "View Pantry", 400,
//                250, 300, 45);
//        ui.addButton(Color.green, defaultFont, viewMoney, "View Money", 400,
//                300, 300, 45);
//
//        ui.addButton(Color.green, defaultFont, viewRecipes, "View Recipes", 400,
//                350, 300, 45);
//        ui.addButton(Color.green, defaultFont, loadItems, "Load Items", 400,
//                400, 300, 45);
//
//        ui.addButton(Color.green, defaultFont, saveItems, "Save Items", 400,
//                450, 300, 45);
//
//        ui.addButton(Color.green, defaultFont, quitB, "Quit Application", 400,
//                500, 300, 45);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Quit Application")) {


            System.exit(0);
        } else if (e.getActionCommand().equals("Go To My Pantry")) {

            frameScene.setVisible(false);

            try {
                ags.createScene2();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {

        }
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getActionCommand().equals("Exit Application")) {
//
//            System.exit(0);
//        } else if (e.getActionCommand().equals("View Pantry")) {
//            frameScene.setVisible(false);
//
//        } else if (e.getActionCommand().equals("View Money")) {
//            frameScene.setVisible(false);
//
//        } else if (e.getActionCommand().equals("View Recipes")) {
//            frameScene.setVisible(false);
//
//        } else if (e.getActionCommand().equals("Load Items")) {
//            frameScene.setVisible(false);
//
//        } else if (e.getActionCommand().equals("Save Items")) {
//            frameScene.setVisible(false);
//        }
//    }
}


