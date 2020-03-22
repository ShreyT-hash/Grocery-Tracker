package ui;

import javax.swing.*;
import java.awt.*;


public class UserInterface  {

    // Important fields and constants
    private int jframeWidth = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) + 200;
    private int jframeHeight = (Toolkit.getDefaultToolkit().getScreenSize().height / 2) + 200;
    JFrame jframe = new JFrame();//creating instance of JFrame


    // MODIFIES: this
    // EFFECTS: sets the parameters and aesthetics for JButtons
    public void addButton(Color buttonColor, Font buttonFont, JButton newjbutton, String btitle,
                          int bposX, int bposY, int width, int height) {
        newjbutton.setText(btitle);
        newjbutton.setFont(buttonFont);
        newjbutton.setBounds(JLabel.CENTER + bposX, JLabel.CENTER + bposY, width, height);
        newjbutton.setVisible(true);
        newjbutton.setBackground(buttonColor);
        newjbutton.setActionCommand(btitle);
    }


    // MODIFIES: this
    // EFFECTS: sets the parameters and aesthetics for JLabels
    public void addLabel(JLabel newjLabel, String caption, int fsize, int bx, int by, int width, int height) {
        newjLabel.setOpaque(false);
        newjLabel.setText(caption);
        newjLabel.setForeground(Color.BLACK);
        newjLabel.setFont(new Font("Segoe UI Light", (Font.PLAIN), fsize));
        newjLabel.setVisible(true);
        newjLabel.setBounds(JLabel.CENTER + bx, JLabel.CENTER - by, width, height); // 900, 500

    }

    public int getJframeHeight() {
        return jframeHeight;
    }

    public int getJframeWidth() {
        return jframeWidth;
    }


}