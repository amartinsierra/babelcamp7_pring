<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Producto,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%ArrayList<Producto> productos=(ArrayList<Producto>)request.getAttribute("productos");%>
	<center>
		<table border='1'><tr><th>Nombre</th><th>Precio</th><th>Stock</th></tr>
			<%for(int i=0;i<productos.size();i++) {
				Producto pd=productos.get(i);%>
				<tr><td><%=pd.getNombre()%></td><td><%=pd.getPrecio() %></td><td><%=pd.getStock() %></td></tr>	
			<%}%>
		
		</table>
		<br>
		<a href='datos.jsp'>Volver</a>
	</center>
</body>
</html>