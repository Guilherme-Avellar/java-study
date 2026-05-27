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
	session.setAttribute("nome", "Carlos");
	application.setAttribute("hitCounter", 1);
%>

<p>Dados antes:</p>
<%
	out.println(session.getAttribute("nome"));
	out.println(application.getAttribute("hitCounter"));
%>

<%
	pageContext.removeAttribute("nome", pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("hitCounter", pageContext.APPLICATION_SCOPE);
%>

<p>Dados depois:</p>
<%
	out.println(session.getAttribute("nome"));
	out.println(application.getAttribute("hitCounter"));
%>

</body>
</html>