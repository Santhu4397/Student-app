<%@page import="com.ty.student.Dto.Student"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display student</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
	<%
	List<Student> Students= (List<Student>)request.getAttribute("students");
	%>

	<table border="1" title="User table">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>email</th>
			<th>Phone</th>
			<th>gender</th>
			<th>age</th>
			<th>delete</th>
			<th>edit</th>
		</tr>
		
		<%
				for(Student user : Students) {
				%>
			
			<tr>
				<td><%=user.getId() %></td>
				<td><%=user.getName() %></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getPhone() %></td>
				<td><%=user.getGender() %></td>
				<td><%=user.getAge() %></td>
				<td><a href="delete?id=<%=user.getId()%>">Delete</a></td>
				<td><a href="edit?id=<%=user.getId() %>">Edit</a></td>
			</tr>
			
	<%
		}
	%>
		
	</table>
</body>
</html>