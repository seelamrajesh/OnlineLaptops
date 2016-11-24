<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<title>Product</title>
<jsp:include page="header.jsp"/>
</head>
<body>
<script>
var prod = ${data3};
  
  
 
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
	           $scope.product=prod;               
    });
</script>
<!--<c:out value="${check}"></c:out>-->
<div class="container" ng-app="repeatSample" >
<div  ng-controller="repeatController" >
	<div>
search:<input type="text" placeholder="search products" ng-model="searchprd"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
 <tr><th>Product Id</th>
<th>Product name</th>
<th>Stock</th>
<th>Price</th>
<th></th>
</tr> 
<tr class="success" ng-repeat="ad in product|filter:searchpro">
                <td>{{ad.pid}}</a></td> 
                 <td>{{ad.pname}}</td>
                <td> {{ad.pstock}}</td>
                <td> {{ad.pprice}}</td>
                     <td><a href="moreinfo">See More Info </a></td>
                 
</tr>
</table>
</div>
	</div>

</div>
<br>
<br>
      <jsp:include page="footer.jsp"/>
               </body>
               </html>
              
				