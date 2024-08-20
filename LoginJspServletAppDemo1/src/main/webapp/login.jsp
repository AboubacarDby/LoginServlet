<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="center">
		<h1> Login Formulaire</h1>
	<form action="<%=request.getContextPath()%>/login" method="POST">
		<table>
			<tr>
			
				<td>Username:</td>
				<td><input type="text" name="username" required></td>
		
			</tr>
			<tr>
			
				<td>Password:</td>
				<td><input type="text" name="password" required></td>
		
			</tr>
			
			<tr>
			
				<td colspan="2" style = "color : red;">
				<% if(request.getAttribute("errorMessage") != null){ %>
					<%=request.getAttribute("errorMessage") %>
				<% } %>
				</td>
		
			</tr>
	
		</table>
		<input type="submit" value="Submit">
		</form>
	
	
	</div>
</body>
</html>