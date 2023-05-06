<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
    <%@include file="head.jsp"%>
    <%@include file="navbar.jsp"%>
    <form action="/addItem" method="post">
        <div class="form-group col-sm-6 offset-3">
            <label>
                Name:
            </label>
            <input type="text" required class="form-control" name="item_name">
        </div>
        <div class="form-group col-sm-6 offset-3">
            <label>
                Price:
            </label>
            <input type="text" required class="form-control" name="item_price">
        </div>
        <div class="form-group col-sm-6 offset-3">
            <label>
                Amount:
            </label>
            <input type="text" required class="form-control" name="item_amount">
        </div>
        <div class="form-group col-sm-6 offset-3">
            <button class="btn btn-success">ADD ITEM</button>
        </div>
    </form>
</body>
</html>
