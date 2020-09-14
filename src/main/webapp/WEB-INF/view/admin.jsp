<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
<title>Admin DashBoard</title>

</head>

<body>


	<div id="wrapper">
		<div id="header">
			<h2>Admin DashBoard</h2>
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

				<!-- loop over and print our customers -->
				<c:forEach var="tempNote" items="${notes}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/admin/updateform">
						<c:param name="status" value="${tempNote.status}" />
					</c:url>

					<tr>
						<td>${tempNote.status}</td>
						<td>${tempNote.temperature}</td>
						<td>${tempNote.note}</td>
						<td>${tempNote.createDate}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>
		
	</div>

	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>

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
</html>









