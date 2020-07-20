package io.muzoo.ooc.webapp.basic.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveServlet extends AbstractRoutableHttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (securityService.isAuthorized(request)) {
            if (!securityService.getCurrentUsername(request).equals(request.getParameter("username"))) {
                // user cannot remove himself
                securityService.removeUser(request);
            }
            response.sendRedirect("/");
        }
        else {
            response.sendRedirect("/login");
        }
    }

    @Override
    public String getPattern() {
        return "/remove";
    }
}
