package com.maxkavun.http.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final  class ConnectionManager {

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";


    private  ConnectionManager() {
    }

    public static Connection get() {
        try {
            System.out.println("Trying to connect to the database...");
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USER_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }
}
