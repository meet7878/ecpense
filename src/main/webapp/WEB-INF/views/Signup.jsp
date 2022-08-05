<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>  	
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h2>Signup</h2>

<s:form action="saveuser" method="post" modelAttribute="user">
fName:<s:input path="firstName"/>
<s:errors path="firstName"></s:errors>
lName:<s:input path="lastName"/>
<s:errors path="lastName"></s:errors>
email<s:input path="email"/>
<s:errors path="email"></s:errors>
gender: Male<s:radiobutton path="gender" value="male"/>
            Female<s:radiobutton path="gender" value="female"/>
            
password<s:password path="password" />
<s:errors path="password"></s:errors>
<input type="submit" value="signup">

</s:form>


</body>
</html>