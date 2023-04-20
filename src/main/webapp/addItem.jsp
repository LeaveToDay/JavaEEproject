<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
    <%@include file="head.jsp"%>
    <%@include file="navbar.jsp"%>
    <form action="/addItem" method="post">
        <div class="form-group">
            <label>
                Name:
            </label>
            <input type="text" required class="form-control" name="item_name">
        </div>
        <div class="form-group">
            <label>
                Price:
            </label>
            <input type="text" required class="form-control" name="item_price">
        </div>
        <div class="form-group">
            <label>
                Amount:
            </label>
            <input type="text" required class="form-control" name="item_amount">
        </div>
        <div class="form-group">
            <button class="btn btn-success">ADD ITEM</button>
        </div>
    </form>
</body>
</html>
