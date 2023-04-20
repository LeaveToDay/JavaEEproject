<%@ page import="com.example.javaeeproject.model.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="head.jsp"%>
    <%@include file="navbar.jsp"%>
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
                        <th>DETAILS</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("itemss");

                        if (items!=null){
                            for (Items item: items){
                    %>
                    <tr>
                        <td>
                            <%=item.getId()%>
                        </td>
                        <td>
                            <%=item.getName()%>
                        </td>
                        <td>
                            <%=item.getPrice()%>
                        </td>
                        <td>
                            <%=item.getAmount()%>
                        </td>
                        <td>
                            <a href="/itemDetails?id=<%=item.getId()%>" class="btn btn-info btn-sm">DETAILS</a>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
