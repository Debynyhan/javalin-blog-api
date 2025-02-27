package com.example.blog;

import java.sql.SQLException;

import com.example.blog.util.DBUtil;
import java.sql.Connection;
import java.util.logging.Level;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(App.class.getName());
   
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DBUtil.getConnection()) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Connection Failed", e);
        }
 }
}
