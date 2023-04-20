package com.example.javaeeproject.servlets;

import com.example.javaeeproject.model.Items;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet(name = "viewCartServlet", value = "/viewCart")
public class ViewCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Items> cart = null;
        try {
            cart = getCartFromCookies(request);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(cart);

        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/viewCart.jsp").forward(request, response);
    }

    private List<Items> getCartFromCookies(HttpServletRequest request) throws IOException, ClassNotFoundException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    return deserializeCart(cookie.getValue());
                }
            }
        }
        return new ArrayList<>();
    }

    private List<Items> deserializeCart(String cartValue) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(cartValue);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        List<Items> cart = (List<Items>) ois.readObject();
        ois.close();
        return cart;
    }
}
