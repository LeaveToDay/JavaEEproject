<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.javaeeproject.model.Items" %>
<%@ page import="com.example.javaeeproject.repository.impl.ItemRepositoryImpl" %>
<%@ page import="com.example.javaeeproject.services.ItemService" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Item List</title>
</head>
<body>
<%@include file="head.jsp" %>
<%@include file="navbar.jsp" %>
<h1>Item List</h1>
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
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <%
                    final ItemService itemService = new ItemService(
                            new ItemRepositoryImpl()
                    );
                    List<Items> items = itemService.getItems();
                    for (Items item : items) {
                %>
                <tr>
                    <td><%= item.getId() %>
                    </td>
                    <td><%= item.getName() %>
                    </td>
                    <td><%= item.getPrice() %>
                    </td>
                    <td><%= item.getAmount() %>
                    </td>
                    <td>
                        <form method="post" action="addToCart">
                            <input type="hidden" name="id" value="<%= item.getId() %>">
                            <input type="submit" class="btn btn-info btn-sm" value="Add to Cart">
                        </form>
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
