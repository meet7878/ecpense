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
	<jsp:include page="HomeHeader.jsp"></jsp:include><br>
	<br>


	<s:form method="post" action="additems" modelAttribute="item">

Expense Name:<s:input path="itemName" />
		<s:errors path="ItemName"></s:errors>
		<br>
		<br>
		
 <div id="expense">
<label >Choose Expense Category</label>
<s:select path="categoryId" id="category" >
<c:forEach items="${category}" var="i">
<option value="${i.categoryId }">${i.categoryName }</option>
</c:forEach>

</s:select>
		</div>
		<br>
		<br> 
		<div id="exp">
<label >Choose Expense SubCategory</label>
<s:select path="subCategoryId" id="subcategoryid">

</s:select>
		</div>
		<br>
		<br> 
		
 <%-- <div id="exp">
<label >Choose Expense SubCategory</label>
<s:select path="subCategoryId" >
<c:forEach items="${subcategory}" var="s">
<option value="${s.categoryId}">${s.subCategoryName}</option>
</c:forEach>

</s:select>
		</div>
		<br>
		<br> 	 --%>			
		
 Location:<s:input path="location" />
		<s:errors path="location"></s:errors>
		<br>
		<br>
Expense Amount<s:input path="price" />
		<s:errors path="price"></s:errors>
		<br>
		<br>

		<div id ="items">
			<label >Choose payment type:</label>
			<s:select path="item">
				<c:forEach items="${account}" var="i">
					<option value="${i.accountid}">${i.accountType}</option>
				</c:forEach>
			</s:select>
			<br>
			<br>
		</div>

		<div id="accountNumbers">
			<label >Choose Account Number</label>
			<s:select path="accountNumber">
				<c:forEach items="${account}" var="i">
					<option value="${i.accountid}">${i.accountNumber}</option>
				</c:forEach>
			</s:select>
			<br>
			<br>
		</div>

		<div id="upiIds">
			<label >Choose UPI ID</label>
			<s:select path="upiId">
				<c:forEach items="${account}" var="i">
					<option value="${i.accountid}">${i.upiId}</option>
				</c:forEach>
			</s:select>
			<br>
			<br>
		</div>

Current Date:<input type="date" name="date">
		<br>
		<br>
Current time:<input type="time" name="time">
		<br>
		<br>


		<input type="submit" value="submit">

	</s:form>


	<%-- <script type="text/javascript">
	document.addEventListener('DOMContentLoaded',function(){
		console.log("DOM");
							document.querySelector("#item").onchange = function() {
								console.log("item");

								if (this.value == 3 || this.value == 4) {
									console.log("debitcard");
									document.querySelector("#upiIds").style.display = 'none';
									document.querySelector("#accountNumbers").style.display = 'block';
									// document.querySelector("#price").style.display='block';
								}
								if (this.value == "cash") {
									document.querySelector("#upiIds").style.display = 'none';
									document.querySelector("#accountNumbers").style.display = 'none';
									//document.querySelector("#price").style.display = 'block';
								}
								if (this.value == 2) {
									console.log("PAYTM");
									document.querySelector("#upiIds").style.display = 'block';
									document.querySelector("#accountNumbers").style.display = 'none';
									// document.querySelector("#amount").style.display='block';
								}
							}
						})
	</script> --%>
	
	
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document)
			.ready(
				function () {
					$("#category")
						.click(
							function () {
								let categoryid = document.getElementById("category").value;
								/* let url = "http://localhost:9696/listsubcategory/"+ categoryid; */
								let url = "http://https://mygateism2022.herokuapp.com//listsubcategory/"+ categoryid;
								$.get(url).done(function (data) {
											let subcategory = $("#subcategoryid");
											subcategory.empty();
											for (let i = 0; i < data.length; i++) {
												subcategory.append("<option value=" + data[i].subCategoryId + ">"+ data[i].subCategoryName+ "</option>");
											}
										})
									.fail(function () {
											console.log("something went wrong");
										});
							})
				})
	</script>





</body>
</html>