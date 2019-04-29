package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private DBConnection() {
    }
    private static boolean isConnected = false;
    private static Connection connection;

    public static Connection getConnection() {
        if (isConnected) {
            return connection;
        }
        return null;
    }

    public static Connection establishConnection() throws SQLException {
        String db = "";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            connection = DriverManager.getConnection(url + db, "hr", "hr");
            isConnected = true;
        } catch (SQLException exception) {
            isConnected = false;
            throw exception;
        }
        return connection;
    }
}
