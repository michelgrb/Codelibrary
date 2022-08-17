package com.myproject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class CodelibraryFrame extends JFrame {
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JFormattedTextField sadFormattedTextField;
    private JTextPane textPane1;
    private JButton searchButton;
    private JList list1;

    public void refresh(){
        DefaultListModel dm = new DBClass().searchdata(sadFormattedTextField.getText());
        list1.clearSelection();
        list1.setModel(dm);
    }

    public CodelibraryFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        refresh();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String title = "";
                try {
                    title = list1.getSelectedValue().toString();
                } catch (Exception ex1) {
                    return;
                }
                textPane1.setText(title);
                textArea1.setText(new DBClass().getText(title));
            }
        });
    mainPanel.addComponentListener(new ComponentAdapter() { } );
        sadFormattedTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                refresh();
            }
        });
    sadFormattedTextField.addComponentListener(new ComponentAdapter() { } );}

    public static void main(String[] args) {
        JFrame frame = new CodelibraryFrame("Frame");
        frame.setVisible(true);
    }
}
