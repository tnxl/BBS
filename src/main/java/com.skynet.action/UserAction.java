package com.skynet.action;

import com.skynet.dao.JspConnect;
import com.skynet.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAction {

    private String username;
    private String password;

    private String age;
    private String sex;
    private String phone;

    private Connection connection;
    private PreparedStatement psm;
    private ResultSet resultSet;

    private String sql;

    public UserAction(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.age = user.getAge();
        this.sex = user.getSex();
        this.phone = user.getPhone();
    }

    public boolean login() {
        getConnection();
        try {
            if (resultSet.next()) {
                String pwd = resultSet.getString("password");
                resultSet.close();
                return pwd.equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean register() {
        getConnection();
        try {
            if (!resultSet.next()) {
                sql = "insert into user(username,password,age,sex,phone) value(" +
                        "'" + username + "'," +
                        "'" + password + "'," +
                        "'" + age + "'," +
                        "'" + sex + "'," +
                        "'" + phone + "'" +
                        ")";
                psm = connection.prepareStatement(sql);
                int n = psm.executeUpdate();
                return n != 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private ResultSet getConnection() {
        connection = new JspConnect().getConnection();
        if (connection != null) {
            try {
                if (username != null && password != null) {
                    sql = "select * from user where username= ?";
                    psm = connection.prepareStatement(sql);
                    psm.setString(1, username);
                    resultSet = psm.executeQuery();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
