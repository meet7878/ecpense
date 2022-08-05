<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>list Account</h2>

	<table border="1">
	<thead class="thead-light">
		<tr>
			<th>AccountNumber</th>
			<th>AccountType</th>
			<th>Account balance</th>
			<th>AccountMode</th>
			<th>UPI ID</th>
			
		</tr>
		</thead>
		
		<c:forEach items="${show}" var="i">
		
		<tr>
		<td>${i.accountNumber }</td>
		<td>${i.accountType}</td>
		<td>${i.accountBalance}</td>
		<td>${i.accountMode}</td>
		<td>${i.upiId}</td>
		
		
		</tr>
		
		</c:forEach>
		
	</table>

</body>
</html>