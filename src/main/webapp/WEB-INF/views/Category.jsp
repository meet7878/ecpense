<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="HomeHeader.jsp"></jsp:include><br><br>

<center>
<h2>Category </h2><br><br>

<s:form method="post" action="categorys" modelAttribute="category">
Enter Category Name:<s:input path="categoryName"/>
<s:errors path="categoryName"></s:errors><br><br>

<input type="submit" value="submit">
</s:form></center>


</body>
</html>