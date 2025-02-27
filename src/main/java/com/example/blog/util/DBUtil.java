package com.example.blog.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database utility class for obtaining connections.
 */
public class DBUtil {
    private static final Logger logger = Logger.getLogger(DBUtil.class.getName());
    private static HikariDataSource dataSource;

    // Static block to initialize the connection pool
    static {
        try {
            Properties props = new Properties();
            try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
                if (input == null) {
                    logger.log(Level.SEVERE, "Unable to find application.properties");
                    throw new RuntimeException("Unable to find application.properties");
                }
                props.load(input);
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Error loading application.properties", ex);
                throw new RuntimeException("Could not load application.properties", ex);
            }

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(props.getProperty("db.jdbc.url"));
            config.setUsername(props.getProperty("db.username"));
            config.setPassword(props.getProperty("db.password"));
            config.setMaximumPoolSize(Integer.parseInt(props.getProperty("db.pool.maximumPoolSize")));
            config.setMinimumIdle(Integer.parseInt(props.getProperty("db.pool.minimumIdle")));
            config.setIdleTimeout(Long.parseLong(props.getProperty("db.pool.idleTimeout")));
            config.setMaxLifetime(Long.parseLong(props.getProperty("db.pool.maxLifetime")));
            config.setConnectionTimeout(Long.parseLong(props.getProperty("db.pool.connectionTimeout")));

            dataSource = new HikariDataSource(config);
            logger.info("Database connection pool initialized successfully");

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error initializing database connection pool", e);
            throw new RuntimeException("Could not initialize database connection pool", e);
        }
    }

    /**
     * Get a connection from the connection pool.
     *
     * @return A pooled connection
     * @throws SQLException If a connection cannot be retrieved
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}