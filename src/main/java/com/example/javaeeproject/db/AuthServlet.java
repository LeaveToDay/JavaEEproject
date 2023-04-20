package com.example.javaeeproject.db;

import com.example.javaeeproject.model.Users;
import com.example.javaeeproject.repository.impl.UserRepositoryImpl;
import com.example.javaeeproject.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "auth", value = "/auth")
public class AuthServlet extends HttpServlet {
    private final UserService userService = new UserService(
            new UserRepositoryImpl()
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String redirect = "/login?passwordError";

        Users user = userService.getUser(email);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("CURRENT_USER", user);
                redirect = "/";
            }
        }
        response.sendRedirect(redirect);
    }
}
