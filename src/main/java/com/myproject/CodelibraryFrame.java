package com.myproject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class CodelibraryFrame extends JFrame {
    private JPanel mainPanel;
    private JTextArea dataContent;
    private JFormattedTextField searchField;
    private JTextPane dataTitle;
    private JButton searchButton;
    private JList listDataSetsTitles;
    private JList listDataSetsPKs;
    private JTextPane primaryKeyForDataset;
    private JButton addNewDataset;

    public void refresh(){
        ListObject dm = new DBClass().searchdata(searchField.getText());
        listDataSetsTitles.clearSelection();
        listDataSetsTitles.setModel(dm.gettitle());

        listDataSetsPKs.clearSelection();
        listDataSetsPKs.setModel(dm.getPK());
    }

    public void delete(String pk){
        new DBClass().deleteData(pk);
        dataContent.setText("");
        dataTitle.setText("");
    }

    public void updateTitle(){
        new DBClass().updateTitle(dataTitle.getText().toString(), primaryKeyForDataset.getText());
    }

    public void updateContent(){
        new DBClass().updateData(dataContent.getText().toString(), primaryKeyForDataset.getText());
    }

    public void addContent() {
        new DBClass().addNewField();
    }

    public CodelibraryFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        refresh();

        listDataSetsTitles.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String title = "";
                String pk = "";
                try {
                    title = listDataSetsTitles.getSelectedValue().toString();
                    pk = primaryKeyForDataset.getText();
                } catch (Exception ex1) {
                    return;
                }
                dataTitle.setText(title);
                dataContent.setText(new DBClass().getText(pk));
                primaryKeyForDataset.setText(listDataSetsPKs.getModel().getElementAt(listDataSetsTitles.getSelectedIndex()).toString());
            }
        });
    mainPanel.addComponentListener(new ComponentAdapter() { } );
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                refresh();
            }
        });
    searchField.addComponentListener(new ComponentAdapter() { } );
        dataTitle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                updateTitle();
            }
        });
        dataContent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                updateContent();
            }
        });
        dataTitle.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                refresh();
            }
        });
        dataContent.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                refresh();
            }
        });

        listDataSetsTitles.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar() == '\u0008' || e.getKeyChar() == '\u007F'){
                    delete(primaryKeyForDataset.getText());
                    refresh();
                }
            }
        });
        addNewDataset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContent();
                refresh();
            }
        });
        dataContent.addFocusListener(new FocusAdapter() {
        });
        dataTitle.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                refresh();
                super.focusLost(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new CodelibraryFrame("Frame");
        frame.setVisible(true);
    }
}
