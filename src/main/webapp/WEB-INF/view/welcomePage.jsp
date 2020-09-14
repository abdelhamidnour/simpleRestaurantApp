<%@page session="false"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
<%-- 	<jsp:include page="_menu.jsp" />
 --%>	<h1>Message : ${message}</h1>
	<table align="center">
		<tr>
			<td><input type="button" value="Login"
				onclick="window.location.href='showMyLoginPage';return false;">
				</button></td>
			<td><input type="button" value="registerPage"
				onclick="window.location.href='registerPage';return false;">
				</button></td>
		</tr>
	</table>


</body>
</html>