<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PROFILE</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <h2 class="mb-4">
                WELCOME <%=currentUser.getFull_name()%>
            </h2>
            <h5 class="mb-3">
                YOUR ID: <%=currentUser.getId()%><br>
            </h5>
            <h5 class="mb-3">
                YOUR EMAIL: <%=currentUser.getEmail()%><br>
            </h5>
            <h5 class="mb-3">
                YOUR PASSWORD: <%=currentUser.getPassword()%><br>
            </h5>
        </div>
    </div>
</div>
</body>
</html>