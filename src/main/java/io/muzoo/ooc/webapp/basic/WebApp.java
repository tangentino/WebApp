package io.muzoo.ooc.webapp.basic;

import io.muzoo.ooc.webapp.basic.servlets.HomeServlet;
import io.muzoo.ooc.webapp.basic.servlets.LoginServlet;
import io.muzoo.ooc.webapp.basic.servlets.LogoutServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class WebApp {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        File docBase = new File("src/main/webapp/");
        docBase.mkdirs();

        try {
            Context ctx = tomcat.addWebapp("",docBase.getAbsolutePath());

            HomeServlet home = new HomeServlet();
            Tomcat.addServlet(ctx,HomeServlet.class.getSimpleName(),home);
            // Trick: mapping with index.jsp, allow access to root path "/"
            ctx.addServletMapping("/index.jsp",HomeServlet.class.getSimpleName());

            LoginServlet loginServlet = new LoginServlet();
            Tomcat.addServlet(ctx,LoginServlet.class.getSimpleName(),loginServlet);
            ctx.addServletMapping("/login",LoginServlet.class.getSimpleName());

            LogoutServlet logoutServlet = new LogoutServlet();
            Tomcat.addServlet(ctx,LogoutServlet.class.getSimpleName(),logoutServlet);
            ctx.addServletMapping("/logout",LogoutServlet.class.getSimpleName());

            tomcat.start();
            tomcat.getServer().await();

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
