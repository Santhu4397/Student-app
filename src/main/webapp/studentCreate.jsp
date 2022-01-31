<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
</head>
<body>
<table>

<%@ include file="Navbar.jsp" %>
<h1 align="center">welcome to  Student Page</h1>
<form action="create" method="post">
	<tr>
	<td>name :</td>
	<td><input type="text" name="S_name">
	</td>
	</tr>
	<tr>
	<td>
	Email :</td><td><input type="text" name="S_email"></td></tr>
	<tr>
	<td>
	password :</td><td><input type="text" name="S_password"></td></tr>
	<tr>
	<td>
	phone :</td><td><input type="text" name="S_phone"></td></tr>
	<tr>
	<td><div>
	Gender :</td><td><input type="radio" value="male" name="S_gender"> </td>male</tr>
			<input type="radio" value="female" name="S_gender">female</td></tr>
		<tr>
		<td>
	age:</td><td><input type="text" name="S_age"></td></tr>
	<td><input type="submit" value="Create"></td></div>
</form>
</table>
</body>
</html>