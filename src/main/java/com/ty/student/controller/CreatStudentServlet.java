package com.ty.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.student.Dao.StudentDao;
import com.ty.student.Dto.Student;

public class CreatStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student student = new Student();
		String name=req.getParameter("S_name");
		String email=req.getParameter("S_email");
		String pass=req.getParameter("S_password");
		String gender=req.getParameter("S_gender");
		String phone=req.getParameter("S_phone");
		String age=req.getParameter("S_age");
		
		student.setName(name);
		student.setEmail(email);
		student.setPassword(pass);
		student.setPhone(Integer.parseInt(phone));
		student.setAge(Integer.parseInt(age));
		student.setGender(gender);
		StudentDao Dao = new StudentDao();
		 Dao.saveUser(student);
		 PrintWriter p=resp.getWriter();
		 p.print("<html><body><h1>User Created</h1></body></html>");
		 
		 RequestDispatcher rd=req.getRequestDispatcher("CreateStudentServlet.jsp");
		 rd.include(req, resp);
		
	}

}
