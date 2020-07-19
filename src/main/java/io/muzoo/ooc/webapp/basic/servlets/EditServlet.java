package io.muzoo.ooc.webapp.basic.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends AbstractRoutableHttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if (securityService.isAuthorized(request)) {
           request.setAttribute("user",securityService.getCurrentUser(request));
           RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/edit.jsp");
           dispatcher.include(request,response);
       }
       else {
           request.setAttribute("error","ERROR: Not authorized to perform this action");
           response.sendRedirect("/login");
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (securityService.isAuthorized(request)) {
            if (securityService.editUser(request)) {
                response.sendRedirect("/");
            }
            else {
                request.setAttribute("user",securityService.getCurrentUser(request));
                request.setAttribute("info","Edit failed. Please try again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/edit.jsp");
                dispatcher.include(request,response);
            }
        }
        else {
            request.setAttribute("error","ERROR: Please re-login");
            response.sendRedirect("/login");
        }
    }

    @Override
    public String getPattern() {
        return "/edit";
    }
}
