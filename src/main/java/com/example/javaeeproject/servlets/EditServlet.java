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

@WebServlet(name = "editItem", value = "/editItem")
public class EditServlet extends HttpServlet {
    private final ItemService itemService = new ItemService(
            new ItemRepositoryImpl()
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Items item = itemService.getItem(id);

        if (item != null) {
            request.setAttribute("item", item);
            request.getRequestDispatcher("/editItem.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("item_name");
        int price = Integer.parseInt(request.getParameter("item_price"));
        int amount = Integer.parseInt(request.getParameter("item_amount"));

        Items item = itemService.getItem(id);
        if (item != null) {
            item.setName(name);
            item.setAmount(amount);
            item.setPrice(price);

            if (itemService.saveItem(item)) {
                response.sendRedirect("/itemDetails?id=" + id);
            }
            else {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('An error occurred: in db try later');");
                out.println("window.location.href='/showItems';");
                out.println("</script>");
            }
        } else {
            response.sendRedirect("/");
        }
    }
}
