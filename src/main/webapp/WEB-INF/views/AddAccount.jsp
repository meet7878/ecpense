<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Dateil</title>
</head>
<body>
<h2>Account Details</h2>

<s:form action="addaccount" method="post" modelAttribute="account">

<div>
Bank Name<s:input path="accountMode"/>
<s:errors cssStyle="color:red" path="accountMode"></s:errors><br><br>
</div>



<div>
Account type: <s:select path="accountType">
			<option disabled="disabled" selected="selected">--Select
				type--</option>
			<s:option value="cash">Cash</s:option>
			<s:option value="paytm">Paytm</s:option>
			<s:option value="creditcard">Credit Card</s:option>
			<s:option value="debitcard">Debit Card</s:option>
		
		</s:select>



<%-- Account Type<s:input path="accountType"/> --%>
<s:errors cssStyle="color:red" path="accountType"></s:errors><br><br>
</div>

<div id="accountNumber">
Card Number:<s:input path="accountNumber"/>
<s:errors cssStyle="color:red" path="accountNumber"></s:errors><br><br>
</div>

<div id ="upiId">
UPI ID <s:input path="upiId"/>
<s:errors cssStyle="color:red" path="upiId"></s:errors><br><br>
</div>

  
<div>            
Account Balance<s:input path="accountBalance" />
<s:errors cssStyle="color:red" path="accountBalance"></s:errors><br><br>
</div>
<input type="submit" value="Add">

</s:form>


<script type="text/javascript">
	document.addEventListener('DOMContentLoaded',function(){
        document.querySelector("#accountType").onchange=function(){
        	
        	if(this.value == 'creditcard' || this.value == 'debitcard' ){
                document.querySelector("#upiId").style.display='none';
                document.querySelector("#accountNumber").style.display='block';
               // document.querySelector("#price").style.display='block';
        	}
        	if(this.value == "cash"){
        		document.querySelector("#upiId").style.display='none';
                document.querySelector("#accountNumber").style.display='none';
                //document.querySelector("#price").style.display='block';
        	}
        	if(this.value == "paytm"){
        		document.querySelector("#upiId").style.display='block';
                document.querySelector("#accountNumber").style.display='none';
               //document.querySelector("#amount").style.display='block';
        	}
		}
	})
	</script>



</body>
</html>