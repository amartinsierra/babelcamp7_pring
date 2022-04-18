<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="p" items="${requestScope.paginas}">
		<h1><a href="${p.direccion}">${p.direccion}</a></h1>
		<br>
	</c:forEach>
	<br>
	<a href="datos.html">Volver</a>
</body>
</html>