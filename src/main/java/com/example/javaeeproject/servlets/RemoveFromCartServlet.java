package com.example.javaeeproject.servlets;

import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.repository.impl.ItemRepositoryImpl;
import com.example.javaeeproject.services.ItemService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet(name = "removeFromCartServlet", value = "/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {
    private final ItemService itemService = new ItemService(
            new ItemRepositoryImpl()
    );

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        List<Items> cart = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    try {
                        cart = deserializeCart(cookie.getValue());

                        Items item = itemService.getItems().stream().filter(i -> i.getId() == id).findFirst().orElse(null);
                        if (item != null) {
                            for (Items cartItem : cart) {
                                if (cartItem.getId() == item.getId()) {
                                    cartItem.setAmount(cartItem.getAmount() - 1);
                                    if (cartItem.getAmount() == 0) {
                                        cart.remove(cartItem);
                                        break;
                                    }
                                }
                            }
                        }

                        String cartValue = serializeCart(cart);
                        Cookie cartCookie = new Cookie("cart", cartValue);
                        cartCookie.setMaxAge(3600);
                        response.addCookie(cartCookie);

//                        throw new ClassNotFoundException();

                        response.sendRedirect(request.getContextPath() + "/viewCart");
                    } catch (ClassNotFoundException e) {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('An error occurred: while removing try again or clear cookies');");
                        out.println("window.location.href='/viewCart';");
                        out.println("</script>");
                    }
                    break;
                }
            }
        }
    }

    private String serializeCart(List<Items> cart) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(cart);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    private List<Items> deserializeCart(String cartValue) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(cartValue);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        List<Items> cart = (List<Items>) ois.readObject();
        ois.close();
        return cart;
    }
}
