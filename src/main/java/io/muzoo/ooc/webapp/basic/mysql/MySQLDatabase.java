package io.muzoo.ooc.webapp.basic.mysql;

import io.muzoo.ooc.webapp.basic.security.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySQLDatabase {

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
                // 1 : id | 2 : username | 3 : firstname | 4 : surname | 5 : password
                userList.put(set.getString(2),new User(
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5)));
            }
            set.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static boolean addUser(Map<String,String> info) {
        Connection connection = getConnection();
        if (MySQLAuthenticator.validateUsername(info.get("username"),connection)) {
            String[] temp = {info.get("username"),info.get("firstname"),info.get("surname"),info.get("password")};
            MySQLAuthenticator.executeQuery("INSERT INTO users (username,firstname,surname,password) VALUES (?,?,,?,?)",temp,connection);
            return true;
        }
        return false;
    }

    public static boolean editUser(Map<String,String> info) {
        Connection connection = getConnection();
        String[] temp = {info.get("username"),info.get("firstname"),info.get("surname"),info.get("password"),info.get("oldname")};
        if (MySQLAuthenticator.validateEdit(info.get("oldname"),info.get("username"),connection)) {
            MySQLAuthenticator.executeQuery("UPDATE users SET username=?,first=?,surname=?,password=? WHERE username=?",temp,connection);
            return true;
        }
        return false;
    }

    public static boolean removeUser(String username) {
        Connection connection = getConnection();
        String[] temp = {username};

        if (MySQLAuthenticator.userExists(username,connection)) {
            MySQLAuthenticator.executeQuery("DELETE FROM users WHERE username = ?",temp,connection);
            return true;
        }
        return false;
    }

}
