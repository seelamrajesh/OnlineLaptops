<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<jsp:include page="/WEB-INF/views/adminheader.jsp"/>
<script>
  var catgry = ${data};
  var supp = ${data2};
  var prod = ${data3};
  
 
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.category=catgry;
                 $scope.supplier=supp;
                 $scope.product=prod;
 
                 
               
    });
</script>
<!--<c:out value="${check}"></c:out>-->
<div class="container" ng-app="repeatSample" >
<c:choose>
<c:when test="${check}">
	<div class="row">
		<form:form class="form-horizontal" method="post" action="addproduct"	commandName="Product">
			<fieldset>

				<!-- Form Name -->
				<legend>Product Details</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">Product
						Id</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" 	path="pid" readonly="false" value="${pid+1}"></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">Product
						Name</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="" path="pname"></form:input>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Product
						Description</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="pdes" />
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Supplier
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="supId" >
							<form:option value="-1">Select Supplier Name </form:option>
							<form:option ng-repeat="sup in supplier" value="{{sup.sid}}">{{sup.sname}}</form:option>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Category
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="catId" >
							<form:option value="-1">Select category Name</form:option>
							<form:option ng-repeat="cat in category"
								value="{{cat.cid}}">{{cat.cname}}</form:option>
						</form:select>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Stock/Quantity</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="pstock"></form:input>

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Price</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="pprice"></form:input>

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
		<form:form class="form-horizontal" method="post" action="Updateprod"	commandName="Product">
			<fieldset>

				<!-- Form Name -->
				<legend>Product Details</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">Product
						Id</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" 	path="pid" readonly="true" ></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">Product
						Name</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="" path="pname"></form:input>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Product
						Description</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="pdes" />
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Supplier
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="supId" >
							<form:option value="-1">Select Supplier Name </form:option>
							<form:option ng-repeat="sup in supplier" value="{{sup.supId}}">{{sup.supName}}</form:option>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Category
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="catId" >
							<form:option value="-1">Select category Name</form:option>
							<form:option ng-repeat="cat in category"
								value="{{cat.id}}">{{cat.name}}</form:option>catId
						</form:select>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Stock/Quantity</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="pstock"></form:input>

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Price</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="pprice"></form:input>

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
search:<input type="text" placeholder="search category" ng-model="searchprd"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
 <tr><th>Product Id</th>
<th>Product name</th>
<th>Supplier Id</th>
<th>Category Id</th>
<th>Stock</th>
<th>Price</th>
<th>Edit</th>
<th>Delete</th>

</tr> 
<tr class="success" ng-repeat="ad in product|filter:searchprd">
                <td>{{ad.pid}}</a></td> 
                 <td>{{ad.pname}}</td>
                <td>{{ad.supId}}</td>
                <td> {{ad.catId}}</td>
                <td> {{ad.pstock}}</td>
                <td> {{ad.pprice}}</td>
                     <td><a href="Updateprod?pid={{ad.pid}}">Edit</a></td>
                <td><a href="deleteprod?pid={{ad.pid}}">Delete</a></td>
                 
</tr>
</table>
</div>
	</div>

</div>
