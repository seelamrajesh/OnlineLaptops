<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<%@include file="adminheader.jsp" %>
<script>
  var suppler = ${data};
  
  
 
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.supplier=suppler;
                 
 
                 
               
    });
</script>
<!--<c:out value="${check}"></c:out>-->
<div class="container" ng-app="repeatSample" >
<c:choose>
<c:when test="${check}">
	<div class="row">
		<form:form class="form-horizontal" method="post" action="addsup" commandName="Supplier">
			<fieldset>

				<!-- Form Name -->
				<legend>Supplier</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">Supplier
						Id</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" 	path="sid" readonly="false" value="${sid+1}"></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">Supplier
						Name</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="" path="sname"></form:input>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Supplier
						Address</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="saddr" />
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
		<form:form class="form-horizontal" method="post" action="updatesup"	commandName="Supplier">
			<fieldset>

				<!-- Form Name -->
				<legend>Supplier Details</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">Supplier
						Id</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" 	path="sid" readonly="true" ></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">Supplier
						Name</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="" path="sname"></form:input>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Supplier
						Address</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="saddr" />
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
search:<input type="text" placeholder="search supplier" ng-model="searchsup"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
 <tr><th>Supplier Id</th>
<th>Supplier name</th>
<th>Supplier Address</th>
</tr> 
<tr class="success" ng-repeat="sup2 in supplier|filter:searchsup">
                <td>{{sup2.sid}}</td> 
                 <td>{{sup2.sname}}</td>
                 <td>{{sup2.saddr}}</td>
                
                     <td><a href="updatesup?sid={{sup2.sid}}">Edit</a></td>
                <td><a href="deletesup?sid={{sup2.sid}}">Delete</a></td>
                
</tr>
</table>
</div>
	</div>

</div>
<%@include file="footer.jsp" %>