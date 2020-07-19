package io.muzoo.ooc.webapp.basic.security;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private static Map<String,User> users = new HashMap<>();

    {
        users.put("admin",new User("admin","Administrator","Administrator","12345"));
        users.put("tan",new User("tan","Naran","Kongpithaksilp","abcdefg"));
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public boolean checkIfUserExists(String username) {
        return users.containsKey(username);
    }
}
