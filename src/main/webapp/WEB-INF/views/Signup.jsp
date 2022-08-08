<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>  	
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
	
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
.register{
    background: -webkit-linear-gradient(left, #3931af, #00c6ff);
    margin-top: 3%;
    padding: 3%;
}
.register-left{
    text-align: center;
    color: #fff;
    margin-top: 4%;
}
.register-left input{
    border: none;
    border-radius: 1.5rem;
    padding: 2%;
    width: 60%;
    background: #f8f9fa;
    font-weight: bold;
    color: #383d41;
    margin-top: 30%;
    margin-bottom: 3%;
    cursor: pointer;
}
.register-right{
    background: #f8f9fa;
    border-top-left-radius: 10% 50%;
    border-bottom-left-radius: 10% 50%;
}
.register-left img{
    margin-top: 15%;
    margin-bottom: 5%;
    width: 25%;
    -webkit-animation: mover 2s infinite  alternate;
    animation: mover 1s infinite  alternate;
}
@-webkit-keyframes mover {
    0% { transform: translateY(0); }
    100% { transform: translateY(-20px); }
}
@keyframes mover {
    0% { transform: translateY(0); }
    100% { transform: translateY(-20px); }
}
.register-left p{
    font-weight: lighter;
    padding: 12%;
    margin-top: -9%;
}
.register .register-form{
    padding: 10%;
    margin-top: 10%;
}
.btnRegister{
    float: right;
    margin-top: 10%;
    border: none;
    border-radius: 1.5rem;
    padding: 2%;
    background: #0062cc;
    color: #fff;
    font-weight: 600;
    width: 50%;
    cursor: pointer;
}
.register .nav-tabs{
    margin-top: 3%;
    border: none;
    background: #0062cc;
    border-radius: 1.5rem;
    width: 28%;
    float: right;
}
.register .nav-tabs .nav-link{
    padding: 2%;
    height: 34px;
    font-weight: 600;
    color: #fff;
    border-top-right-radius: 1.5rem;
    border-bottom-right-radius: 1.5rem;
}
.register .nav-tabs .nav-link:hover{
    border: none;
}
.register .nav-tabs .nav-link.active{
    width: 100px;
    color: #0062cc;
    border: 2px solid #0062cc;
    border-top-left-radius: 1.5rem;
    border-bottom-left-radius: 1.5rem;
}
.register-heading{
    text-align: center;
    margin-top: 8%;
    margin-bottom: -15%;
    color: #495057;
}

</style>
</head>

<body>


<%-- <s:form action="saveuser" method="post" modelAttribute="user">
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
 --%>






<s:form action="saveuser" method="post" modelAttribute="user">
<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h3>Welcome</h3>
                        <p>It's a list of tasks you need to complete or things that you want to do.!</p>
                        <a class="btn btn-primary" href="login">Login</a><br>
                     
                        
                    </div>
                        
                    <div class="col-md-9 register-right">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">SignUp Page</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <s:input path="firstName" class="form-control"  placeholder="First Name *"  />
                                            <s:errors path="firstName"></s:errors>
                                        </div>
                                        
                                        <div class="form-group">
                                            <s:input path="lastName" class="form-control"  placeholder="Last Name *"/>
                                            <s:errors path="lastName"></s:errors>   
                                        </div>
                                  
                                        
                                      
                                        
                                        <div class="form-group">
                                            <div class="maxl">
                                            Gender:
                                                <label  class="radio inline"> 
                                                    <s:radiobutton path="gender" value="male"/>
                                                    <span> Male </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <s:radiobutton path="gender" value="female"/>
                                                    <span>Female </span> 
                                                </label>
                                                
                                            </div>
                                        </div>
                                    </div>                 
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <s:input path="email" class="form-control" placeholder="Your Email *" />
                                            <s:errors path="email"></s:errors>
                                        </div>
                                        <div class="form-group">
                                            <s:password path="password" class="form-control"  placeholder="Password *"/>
                                            <s:errors path="password"></s:errors>
                                        </div>
                                       
                                       
                                        <input type="submit" class="btnRegister"  value="Register"/>
                                        
                                       
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
            
           </s:form>
           
           
</body>
</html>