package io.muzoo.ooc.webapp.basic.security;

import io.muzoo.ooc.webapp.basic.mysql.MySQLDatabase;

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
}
