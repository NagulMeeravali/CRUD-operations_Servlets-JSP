<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page isELIgnored="false"%>
<head>
  <title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TechStart</a>
    </div>
   
    <ul class="nav navbar-nav navbar-right">
      <li><a href="regForm"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="loginForm"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
 
 <c:if test="${msg eq 'login'}">
               <center>Login Form <br>
               <form action="login" method="post">
               <input type=text placeholder="Email id" name="email"> <br>
               <input type=text placeholder="Password" name="pwd"> <br>
               <input type=submit value="Login"> <input type=submit value="Cancle"> 
               </form>
               </center>
 </c:if>
 
  <c:if test="${msg eq 'register'}">
               <center>Sign Up Form <br>
               
               <form action="signUp" method="post">
               <table>
               <tr><td>Student Id : </td><td><input type=text placeholder="Student id" name="sid"></td></tr> 
               <tr><td>First name : </td><td><input type=text placeholder="firstname" name="fname"></td></tr> 
               <tr><td>Last name :</td><td><input type=text placeholder="lastname" name="lname"> </td></tr>
               <tr><td>Email Id :</td><td><input type=text placeholder="email" name="email"> </td></tr>
               <tr><td>Password :</td><td><input type=password placeholder="Password" name="pwd"> </td></tr>
               <tr><td>Mobile :</td><td><input type=text placeholder="mobile" name="mobile"> </td></tr>
               <tr><td>Gender :</td><td><input type=radio name="g">Male <input type=radio name="g">Female </td></tr>
               
               
               
               <tr><td><input type=submit value="Register"></td><td><input type=Reset value="Clear"></td></tr> 
               </table>
               </form>
               ${msg1}
               </center>
 </c:if>
  
</div>

</body>
</html>
