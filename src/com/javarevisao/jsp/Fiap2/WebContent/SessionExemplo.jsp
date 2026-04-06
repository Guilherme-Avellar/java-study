<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>

<%-- A session é um objeto implícito que usa a memória do servidor. Nesse exemplo ela é usada para transportar informações
	Entre as páginas --%>

<%
	String usuario = request.getParameter("nomeUsuario");
	session.setAttribute("nomeUsuario", usuario);
%>

<h1>Sessão iniciada para o usuário: <%=session.getAttribute("nomeUsuario")%></h1>

<br><br>

<a href="SessionLogin.jsp">Login</a>
<br>
<a href="SessionServicos.jsp">Serviços</a>

</body>
</html>