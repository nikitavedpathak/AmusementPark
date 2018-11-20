<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Park Management</title>
</head>
<body>

<h2>${var} </h2>

<form  method="post" action="RegisterServlet">
<h1>Register New User</h1>
		<table>
			<tr>
				<td>CID</td>
				<td><input type="text" name="cid"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Phone No:</td>
				<td><input type="text" name="phoneno"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>

<a href="index.jsp" > Login </a>
</body>
</html>