<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.javaeeproject.model.Items" %>
<%@ page import="com.example.javaeeproject.services.OrderService" %>
<%@ page import="com.example.javaeeproject.repository.impl.OrderRepositoryImpl" %>
<%@ page import="com.example.javaeeproject.model.Order" %>
<%@ page import="com.example.javaeeproject.model.OrderItem" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Item List</title>
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
                    <th>Name</th>
                    <th>Price</th>
                    <th>Amount</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Order order = (Order) request.getAttribute("order");
                    for (OrderItem item : order.getItems()) {
                %>
                <tr>
                    <td><%= item.getItem().getId() %>
                    </td>
                    <td><%= item.getItem().getName() %>
                    </td>
                    <td><%= item.getItem().getPrice() %>
                    </td>
                    <td><%= item.getCount() %>
                    </td
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
