package io.muzoo.ooc.webapp.basic.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends AbstractRoutableHttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (securityService.isAuthorized(request)) {
            response.sendRedirect("/home");
        }
        else {
            response.sendRedirect("/login");
        }
    }

    @Override
    public String getPattern() {
        return"/index.jsp";
    }
}
