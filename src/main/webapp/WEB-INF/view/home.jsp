<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
<title>Weather Status</title>

<style type="text/css">
html, body {
	margin-left: 15px;
	margin-right: 15px;
	padding: 0px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}

table {
	border-collapse: collapse;
	border-bottom: 1px solid gray;
	font-family: Tahoma, Verdana, Segoe, sans-serif;
	width: 72%;
}

th {
	border-bottom: 1px solid gray;
	background: none repeat scroll 0 0 #09c332;
	padding: 10px;
	color: #FFFFFF;
}

tr {
	border-top: 1px solid gray;
	text-align: center;
}

tr:nth-child(even) {
	background: #FFFFFF
}

tr:nth-child(odd) {
	background: #BBBBBB
}

#wrapper {
	width: 100%;
	margin-top: 0px;
}

#header {
	width: 70%;
	background: #09c332;
	margin-top: 0px;
	padding: 15px 0px 15px 15px;
}

#header h2 {
	width: 100%;
	margin: auto;
	color: #FFFFFF;
}

#container {
	width: 100%;
	margin: auto
}

#container h3 {
	color: #000;
}

#container #content {
	margin-top: 20px;
}
</style>
</head>

<body>
	<h2>Weather Status</h2>
	<hr>

	<p>Welcome to Weather Status APP</p>

	<hr>

	<!-- display user name and role -->

	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>

	<div id="wrapper">
		<div id="header">
			<h2>Home</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Status</th>
					<th>Temperature(Celsius)</th>
					<th>Note</th>
					<th>Note Date</th>
				</tr>
				<tr>
					<td>${noteobj.status}</td>
					<td>${noteobj.temperature}</td>
					<td>${noteobj.note}</td>
					<td>${noteobj.createDate}</td>
				</tr>

			</table>

		</div>
	</div>


	<hr>

	<p>
		<a href="${pageContext.request.contextPath}/admin">Admin Dash</a>
		(Only for Admin)
	</p>


	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>

</body>

</html>









