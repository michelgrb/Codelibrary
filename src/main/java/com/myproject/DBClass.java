package com.myproject;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Collections;

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
            sql = "SELECT title from codelibary WHERE title LIKE '%" +search+ "%' OR text LIKE '%" +search+ "%'";
        }

        try{
            // load and register JDBC driver for MySQ
            Connection con = DriverManager.getConnection(conString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = null;

            try {
                rs = s.executeQuery(sql);
                while(rs.next()){
                    String name = rs.getString(1);
                    dm.addElement(name);
                }
            } catch(Exception ex) {
                return dm;
            }
            return dm;

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    public String getText(String title){
        String sql = "SELECT text from codelibary WHERE title = '" + title + "'";
        String text = "";

        try {
            // load and register JDBC driver for MySQ
            Connection con = DriverManager.getConnection(conString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()) {
                text = (String) rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}