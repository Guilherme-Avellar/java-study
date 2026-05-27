<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formas de formatação</title>
</head>
<body>

	<c:set var="data" value="<%=new java.util.Date()%>"/>
	
	<p>Data formatada (1): <fmt:formatDate type="time" value="${data}"/></p>
	<p>Data formatada (2): <fmt:formatDate type="date" value="${data}"/></p>
	<p>Data formatada (3): <fmt:formatDate type="both" value="${data}"/></p>
	<p>Data formatada (4): <fmt:formatDate pattern="dd/MM" value="${data}"/></p>
	
	<h3>Formatar números:</h3>
	<c:set var="valor" value="999.888"/>
	<p>Número formatado (1):<fmt:formatNumber value="${valor}" type="currency"/></p>
	<p>Número formatado (2):<fmt:formatNumber value="${valor}" pattern="###,###.0"/></p>

</body>
</html>