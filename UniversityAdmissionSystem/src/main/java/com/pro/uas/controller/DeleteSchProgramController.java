package com.pro.uas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.uas.dao.UniversityDAOImpl;

@WebServlet("/schdelete")
public class DeleteSchProgramController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		resp.setContentType("text/html");
		UniversityDAOImpl  impl = new UniversityDAOImpl();
		int programId= Integer.parseInt(req.getParameter("programId"));
		boolean result = impl.deleteScheduledProgram(programId);
		if(result)
		{
			resp.sendRedirect("Success.jsp");
		}
		else
		{
			resp.sendRedirect("Failed.jsp");
		}
	}
}
