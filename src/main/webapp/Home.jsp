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
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Sort by Name <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">ASC Order</a></li>
          <li><a href="#">DESC order</a></li>
        </ul>
      </li>
      <li><a href="viewAll">View All Students</a></li>
    </ul>
    
  </div>
</nav>
  
<div class="container">
 Welcome ${u}  <br><br>
 
 <input type=text name="search"> <input type=submit value="Search"> <br><br>
  <c:if test="${msg eq 'viewall'}">
    <table border=2 width=70% height=10%>
    <tr><td>First Name</td> <td>Last Name</td><td>Email </td> <td>Gender</td><td>Mobile</td><td>Password</td><td colspan="2">Actions</td></tr>
     <c:forEach items="${students}" var="student">
        <tr><td>${student.getFname()}</td><td>${student.getLname()}</td><td>${student.getEmail()}</td><td>${student.getGender()}</td>
        <td>${student.getMobile()}</td><td>${student.getPassword()}</td><td><a href="reqDelete?id=+${student.getSid()}">Delete</a></td><td><a href="updateForm?id=+${student.getSid()}">Update</a></td></tr>
        
    </c:forEach>
      </table>
  </c:if>
  
  <c:if test="${msg eq 'updateform'}">
              <form action="update" method="post">
               <table>
               <tr><td>Student Id : </td><td><input type=text value=${student.getSid()} name="sid" readonly></td></tr> 
               <tr><td>First name : </td><td><input type=text placeholder="firstname" name="fname"></td></tr> 
               <tr><td>Last name :</td><td><input type=text placeholder="lastname" name="lname"> </td></tr>
               <tr><td>Email Id :</td><td><input type=text placeholder="email" name="email"> </td></tr>
               <tr><td>Password :</td><td><input type=password placeholder="Password" name="pwd"> </td></tr>
               <tr><td>Mobile :</td><td><input type=text placeholder="mobile" name="mobile"> </td></tr>
               <tr><td>Gender :</td><td><input type=radio name="g">Male <input type=radio name="g">Female </td></tr>
               
               
               
               <tr><td><input type=submit value="Update"></td><td><input type=Reset value="Clear"></td></tr> 

 </c:if>
 
</div>

</body>
</html>
