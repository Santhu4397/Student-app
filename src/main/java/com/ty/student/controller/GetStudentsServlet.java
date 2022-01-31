package com.ty.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.student.Dao.StudentDao;
import com.ty.student.Dto.Student;

public class GetStudentsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDao  dao=new StudentDao();
		List<Student> students =dao.getAllUser();
		
	
		req.setAttribute("students", students);
		
		System.out.println("getusersservlet is called");
		RequestDispatcher dispatcher=req.getRequestDispatcher("Displaystudents.jsp");
		dispatcher.forward(req, resp);
	}

}
