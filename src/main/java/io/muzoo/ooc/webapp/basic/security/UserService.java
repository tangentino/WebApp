package io.muzoo.ooc.webapp.basic.security;

import io.muzoo.ooc.webapp.basic.mysql.MySQLDatabase;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Collection;
import java.util.Map;

public class UserService {

    private Map<String,User> users = MySQLDatabase.getAllUsers();

    private void updateUsers() {
        users = MySQLDatabase.getAllUsers();
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public boolean checkIfUserExists(String username) {
        return users.containsKey(username);
    }

    public Collection<User> getUserList(){
        return users.values();
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
            updateUsers();
            return true;
        }
        return false;
    }

    public void removeUser(String username) {
        if (MySQLDatabase.removeUser(username)) {
            updateUsers();
        }
    }

    public boolean checkPassword(String username, String password) {
        User user = findByUsername(username);
        if (user != null) {
            return BCrypt.checkpw(password,user.getPassword());
        }
        return false;
    }

}
