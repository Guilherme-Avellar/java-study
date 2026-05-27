<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- para usar uma biblioteca externa, usa-se o taglib. A biblioteca precisa estar encorporada dentro de
	lib de WEB-INF para usar esse caminho, se estiver em outro lugar se usa outro caminho --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String nome1 = "Fernando";
		out.println("<h3>Nome 1:" + nome1 + "</h3>");
	%>
	<%-- para declarar uma variavél, ou inserir uma variavel, se usa o set da taglib --%>
	<c:set var="nome2" value="Maria"/>
	<h3>Nome2: ${nome2}</h3>
	<c:out value="${nome2}"></c:out>
	<br> </br>
	
	<%-- um for each percorrendo uma array list --%>
	<c:forEach var="l" items="${lista}">
		${l} 
		<br>
	</c:forEach>
	
	<c:set var="usuario" value="admin"/>
	<c:if test="${usuario == 'admin'}">
		<p>Usuário administrador</p>
	</c:if>
	
	<c:set var="numero" value="100"/>
	<%-- o choose se usa em conjunto com outras taglibs. Tem a função parecida de um if else --%>
	<c:choose>
		<c:when test="${numero < 8}">
			<p>número é menor que 8</p>
		</c:when>
		<c:when test="${numero >= 8 && numero <= 80}">
			<p>número é maior que 8 e menor que 80</p>
		</c:when>
		<c:otherwise>
			<p>número é maior que 80</p>
		</c:otherwise>
	</c:choose>
	
	<br></br>
	
	<%-- passando link dinamicamente e com parametros, repare na url depois de clicar no link --%>
	<c:url value="EnvioResult.jsp" var="link">
		<c:param name="numero" value="${numero}"></c:param>
	</c:url>
	<a href="${link}">Link para outra página passando parâmetros</a>
	
	<br>
	<%-- se não tiver o "var" ele importa onde está, com o var o import se torna uma variável --%>
	<c:import url="objetoImport.jsp" var="pagina"/>
	${pagina}
	

</body>
</html>