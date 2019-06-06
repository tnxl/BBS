package com.skynet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JspConnect {

    private Connection connection;

    private String root = "root";
    private String pass = "1234";
    private String url = "jdbc:mysql://localhost:3306/lyb?serverTimezone=UTC";

    public Connection getConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,root,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
