<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<style type="text/css">
@media ( min-width : 1200px) .container {
	width
	:
	1300px;
	
    
}

@media ( min-width : 992px) .col-md-4 {
	margin-left
	:
	330px;
	
    
}
</style>
</head>
<body>
	
	<div class="container" style="margin-top: 30px">
		<div class="col-md-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title" align="center">Sign In</h3>
				</div>
				<div class="panel-body">
				
					
					
					
				<form name="loginForm"
					 method="post">
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="E-mail"
								name="j_username" type="email">
						</div>
						<div class="form-group">
							<input class="form-control" placeholder="Password"
								name="j_password" type="password">
						</div>
						
						<!-- Change this to a button or input when using this as a form -->
						<div id="button">
							<button type="submit" class="btn btn-sm btn-success"
								style="margin-right: 79px; margin-left: 60px">Login</button>
							
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>

	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"/>