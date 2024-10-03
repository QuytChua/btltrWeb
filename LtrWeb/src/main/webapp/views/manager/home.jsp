<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomeManager</title>
</head>
<body>
	<h1>Welcome, manager ${username}!</h1>
    <p><strong>Email:</strong>&nbsp ${email}</p> 
    <p><strong>Full Name:</strong>&nbsp ${fullname}</p>
    <p><strong>Phone:</strong>&nbsp ${phone}</p>
    <a href="${pageContext.request.contextPath}/logout" class="logout">Logout</a>
</body>
</html>