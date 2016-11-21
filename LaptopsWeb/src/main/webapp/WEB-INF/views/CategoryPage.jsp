<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<%@include file="adminheader.jsp" %>
<script>
  var catgry = ${data};
  
  
 
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.category=catgry;
                 
 
                 
               
    });
</script>
<!--<c:out value="${check}"></c:out>-->
<div class="container" ng-app="repeatSample" >
<c:choose>
<c:when test="${check}">
	<div class="row">
		<form:form class="form-horizontal" method="post" action="addcat" commandName="Category">
			<fieldset>

				<!-- Form Name -->
				<legend>Category1</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">Category
						Id</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" 	path="cid" readonly="false" value="${cid+1}"></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">Category
						Name</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="" path="cname"></form:input>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Category
						Description</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="cdescription" />
					</div>
				</div>

				

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">

						<input type="submit" class="btn btn-lg btn-info" value="submit"></input>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>
	
</c:when>
<c:otherwise >

	<div class="row">
		<form:form class="form-horizontal" method="post" action="updatecat"	commandName="Category">
			<fieldset>

				<!-- Form Name -->
				<legend>Category Details</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">Category
						Id</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" 	path="cid" readonly="true" ></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">Category
						Name</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="" path="cname"></form:input>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Category
						Description</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="cdescription" />
					</div>
				</div>

				
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">

						<input type="submit" class="btn btn-lg btn-info" value="submit"></input>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>


</c:otherwise>

</c:choose>
<div  ng-controller="repeatController" >
	<div>
search:<input type="text" placeholder="search category" ng-model="searchcat"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
 <tr><th>Category Id</th>
<th>Category name</th>
<th>Category Description</th>
</tr> 
<tr class="success" ng-repeat="cat2 in category|filter:searchcat">
                <td>{{cat2.cid}}</td> 
                 <td>{{cat2.cname}}</td>
                 <td>{{cat2.cdescription}}</td>
                
                     <td><a href="updatecat?cid={{cat2.cid}}">Edit</a></td>
                <td><a href="deletecat?cid={{cat2.cid}}">Delete</a></td>
                
</tr>
</table>
</div>
	</div>

</div>
<%@include file="footer.jsp" %>