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

    static JLabel jLabelTwo;

    static JButton jButtonTwo;

    static JTextField jTextFieldTwo;

    static JLabel jLabelThree;

    static JButton jButtonThree;

    static JTextField jTextFieldThree;

    private static FileInput fi;

    // only needs to be called once
    public static void initUI()
    {
        fi = new FileInput();
        // create a new frame to store text field and button
        jFrame = new JFrame("Input");

        // create a label to display text
        jLabel = new JLabel("enter info");

        // create a new button
        jButton = new JButton("submit info");

        // create an object of current class
        UIInputHandler i = new UIInputHandler();

        // addActionListener to input button
        // allows us to listen to the status of the input button
        jButton.addActionListener(i);

        // another input button for file name
        jButtonTwo = new JButton("submit path");
        jButtonTwo.addActionListener(i);

        // another input button for requests (depositing, etc..)
        jButtonThree = new JButton("submit request");
        jButtonThree.addActionListener(i);

        // another label for file input
        jLabelTwo = new JLabel("enter path");

        //another label for requests
        jLabelThree = new JLabel("enter request");

        // create an object of JTextField with 16 columns
        jTextField = new JTextField(16);
        jTextFieldTwo = new JTextField(16);
        jTextFieldThree = new JTextField(16);

        // create a panel to add buttons and text field
        // this is the panel that will be showed to the user
        JPanel jPanel = new JPanel();

        // add buttons and text field to panel
        jPanel.add(jTextField);
        jPanel.add(jButton);
        jPanel.add(jLabel);
        jPanel.add(jTextFieldTwo);
        jPanel.add(jButtonTwo);
        jPanel.add(jLabelTwo);
        jPanel.add(jTextFieldThree);
        jPanel.add(jButtonThree);
        jPanel.add(jLabelThree);

        // add panel to frame
        jFrame.add(jPanel);

        // set the size of frame
        jFrame.setSize(500, 500);

        jFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // button clicked status
        String s = e.getActionCommand();
        // if button is clicked
        switch (s) {
            case "submit info" -> {
                if(jTextField.getText().startsWith("pep")) {
                    String request = jTextField.getText();
                    BankRequestHandler.bankAccCreationHandler(request);
                }
                else {
                    System.out.println("not a valid command. this is used for creating accounts.");
                    System.out.println("valid command: pep firstName lastName accountBalance accountType");
                }
            }
            case "submit path" -> {
                String filePath = "";
                if (!jTextFieldTwo.getText().isEmpty()) {
                    if (jTextFieldTwo.getText().equalsIgnoreCase("default")) {
                        filePath = "/Users/pep233/IdeaProjects/APCS-A_2023_JialeYu/src/main/java/org/APCSA2023/FinalProject/InputFile";
                    } else {
                        filePath = jTextFieldTwo.getText().toLowerCase();
                    }
                    Constants.FILE_PATH = filePath;
                    fi.processInputFile();
                    fi.process();
                } else {
                    System.out.println("path is empty. 'default' to access default path");
                }
            }
            case "submit request" -> {
                if (jTextFieldThree.getText().equals("stop")) Tester.end();
                else if (jTextFieldThree.getText().equals("show")) FileOutput.printProcessedList();
                else if (jTextFieldThree.getText().equals("output")) FileOutput.outputToFile();
                else if (jTextFieldThree.getText().equals("sort balance")) BankHelper.sortByBalance();
                else if (jTextFieldThree.getText().equals("sort number")) BankHelper.sortByAccountNum();
                else if (jTextFieldThree.getText().startsWith("pep")) {
                    String request = jTextFieldThree.getText();
                    BankRequestHandler.bankRequestHandler(request);
                }
                else if (jTextFieldThree.getText().equals("clear")) {
                    Constants.PROCESSED_OBJECTS.clear();
                    Constants.PRE_PROCESSED_STRINGS.clear();
                    Constants.ACCOUNT_NUMBER = 0;
                }
                else {
                    System.out.println("not a valid command");
                }
            }
        }
    }
}
