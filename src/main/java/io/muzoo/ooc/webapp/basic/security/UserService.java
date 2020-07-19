package io.muzoo.ooc.webapp.basic.security;

import io.muzoo.ooc.webapp.basic.mysql.MySQLDatabase;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private static Map<String,User> users = MySQLDatabase.getAllUsers();

    public User findByUsername(String username) {
        return users.get(username);
    }

    public boolean checkIfUserExists(String username) {
        return users.containsKey(username);
    }

    private String encryptPassword(String password) {
        return BCrypt.hashpw(password,BCrypt.gensalt(12));
    }

    public boolean addUser(Map<String,String> info) {
        String password = info.get("password");
        info.put("password",encryptPassword(password));
        if (MySQLDatabase.addUser(info)) {
            users = MySQLDatabase.getAllUsers();
            return true;
        }
        return false;
    }

    public boolean editUser(Map<String,String> info) {
        String password = info.get("password");
        info.put("password",encryptPassword(password));
        if (MySQLDatabase.editUser(info)) {
            users = MySQLDatabase.getAllUsers();
            return true;
        }
        return false;
    }
}
