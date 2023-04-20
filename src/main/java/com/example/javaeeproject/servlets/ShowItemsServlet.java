package com.example.javaeeproject.servlets;

import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.repository.impl.ItemRepositoryImpl;
import com.example.javaeeproject.services.ItemService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "showItems", value = "/showItems")
public class ShowItemsServlet extends HttpServlet {
    private final ItemService itemService = new ItemService(
            new ItemRepositoryImpl()
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Items> items = itemService.getItems();
        request.setAttribute("itemss", items);
        request.getRequestDispatcher("/ShowItems.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
