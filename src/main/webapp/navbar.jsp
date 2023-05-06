<%@include file="user.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">LAB</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <%
        if (ONLINE){
      %>
      <a class="nav-item nav-link active" href="index.jsp">Home <span class="sr-only"></span></a>
      <a class="nav-item nav-link" href="/showItems">Items</a>
      <a class="nav-item nav-link" href="/addItem.jsp">Add item</a>
      <a class="nav-item nav-link" href="/viewCart">Cart</a>
      <a class="nav-item nav-link" href="/itemList">Store</a>
      <a class="nav-item nav-link" href="/viewOrders.jsp">View Orders</a>
      <a class="nav-item nav-link" href="/profile" style="color: orange;"><%=currentUser.getFull_name()%></a>
      <a class="nav-item nav-link" href="/LogOutServlet" style="color: red">LogOut</a>
      <%
        }else {
      %>
      <a class="nav-item nav-link active" href="index.jsp">Home <span class="sr-only"></span></a>
      <a class="nav-item nav-link" href="/login">Login</a>
      <a class="nav-item nav-link disabled" href="#">Soon...</a>
      <%
        }
      %>
    </div>
  </div>
</nav>