<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Welcome </title>
</head>
<body>

<%@ include file="header.html" %>

<p> Dear ${sessionScope.uname}  Welcome to Products Page</p>

	
<%@ include file="footer.html" %>
</body>
</html>