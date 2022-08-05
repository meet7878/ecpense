<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<h1>Login</h1>

<s:form action="login" method="post" modelAttribute="login">
email<s:input path="email" />
	<s:errors path="email"></s:errors>
password<s:password path="password" />
	<s:errors path="password"></s:errors>
	<input type="submit" value="Login">

</s:form>
</head>
<body>

</body>
</html>