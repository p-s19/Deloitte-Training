<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Users</title>
</head>
<body style="background-color: pink">
<c:choose>
<c:when test="${elist.size()>0 }">
  
<h1>Users List</h1>
<table>
		<tr>
		<td>Username</td>
		<td>Email</td>
		<td>Mobile</td>
		
		</tr>
<c:forEach var="elist" items="${elist}">
<table>
<tr>
	<tr>
	<td>${elist.name}</td> 
	<td>${elist.email}</td>
	<td>${elist.mobile}</td>
</tr>
</table>
</c:forEach>
</table>
<br>
</c:when>
<c:otherwise>
  <h3><center>No Data Found</center></h3>
</c:otherwise>
</c:choose>
<center><a href ="goHome.obj">Go Home</a></center><br><br>
</body>
</html>