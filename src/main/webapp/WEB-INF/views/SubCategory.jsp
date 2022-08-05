<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sub Category</title>
</head>
<body>
	<jsp:include page="HomeHeader.jsp"></jsp:include><br>
	<br>
	<h2>list Items</h2>
	<s:form action="savesubCategory" method="post" modelAttribute="sub">
		<label>Choose Expense Category</label>
		<s:select path="categoryId">
			<c:forEach items="${subcategory}" var="i">
				<option value="${i.categoryId }">${i.categoryName }</option>
			</c:forEach>

		</s:select>
		<br><br>
		<label>Add SubCategory</label>
		<s:input path="subCategoryName"/><br><br>
		<input type="submit" value="Add" >
	</s:form>

</body>
</html>





