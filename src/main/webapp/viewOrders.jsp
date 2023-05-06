<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.javaeeproject.model.Items" %>
<%@ page import="com.example.javaeeproject.repository.impl.ItemRepositoryImpl" %>
<%@ page import="com.example.javaeeproject.services.ItemService" %>
<%@ page import="com.example.javaeeproject.services.OrderService" %>
<%@ page import="com.example.javaeeproject.repository.impl.OrderRepositoryImpl" %>
<%@ page import="com.example.javaeeproject.model.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order List</title>
</head>
<body>
<%@include file="head.jsp" %>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Date</th>
                    <th>Details</th>
                </tr>
                </thead>
                <tbody>
                <%
                    final OrderService orderService = new OrderService(
                            new OrderRepositoryImpl()
                    );
                    List<Order> orders = orderService.getOrders(currentUser.getId());
                    System.out.println(orders);
                    for (Order order : orders) {
                %>
                <tr>
                    <td><%= order.getId() %>
                    </td>
                    <td><%= order.getDate() %>
                    </td>
                    <td>
                        <a href="/orderDetails?id=<%=order.getId()%>" class="btn btn-info btn-sm">Details</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
