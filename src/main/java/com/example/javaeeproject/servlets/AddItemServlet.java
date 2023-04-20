package com.example.javaeeproject.servlets;

import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.repository.impl.ItemRepositoryImpl;
import com.example.javaeeproject.services.ItemService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addItem", value = "/addItem")
public class AddItemServlet extends HttpServlet {
    private final ItemService itemService = new ItemService(
            new ItemRepositoryImpl()
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("item_name");
        int price = Integer.parseInt(request.getParameter("item_price"));
        int amount = Integer.parseInt(request.getParameter("item_amount"));

        Items item = new Items();
        item.setName(name);
        item.setPrice(price);
        item.setAmount(amount);

        if (itemService.addItem(item)) {
            response.sendRedirect("/showItems");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('An error occurred: in db try later');");
            out.println("window.location.href='/addItem.jsp';");
            out.println("</script>");
        }
    }
}
