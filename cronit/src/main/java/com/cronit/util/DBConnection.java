package com.cronit.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    // HikariCP configuration for connection pooling and keepalive
    private static HikariDataSource dataSource; 

    static {
        try {
            HikariConfig config =  new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://localhost:3306/cronit");
            config.setUsername("root");
            config.setPassword("SousouNoFrieren.#6950");
            config.setMaximumPoolSize(10);       // max concurrent connections
            config.setMinimumIdle(2);           // keep a couple ready
            config.setIdleTimeout(300000);      // 5 minutes
            config.setMaxLifetime(1800000);     // 30 minutes (before recycling connections)
            config.setConnectionTimeout(30000); // 30 seconds max wait

            dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing HikariCP db connection pool", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Database connection successful!");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }
        return false;
    }

    public static void closePool() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    } 
}
