<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% out.println("Um dos Objetos Implícitos é o próprio out"); %>

</br></br>

<% String valor = request.getParameter("parametro"); %>
<%=valor %>

</body>
</html>