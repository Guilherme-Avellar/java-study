<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
</head>
<body>

<%-- a palavra "param" vem de parameter, a função usada normalmente --%>
<h1>Dados recebidos</h1>
<p>Nome: ${param.nome}</p>
<p>Idade: ${param.idade}</p>

<br></br>
<p>Número: ${param.numero}</p>


</body>
</html>