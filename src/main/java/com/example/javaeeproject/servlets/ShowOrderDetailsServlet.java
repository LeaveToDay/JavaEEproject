package com.example.javaeeproject.servlets;

import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.model.Order;
import com.example.javaeeproject.repository.impl.ItemRepositoryImpl;
import com.example.javaeeproject.repository.impl.OrderRepositoryImpl;
import com.example.javaeeproject.services.ItemService;
import com.example.javaeeproject.services.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "orderDetails", value = "/orderDetails")
public class ShowOrderDetailsServlet extends HttpServlet {
    private final OrderService orderService = new OrderService(
            new OrderRepositoryImpl()
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.getOrder(id);

        if (order != null) {
            request.setAttribute("order", order);
            request.getRequestDispatcher("/showOrderDetails.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
