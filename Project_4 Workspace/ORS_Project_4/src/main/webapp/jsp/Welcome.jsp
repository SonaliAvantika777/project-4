<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="<%=ORSView.WELCOME_CTL %>">
  <%@include file="Header.jsp" %>
    <h1 align="center">
    <font size="10px" color="red">Welcome to ORS</font>
    </h1>
  <% UserBean userbean = (UserBean)session.getAttribute("user");
  if(userbean!=null){
	  if(userbean.getRoleId()==RoleBean.STUDENT){
		  %>
		  
		  <h2 align="center">
		  <a href="<%= ORSView.GET_MARKSHEET_CTL%>">Click here to see your Markshhet</a>
		  </h2>
		  <%
		  }
		  
		  }
		  %>
		  </form>
<%@include file = "Footer.jsp" %>
</body>
</html>		  

 