<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.javaeeproject.model.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Details Page</title>
  </head>
  <body>
  <%@include file="head.jsp"%>
  <%@include file="navbar.jsp"%>
    <div class="container">
      <div class="row mt-5">
        <div class="col-sm-12">
          <%
            Items item = (Items) request.getAttribute("item");
            if (item!=null){
          %>
          <div class="jumbotron">
            <h1 class="display-4">
              <%=item.getName()%>
            </h1>
            <p class="lead">
              ID: <%=item.getId()%>
            </p>
            <hr class="my-4">
            <p>
              Price: <%=item.getPrice()%>
            </p>
            <p>
              Amount: <%=item.getAmount()%>
            </p>
              <a class="btn btn-primary btn-sm" href="/editItem?id=<%=item.getId()%>" role="button">EDIT</a>
          </div>
          <%
            }
          %>
        </div>
      </div>
    </div>
  </body>
</html>
