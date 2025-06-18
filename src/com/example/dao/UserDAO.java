package com.example.dao;

import java.sql.*;

public class UserDAO {
    public static String getUser(String username) {
        String userData = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "");
            Statement stmt = conn.createStatement();

             
            String query = "SELECT * FROM users WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                userData = rs.getString("username") + " - " + rs.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }
}