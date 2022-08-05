<%@page import="com.Bean.CategoryReportBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<body>
<jsp:include page="HomeHeader.jsp"></jsp:include>
<h2>Chart</h2>


	<div style="width:70rem; height:70rem; ">
		<canvas id="myChart"></canvas>
	</div>

<script>
<% List<CategoryReportBean> categories = (List<CategoryReportBean>) request.getAttribute("categories");  %>


const data = {
	labels :[ 
		
		<%for (CategoryReportBean cr : categories) {%>
			'<%=cr.getCategoryName()%>',
		<%}%>
]  ,
	datasets : [ {
		 maxBarThickness: 100,
		label : 'Category Wise Investment',
		backgroundColor :  [
		      'rgba(255, 99, 132, 0.2)',
		      'rgba(255, 159, 64, 0.2)',
		      'rgba(255, 205, 86, 0.2)',
		      'rgba(75, 192, 192, 0.2)',
		      'rgba(54, 162, 235, 0.2)',
		      'rgba(153, 102, 255, 0.2)',
		      'rgba(201, 203, 207, 0.2)'
		    ],
		borderColor : [
		      'rgb(255, 99, 132)',
		      'rgb(255, 159, 64)',
		      'rgb(255, 205, 86)',
		      'rgb(75, 192, 192)',
		      'rgb(54, 162, 235)',
		      'rgb(153, 102, 255)',
		      'rgb(201, 203, 207)'
		    ],

		data : [ 
			<%for (CategoryReportBean cr : categories) {%>
			<%=cr.getTotalprice()%>,
		<%}%> ],
		 borderWidth: 1
	} ]
};

const config = {
	type : 'bar',
	data : data,
	options : {}
};
</script>

<script>
const myChart = new Chart(document.getElementById('myChart'), config);


</script>


</body>
</html>