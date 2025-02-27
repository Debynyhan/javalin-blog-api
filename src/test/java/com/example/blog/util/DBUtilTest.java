package com.example.blog.util;


import com.example.blog.util.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for DBUtil.
 * Assumes a test environment is configured and reachable.
 */
class DBUtilTest {

    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        // Acquire a connection before each test
        connection = DBUtil.getConnection();
    }




    @Test
    public void executeQuery_validQuery_shouldReturnResultSet() {
        String query = "SELECT 1 AS test"; // Simple query to test connection
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            assertTrue(resultSet.next(), "Result set should have at least one row");
            assertEquals(1, resultSet.getInt("test"), "Expected value should be 1");
        } catch (SQLException e) {
            fail("Failed to execute query: " + e.getMessage());
        }
    }


  
}
