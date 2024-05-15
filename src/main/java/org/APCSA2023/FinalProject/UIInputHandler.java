package org.APCSA2023.FinalProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIInputHandler extends JFrame implements ActionListener {

    // JTextField
    static JTextField jTextField;

    // JFrame
    static JFrame jFrame;

    // JButton
    static JButton jButton;

    // label to display text
    static JLabel jLabel;

    // only needs to be called once
    public static void initUI()
    {
        // create a new frame to store text field and button
        jFrame = new JFrame("Input");

        // create a label to display text
        jLabel = new JLabel("Input: None");

        // create a new button
        jButton = new JButton("Submit");

        // create an object of current class
        UIInputHandler i = new UIInputHandler();

        // addActionListener to button
        // allows us to listen to the status of the button
        jButton.addActionListener(i);

        // create an object of JTextField with 16 columns
        jTextField = new JTextField(16);

        // create a panel to add buttons and text field
        // this is the panel that will be showed to the user
        JPanel jPanel = new JPanel();

        // add buttons and text field to panel
        jPanel.add(jTextField);
        jPanel.add(jButton);
        jPanel.add(jLabel);

        // add panel to frame
        jFrame.add(jPanel);

        // set the size of frame
        jFrame.setSize(300, 300);

        jFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // button clicked status
        String s = e.getActionCommand();
        // if button is clicked
        if (s.equals("Submit")) {
            if(jTextField.getText().equals("stop")) Tester.end();
            else {
                System.out.println(jTextField.getText());
                // set the text of the label to the text of the field
                jLabel.setText(jTextField.getText());
                // set the text of field to blank
                jTextField.setText("");
            }
        }
    }
}
