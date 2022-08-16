package com.myproject;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DBClass {
    String conString = "jdbc:mysql://localhost:3306/codelibary";

    String username = "root";
    String password = "";

    public DefaultListModel searchdata(String search){
        DefaultListModel dm = new DefaultListModel();

        String sql = null;
        if(search.equals("")){
            sql = "SELECT title from codelibary";
        } else {
            sql = "SELECT title from codelibary WHERE title like %" +search+ "% OR text like %" +search+ "%";
        }

        try{
            // load and register JDBC driver for MySQ
            Connection con = DriverManager.getConnection(conString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                String name = rs.getString(1);
                dm.addElement(name);
            }
            return dm;

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;


    }
}