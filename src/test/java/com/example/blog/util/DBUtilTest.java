package com.example.blog.util;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DBUtilTest {

    @Test
    public void getConnection_shouldReturnValidConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            assertNotNull(connection);
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            fail("Exception during connection: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Test
        public void getConnection_shouldThrowSQLExceptionWhenDriverNotFound() {
            // Simulate driver not found
            assertThrows(SQLException.class, () -> {
                Connection connection = null;
                // Simulate driver not found by removing the H2 driver from the classpath
                 Class.forName("com.nonexistent.Driver"); // Use nonexistent class
                connection = DBUtil.getConnection();


            });
        }
}