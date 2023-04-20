<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <%@include file="head.jsp"%>
  <%@include file="navbar.jsp"%>
    <div class="container">
      <div class="row mt-5">
        <div class="col-sm-6 offset-3">
          <h4 class="mb-4">
            LOGIN TO SYSTEM
          </h4>
          <%
            String passError = request.getParameter("passwordError");
            if (passError!=null){
          %>
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Incorrect password
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">x</span>
            </button>
          </div>
          <%
            }
          %>
          <%
            String emailError = request.getParameter("emailError");
            if (emailError!=null){
          %>
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Incorrect Email
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">x</span>
            </button>
          </div>
          <%
            }
          %>
          <form action="/auth" method="post">
            <div class="form-group">
              <label>EMAIL: </label>
              <input type="email" required class="form-control" name="email">
            </div>
            <div class="form-group">
              <label>PASSWORD: </label>
              <input type="password" required class="form-control" name="password">
            </div>
            <div class="form-group">
              <button class="btn btn-success">LOGIN</button>
            </div>
          </form>
          <form action="/RegisterServlet">
            <button class="btn btn-success">REGISTER</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
