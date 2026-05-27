package server;

import java.sql.*;

public class DatabaseManager {

    private static final String URL =
            "jdbc:mysql://localhost:3306/chatdb";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}