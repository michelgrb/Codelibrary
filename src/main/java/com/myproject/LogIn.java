package com.myproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogIn extends JFrame {
    private JPasswordField passwordField1;
    private JButton logInButton;
    private JFormattedTextField formattedTextField1;
    private JPasswordField passwordField2;
    private JPanel mainPanel;
    private JButton createAnAccountButton;
    private JButton logInWithExistingAccountButton;

    public LogIn(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        createAnAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logInWithExistingAccountButton.setVisible(true);
                createAnAccountButton.setVisible(false);
                passwordField2.setVisible(true);
                logInButton.setText("Create Account");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new LogIn("LogIn");
        frame.setVisible(true);
    }
}


