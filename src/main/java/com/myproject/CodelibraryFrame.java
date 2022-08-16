package com.myproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodelibraryFrame extends JFrame {
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JFormattedTextField sadFormattedTextField;
    private JTextPane textPane1;
    private JButton searchButton;
    private JList list1;
    public CodelibraryFrame(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               DefaultListModel dm = new DBClass().searchdata(sadFormattedTextField.getText());
               list1.setModel(dm);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new CodelibraryFrame("Frame");
        frame.setVisible(true);
    }
}
