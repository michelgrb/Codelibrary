package com.myproject;

import javax.swing.*;

public class ListObject {
    private DefaultListModel lm1 = new DefaultListModel();
    private DefaultListModel lm2 = new DefaultListModel();

    public ListObject(DefaultListModel lm1, DefaultListModel lm2){
        this.lm1 = lm1;
        this.lm2 = lm2;
    }

    public DefaultListModel getPK(){
        return this.lm1;
    }

    public DefaultListModel gettitle(){
        return this.lm2;
    }

}
