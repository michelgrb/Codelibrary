package com.myproject;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class DBClass {
    String conString = "jdbc:mysql://localhost:3306/codelibrary";
    String username = "root";
    String password = "";

    public void addNewField(){
        DefaultListModel dm = new DefaultListModel();
        String sql = "INSERT INTO codedata (title, text) VALUES ('TITLE', 'TEXT')";
        try {
            // load and register JDBC driver for MySQ
            Connection con = DriverManager.getConnection(conString, username, password);
            Statement s = con.prepareStatement(sql);
            s.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTitle(String content, String pk) {
        DefaultListModel dm = new DefaultListModel();
        String sql = "UPDATE codedata SET title = '" + content + "' WHERE PK = '" + pk + "'";
        try {
            // load and register JDBC driver for MySQ
            Connection con = DriverManager.getConnection(conString, username, password);
            Statement s = con.prepareStatement(sql);
            s.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(String pk) {
        DefaultListModel dm = new DefaultListModel();
        String sql = "DELETE FROM codedata WHERE PK = '"+ pk +"'";
        try {
            // load and register JDBC driver for MySQ
            Connection con = DriverManager.getConnection(conString, username, password);
            Statement s = con.prepareStatement(sql);
            s.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(String content, String pk) {
        DefaultListModel dm = new DefaultListModel();
        String sql = "UPDATE codedata SET text = '" + content + "' WHERE PK = '" + pk + "'";
        try {
            // load and register JDBC driver for MySQ
            Connection con = DriverManager.getConnection(conString, username, password);
            Statement s = con.prepareStatement(sql);
            s.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ListObject searchdata(String search){
        DefaultListModel dm = new DefaultListModel();
        DefaultListModel dm1 = new DefaultListModel();

        ArrayList<ListObject> dms= new ArrayList<ListObject>();

        String sql = null;
        if(search.equals("")){
            sql = "SELECT PK, title from codedata";
        } else {
            sql = "SELECT PK, title from codedata WHERE title LIKE '%" +search+ "%' OR text LIKE '%" +search+ "%'";
        }

        try{
            // load and register JDBC driver for MySQ
            Connection con = DriverManager.getConnection(conString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = null;

            try {
                rs = s.executeQuery(sql);
                while(rs.next()){

                    String name = rs.getString("title");
                    String pk =  rs.getString("PK");
                    dm.addElement(pk);
                    dm1.addElement(name);
                }
                ListObject row = new ListObject(dm, dm1);
                con.close();
                return row;
            } catch(Exception ex) {
                System.out.println(ex);
                con.close();
                return null;
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public String getText(String pk){
        String sql = "SELECT text from codedata WHERE PK = '" + pk + "'";
        String text = "";

        try {
            // load and register JDBC driver for MySQ
            Connection con = DriverManager.getConnection(conString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()) {
                text = (String) rs.getString(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}