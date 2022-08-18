package com.myproject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;

public class CodelibraryFrame extends JFrame {
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JFormattedTextField sadFormattedTextField;
    private JTextPane textPane1;
    private JButton searchButton;
    private JList list1;
    private JList list2;
    private JTextPane textPane2;

    public void refresh(){
        ListObject dm = new DBClass().searchdata(sadFormattedTextField.getText());
        list1.clearSelection();
        list1.setModel(dm.gettitle());

        list2.clearSelection();
        list2.setModel(dm.getPK());

    }

    public void delete(String pk){
        new DBClass().deleteData(pk);
    }

    public void updateTitle(){
        new DBClass().updateTitle(textPane1.getText(), textPane2.getText());
    }

    public void updateContent(){
        new DBClass().updateData(textArea1.getText(), textPane2.getText());
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
                textPane2.setText(list2.getModel().getElementAt(list1.getSelectedIndex()).toString());
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
    sadFormattedTextField.addComponentListener(new ComponentAdapter() { } );
        textPane1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                updateTitle();
            }
        });
        textArea1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                updateContent();
            }
        });
        textPane1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                refresh();
            }
        });
        textArea1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                refresh();
            }
        });

        list1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyChar() == '\u0008' || e.getKeyChar() == '\u007F'){
                    delete(textPane2.getText());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new CodelibraryFrame("Frame");
        frame.setVisible(true);
    }
}
