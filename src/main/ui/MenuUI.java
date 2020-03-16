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

    public MenuUI() throws IOException {
    }


    public void addButtonsToFrame() {
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


        frameScene.add(welcomeLabel);
    }

    public void addToInitialScene() {
        int newYPosition = 176;
        for (JButton j : menuButtons) {

            ui.addButton(Color.green, defaultFont, j, j.getText(), 400,
                    newYPosition, 300, 45);
            newYPosition = newYPosition + 55;

        }
        for (JButton j : menuButtons) {

            j.addActionListener(this);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Quit Application")) {


            System.exit(0);
        } else if (e.getActionCommand().equals("Go To My Pantry")) {

            // frameScene.setVisible(false);

            try {
                ags.createScene2();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}


