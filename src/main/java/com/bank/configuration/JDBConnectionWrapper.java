package com.bank.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnectionWrapper {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "123456";
    private static final int TIMEOUT = 5;

    private Connection connection;

    public JDBConnectionWrapper(String schemaName) {
        try {
            connection = DriverManager.getConnection(DB_URL + schemaName + "?useSSL=false", USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean testConnection() throws SQLException {
        return connection.isValid(TIMEOUT);
    }

    public Connection getConnection() {
        return connection;
    }
}
