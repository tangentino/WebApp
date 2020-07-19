package io.muzoo.ooc.webapp.basic.mysql;

import java.sql.*;

public class MySQLAuthenticator {

    protected static boolean userExists(String username, Connection connection) {
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet set = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "'");
                if (set.next()) {
                    set.close();
                    return true;
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    protected static boolean validateUsername(String username, Connection connection) {
        boolean checkWhiteSpace = username.trim().length() > 0; // if username isnt just spaces
        return !(userExists(username,connection)) && checkWhiteSpace;
    }

    protected static boolean validateEdit(String currentName, String newName, Connection connection) {
        if (!newName.equals(currentName)) {
            return validateUsername(newName,connection);
        }
        return true;
    }

    protected static void executeQuery(String query, String[] arr, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < arr.length; i++) {
                preparedStatement.setString(i+1,arr[i]);
            }
            preparedStatement.execute();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
