/*
 * Copyright (C) 2019 AyShe2
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private DBConnection() {
    }
    private static boolean isConnected = false;
    private static Connection connection;

    public static Connection getConnection() {
        return isConnected ? connection : null;
    }

    public static Connection establishConnection(String username, String password)
            throws SQLException {
        String connString = "jdbc:oracle:thin:@localhost:1521:XE";
        connection = DriverManager.getConnection(connString, username, password);
        isConnected = connection.isValid(0);
        return connection;
    }
}
