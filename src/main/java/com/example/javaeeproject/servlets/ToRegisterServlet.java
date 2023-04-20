package com.example.javaeeproject.servlets;

import com.example.javaeeproject.model.Users;
import com.example.javaeeproject.repository.impl.UserRepositoryImpl;
import com.example.javaeeproject.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ToRegisterServlet", value = "/ToRegisterServlet")
public class ToRegisterServlet extends HttpServlet {
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
        String rePassword = request.getParameter("re_password");
        String fullName = request.getParameter("full_name");

        String redirect = "/register?passwordError";
        if (password.equals(rePassword)) {
            redirect = "/register?emailError";

            Users user = userService.getUser(email);
            if (user == null) {
                Users newUser = new Users();
                newUser.setEmail(email);
                newUser.setPassword(password);
                newUser.setFull_name(fullName);
                userService.addUser(newUser);
                redirect = "/login";
            }
        }
        response.sendRedirect(redirect);
    }
}
