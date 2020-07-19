package io.muzoo.ooc.webapp.basic.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAuthentication {

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
    
}
