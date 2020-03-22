package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MenuUI implements ActionListener {
    java.awt.Font defaultFont = new java.awt.Font("Segoe UI Light", Font.PLAIN, 30);
    UserInterface ui = new UserInterface();
    JLabel welcomeLabel = new JLabel();
    JFrame frameScene = new JFrame();
    JButton viewPantry = new JButton("Go To My Pantry");
    JButton saveItems = new JButton("Save Items");
    JButton quitB = new JButton("Quit Application");
    ArrayList<JButton> menuButtons = new ArrayList<>();
    AddGroceryScene ags = new AddGroceryScene();




    // EFFECTS: throws IOException down the hierarchy
    public MenuUI() throws IOException {
    }


    // REQUIRES: The relevant JButtons to be instantiated and labelled
    // MODIFIES: frameScene JFrame
    // EFFECTS: adds the corresponding buttons for the menu to the menuButtons collection
    public void addButtonsToFrame() {
        menuButtons.add(viewPantry);
        menuButtons.add(quitB);
        for (JButton j : menuButtons) {
            frameScene.add(j);

        }
    }



    // MODIFIES: frameScene JFrame
    // EFFECTS: sets up the scene and adds all the relevant components to the JFrame
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

    // MODIFIES: menuButtons
    // EFFECTS: adds an action listener and sets all the buttons at certain vertical distance from each other
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
    // REQUIRES: Action Listeners to be added to the buttons and the string = the Action Event command
    // MODIFIES: this
    // EFFECTS: if quit app is clicked, quit app, if go to pantry is clicked, go to the next JFrame (pantry scene)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Quit Application")) {
            System.exit(0);
        } else if (e.getActionCommand().equals("Go To My Pantry")) {
            ags.createScene2();
        }
    }


}


