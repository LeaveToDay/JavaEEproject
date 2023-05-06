<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.javaeeproject.model.Items" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Cart</title>
</head>
<body>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>
<h1>View Cart</h1>
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
                    ArrayList<Items> cart = (ArrayList<Items>) request.getAttribute("cart");
                    for (Items item : cart) {
                %>
                <tr>
                    <td><%=item.getId()%>
                    </td>
                    <td><%=item.getName()%>
                    </td>
                    <td><%=item.getPrice()%>
                    </td>
                    <td><%=item.getAmount()%>
                    </td>
                    <td>
                        <form method="post" action="removeFromCart">
                            <input type="hidden" name="id" value="<%= item.getId() %>">
                            <input type="submit" class="btn btn-info btn-sm" value="Remove from cart">
                        </form>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
            <form method="post" action="createOrder">
                <input type="hidden" name="userId" value="<%= currentUser.getId() %>">
                <input type="submit" class="btn btn-info btn-sm" value="Create Order">
            </form>
        </div>
    </div>
</div>
</body>
</html>
