<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TechnoWorld</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">		

</head>
<body>

		
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
 
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
      
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Products<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="ProductPage">AddProducts</a></li>
          <li><a href="ProductPage">DeleteProducts</a></li>
          <li><a href="ProductPage">UpdateProducts</a></li>
          
        </ul>
      </li>
      
      
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="CategoryPage">AddCategory</a></li>
          <li><a href="CategoryPage">DeleteCategory</a></li>
          <li><a href="CategoryPage">UpdateCategory</a></li>
          
        </ul>
      </li>
      
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="SupplierPage">AddSuplier</a></li>
          <li><a href="SupplierPage">DeleteSupplier</a></li>
          <li><a href="SupplierPage">UpdateSupplier</a></li>
        </ul>
      </li>
     
     <li><a href="login">Login</a></li>
      <li><a href="register">Register</a></li>
      
    </ul>
  </div>
</nav>
  
</body>
</html>