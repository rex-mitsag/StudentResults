<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<form action="LoginController" method="POST">
	Username: <input type="text" name="username" required="required"><br>
	Password: <input type="password" name="password" required="required"><br>
	<input type="submit" value="Login"><br>
	<%if(request.getAttribute("error")!=null) {
		if(!request.getAttribute("error").equals("null")) {%>
		<%=request.getAttribute("error")%>
	<%}} %>	
</form>
</body>
</html>