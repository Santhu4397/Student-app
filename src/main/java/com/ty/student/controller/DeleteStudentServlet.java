package com.ty.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.student.Dao.StudentDao;

public class DeleteStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		int userid=Integer.parseInt(id);
		StudentDao  dao=new StudentDao();
		PrintWriter pw=resp.getWriter();
		boolean s=dao.delete(userid);
		if(s == true) {
			pw.print("<html><body><h1>User deleted</h1></body></html>");
		}else {
			pw.print("<html><body><h1>User not deleted</h1></body></html>");
		}
		
	}

}
