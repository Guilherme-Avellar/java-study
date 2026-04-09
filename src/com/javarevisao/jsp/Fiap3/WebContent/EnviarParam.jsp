<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<h1>Envio de parâmetros para outra pagina JSP.</h1>
	<form action="EnvioResult.jsp" method="get">
		<fieldset>
			<legend>Formulário</legend>
			<div>
				<label for="nome">Nome</label>
				<input type="text" name="nome" id="nome" placeholder="digite seu nome...">
			</div>
			<div>
				<label for="idade">Idade</label>
				<input type="number" name="idade" id="idade" placeholder="digite sua idade...">
			</div>
			<div>
				<input type="submit" value="enviar">
			</div>
		</fieldset>
	</form>
</div>

</body>
</html>