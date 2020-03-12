package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface  {

    // Important fields and constants
    private int jframeWidth = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) + 200;
    private int jframeHeight = (Toolkit.getDefaultToolkit().getScreenSize().height / 2) + 200;
    JFrame jframe = new JFrame();//creating instance of JFrame


    public void createInitialScene() {
        jframe.setSize(jframeWidth, jframeHeight);//400 width and 500 height
        jframe.setLayout(null);//using no layout managers
        jframe.setVisible(true);//making the frame visible
    }

    public void addButton(Color buttonColor, Font buttonFont, JButton newjbutton, String btitle,
                          int bposX, int bposY, int width, int height) {
        newjbutton.setText(btitle);
        newjbutton.setFont(buttonFont);
        newjbutton.setBounds(JLabel.CENTER + bposX, JLabel.CENTER + bposY, width, height);
        newjbutton.setVisible(true);
        newjbutton.setBackground(buttonColor);
        newjbutton.setActionCommand(btitle);
    }

    public void addLabel(JLabel newjLabel, String caption, int fsize, int bx, int by, int width, int height) {
        newjLabel.setOpaque(false);
        newjLabel.setText(caption);
        newjLabel.setForeground(Color.BLACK);
        newjLabel.setFont(new Font("Segoe UI Light", (Font.PLAIN), fsize));
        newjLabel.setVisible(true);
        newjLabel.setBounds(JLabel.CENTER + bx, JLabel.CENTER - by, width, height); // 900, 500

    }

    public void addTextField(JTextField tft, int width, int height, int bx, int by) {
        tft.setBounds(bx, by, width, height);

    }

    public int getJframeHeight() {
        return jframeHeight;
    }

    public int getJframeWidth() {
        return jframeWidth;
    }


}