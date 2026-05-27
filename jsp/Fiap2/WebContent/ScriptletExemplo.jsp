<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- formas de colocar scripts java direto no html --%>

<%
	int numero = 10;

	out.println("Numero: " + numero);
%>

<p>Novamente o mesmo número: <%=numero %></p>

<p>Endereço IP: <%=request.getRemoteAddr() %> </p>

<%-- em formato xml --%>
<jsp:scriptlet>
	double valor = 12.5;
	out.println(valor);
</jsp:scriptlet>

<%-- O ideal é usar a "!" para declarar uma variável (ou objeto) e o "=" para exibir --%>
<%! String texto = "alguma coisa"; %>
<p>Forma de usar variavel: <%=texto %></p>

</body>
</html>