<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="SessionExemplo.jsp" method="post">
		<fieldset>
			<div>
				<label for="nomeUsuario">Nome do usuário:</label>
				<input type="text" name="nomeUsuario">
			</div>
			<div>
				<label for="senha">Senha:</label>
				<input type="password" name="senha">
			</div>
			<input type="submit" value="Login"/>
		</fieldset>
	</form>
</body>
</html>