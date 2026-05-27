<!-- atenção para a sintaxe e onde se coloca o import, é no cabeçalho mesmo -->
<%@ page import="java.util.Date" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! Date dataAtual = new Date(); %>
<p>A data de hoje é: <%=dataAtual.toLocaleString() %></p>

</body>
</html>