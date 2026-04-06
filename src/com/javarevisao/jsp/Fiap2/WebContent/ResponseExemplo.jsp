<%@ page language="java" import="java.util.Date" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%! String texto = "Hello"; %>

<%
	out.println(texto);
	out.println(new Date().toLocaleString());
%>

<% response.setIntHeader("Refresh", 1); %>


</body>
</html>