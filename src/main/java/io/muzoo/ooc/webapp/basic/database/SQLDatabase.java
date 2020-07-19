package io.muzoo.ooc.webapp.basic.database;

import io.muzoo.ooc.webapp.basic.security.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SQLDatabase {

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooc_mysql","root","tangentino1152");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Map<String, User> getAllUsers() {
        Map<String,User> userList = new HashMap<>();
        try {
            Connection connection = getConnection();
            ResultSet set = connection.createStatement().executeQuery("SELECT * FROM users");
            while (set.next()) {
                // id | username | firstname | lastname | password
                userList.put(set.getString(2),new User(
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static void main(String[] args) {
        Map<String,User> ans = getAllUsers();
        System.out.println(ans.toString());
    }
}
