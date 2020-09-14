<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Registration</title>
</head>
<body>
<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Weather Status</h1>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form class="form-horizontal" id="regForm" modelAttribute="user"
		action="${pageContext.request.contextPath}/register" method="post">
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="email" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">mobile Number</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="tel" pattern="^[0]{1}[0-9]{10}$" class="form-control" name="mobileNumber" id="mobileNumber"  placeholder="Enter your mobile number"/>
								</div>
							</div>
						</div>
						<div class="form-group ">
							<input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="Register"/>
						</div>
						<div class="login-register">
				            <a href="/">Login</a>
				         </div>
					</form>
				</div>
			</div>
		</div>
<!--  
	<form id="regForm" modelAttribute="user"
		action="${pageContext.request.contextPath}/register" method="post">
		<table align="center">
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>

			<tr>
				<td>Email :</td>
				<td><input type="text" name="email" id="email" /></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><input type="text" name="mobileNumber" id="mobileNumber" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" id="register"
					name="register" /></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="">login</a></td>
			</tr>
		</table>
	</form>-->
</body>
</html>