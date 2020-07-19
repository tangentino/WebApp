package io.muzoo.ooc.webapp.basic.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SecurityService {

    private UserService userService;

    public void setUserService(UserService userSerivce) {
        this.userService = userSerivce;
    }

    public String getCurrentUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object usernameObject = session.getAttribute("username");
        return (String) usernameObject;

    }

    public User getCurrentUser(HttpServletRequest request) {
        return userService.findByUsername(request.getParameter("username"));
    }

    public boolean isAuthorized(HttpServletRequest request) {
        String username = getCurrentUsername(request);
        return (userService.checkIfUserExists(username));
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.invalidate();
    }

    public boolean login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findByUsername(username);
        if (user != null && Objects.equals(user.getPassword(),password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            return true;
        }
        return false;
    }

    public boolean addUser(HttpServletRequest request) {
        Map<String,String> info = new HashMap<>();
        info.put("username",request.getParameter("username"));
        info.put("firstname",request.getParameter("firstname"));
        info.put("surname",request.getParameter("surname"));
        info.put("password",request.getParameter("password"));
        return userService.addUser(info);
    }

    public boolean editUser(HttpServletRequest request) {
        Map<String,String> info = new HashMap<>();
        info.put("oldname",request.getParameter("oldname"));
        info.put("username",request.getParameter("username"));
        info.put("password",request.getParameter("password"));
        info.put("firstname",request.getParameter("firstname"));
        info.put("surname",request.getParameter("surname"));
        return userService.editUser(info);
    }


}
