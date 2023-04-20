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
        <div class="col-sm-6 offset-3">
          <%
            Items item = (Items) request.getAttribute("item");
            if (item!=null){
          %>
          <form action="/editItem" method="post">
            <input type="hidden" name="id" value="<%=item.getId()%>">
            <div class="form-group">
              <label>
                Name:
              </label>
              <input type="text" required class="form-control" name="item_name" value="<%=item.getName()%>">
            </div>
            <div class="form-group">
              <label>
                Price:
              </label>
              <input type="text" required class="form-control" name="item_price" value="<%=item.getPrice()%>">
            </div>
            <div class="form-group">
              <label>
                Amount:
              </label>
              <input type="text" required class="form-control" name="item_amount" value="<%=item.getAmount()%>">
            </div>
            <div class="form-group">
              <button class="btn btn-success">SAVE ITEM</button>
<%--              <button type="button" class="btn btn-danger" &lt;%&ndash;data-toggle="modal"&ndash;%&gt; data-target="#deleteItemModal">--%>
<%--                DELETE ITEM--%>
<%--              </button>--%>
            </div>
          </form>
<%--          <div class="modal fade" id="deleteItemModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">--%>
<%--            <div class="modal-dialog" role="document">--%>
<%--              <div class="modal-content">--%>
<%--                <form action="/deleteItem" method="post">--%>
<%--                  <input type="hidden" name="id" value="<%=item.getId()%>">--%>
<%--                  <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="staticBackdropLabel">DELETE PROCESS</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                      <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                  </div>--%>
<%--                  <div class="modal-body">--%>
<%--                    Do you want to delete?--%>
<%--                  </div>--%>
<%--                  <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>--%>
<%--                    <button class="btn btn-danger">Delete</button>--%>
<%--                  </div>--%>
<%--                </form>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--          </div>--%>
          <%
            }
          %>
        </div>
      </div>
    </div>
  </body>
</html>
