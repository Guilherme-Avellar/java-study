<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:forward page="auxForward.jsp">
	<jsp:param value="jorginho" name="texto"/>
	<jsp:param value="25" name="numero"/>
</jsp:forward>

</body>
</html>