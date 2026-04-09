<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- Bean é uma classe em java mesmo, muito usado para fazer objetos. Nesse caso um objeto para
	atributos de clientes --%>

	<h1>Dados do cliente:</h1>
	<p>Nome: ${clienteKey.getNome()}</p>
	<p>Idade: ${clienteKey.getIdade()}</p>

</body>
</html>