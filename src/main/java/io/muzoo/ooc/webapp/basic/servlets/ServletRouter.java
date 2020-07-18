package io.muzoo.ooc.webapp.basic.servlets;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

public class ServletRouter {

    private static final List<Class<? extends HttpServlet>> servletClasses = new ArrayList<>();

    static {
        servletClasses.add(HomeServlet.class);
        servletClasses.add(LoginServlet.class);
        servletClasses.add(LogoutServlet.class);
    }

    public void initialize(Context ctx) {

        for (Class<? extends HttpServlet> servletClass: servletClasses) {
            try {
                HttpServlet httpServlet = servletClass.newInstance();
                Tomcat.addServlet(ctx,servletClass.getSimpleName(),httpServlet);
                // Trick: mapping with index.jsp, allow access to root path "/"
                ctx.addServletMapping("/index.jsp",HomeServlet.class.getSimpleName());
            }
            catch (InstantiationException e) {
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        HomeServlet home = new HomeServlet();


        LoginServlet loginServlet = new LoginServlet();
        Tomcat.addServlet(ctx,LoginServlet.class.getSimpleName(),loginServlet);
        ctx.addServletMapping("/login",LoginServlet.class.getSimpleName());

        LogoutServlet logoutServlet = new LogoutServlet();
        Tomcat.addServlet(ctx,LogoutServlet.class.getSimpleName(),logoutServlet);
        ctx.addServletMapping("/logout",LogoutServlet.class.getSimpleName());
    }
}
