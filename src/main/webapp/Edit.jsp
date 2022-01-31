<%@page import="com.ty.student.Dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>

<h1 align="center">welcome to  Student Page</h1>

<% Student student =(Student)request.getAttribute("Student");%>

<form action="editStudents" method="post" >

	ID: <input type="text"  name="S_id" value=<%=student.getId() %>>
	name :
	<input type="text" name="S_name" value="<%=student.getName()%>">
	
	Email :<input type="text" name="S_email" value="<%=student.getEmail() %>" >
	
	password :<input type="text" name="S_password" value="<%=student.getPassword()%>">
	
	phone :<input type="text" name="S_phone" value="<%=student.getPhone()%>">
	
	Gender <input type="radio" value="male" name="S_gender" > male
			<input type="radio" value="female" name="S_gender">female
	
	age:<input type="text" name="S_age" value=<%=student.getAge() %>>
	<input type="submit" value="update">
</form>


</body>
</html>