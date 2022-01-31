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

public class GetStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		int sid=Integer.parseInt(id);
		StudentDao Dao = new StudentDao();
		 Student student=Dao.getUserById(sid);
		 		req.setAttribute("Student",student ); 
		 RequestDispatcher rd=req.getRequestDispatcher("Edit.jsp");
		 rd.forward(req, resp);
	}

}
