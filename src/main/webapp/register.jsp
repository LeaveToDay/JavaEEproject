<html>
  <head>
    <title>REGISTER</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  </head>
  <body>
  <%@include file="navbar.jsp"%>
    <div class="container">
      <div class="row mt-5">
        <div class="col-sm-6 offset-3">
          <h4 class="mb-4">
            REGISTER TO SYSTEM
          </h4>
          <%
            String success = request.getParameter("success");
            if (success!=null){
          %>
          <div class="alert alert-success alert-dismissible fade show" role="alert">
            User added successfully
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true"></span>
            </button>
          </div>
          <%
            }
          %>
          <%
            String passError = request.getParameter("passwordError");
            if (passError!=null){
          %>
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Passwords are not same
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
            User exists
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">x</span>
            </button>
          </div>
          <%
            }
          %>
          <form action="/ToRegisterServlet" method="post">
            <div class="form-group">
              <label>EMAIL: </label>
              <input type="email" required class="form-control" name="email">
            </div>
            <div class="form-group">
              <label>PASSWORD: </label>
              <input type="password" required class="form-control" name="password">
            </div>
            <div class="form-group">
              <label></label>
              <input type="password" required class="form-control" name="re_password" placeholder="retype password">
            </div>
            <div class="form-group">
              <label>FULL NAME</label>
              <input type="text" required class="form-control" name="full_name">
            </div>
            <div class="form-group">
              <button class="btn btn-success">REGISTER</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
