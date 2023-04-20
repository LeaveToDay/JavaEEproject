package com.example.javaeeproject.servlets;

import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.repository.impl.ItemRepositoryImpl;
import com.example.javaeeproject.services.ItemService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "deleteItem", value = "/deleteItem")
public class DeleteItemServlet extends HttpServlet {
    private final ItemService itemService = new ItemService(
            new ItemRepositoryImpl()
    );
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Items item = itemService.getItem(id);
        if (item != null) {
            itemService.deleteItem(item);
            response.sendRedirect("/showItems");
        }else {
            response.sendRedirect("/");
        }
    }
}
