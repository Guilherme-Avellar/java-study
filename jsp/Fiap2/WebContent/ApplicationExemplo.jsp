<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int hitsCount = 0;
	String texto = "";

	if(application.getAttribute("hitCounter") == null) {
		application.setAttribute("hitCounter", ++hitsCount);
		texto = "Bem-vindo a primeira visita da homepage";
	} else {
		hitsCount = (Integer)application.getAttribute("hitCounter") + 1;
		application.setAttribute("hitCounter", hitsCount);
		texto = "Bem-vindo de volta!!";
	}
%>

	<p><%=texto %></p>
	<p>Visita de número: <%=hitsCount %></p>
</body>
</html>