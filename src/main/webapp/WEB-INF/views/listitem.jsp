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
	<h2>list Items</h2>

	<table border="1">
	<thead class="thead-light">
		<tr>
			<th>itemname</th>
			<th>Location</th>
			<th>price</th>
			<th>item</th>
			<th>date</th>
			<th>time</th>
			<th>Category</th>
			<th>userid</th>
			
			
		</tr>
		</thead>
		
		<c:forEach items="${items}" var="i" >
		
		<tr>
		<td>${i.itemName }</td>
		<td>${i.location}</td>
		<td>${i.price}</td>
		<td>${i.item}</td>
		<td>${i.date }</td>
		<td>${i.time } </td>
		<td>${i.categoryName }</td>
		<td>${i.userId}</td>
		
		</tr>
		
		</c:forEach>
		
	</table>

</body>
</html>