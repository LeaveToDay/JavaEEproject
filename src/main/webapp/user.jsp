<%@ page import="com.example.javaeeproject.model.Users" %><%
  Users currentUser = (Users) request.getSession().getAttribute("CURRENT_USER");
  boolean ONLINE = false;
  if (currentUser!=null){
    ONLINE = true;
  }
%>