package com.example.javaeeproject.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class ClearCartListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        HttpServletResponse response = (HttpServletResponse) context.getAttribute("response");
        Cookie cartCookie = new Cookie("cart", "");
        cartCookie.setMaxAge(0);
        response.addCookie(cartCookie);
    }
}
