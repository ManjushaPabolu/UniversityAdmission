package com.pro.uas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.uas.dao.UniversityDAOImpl;
import com.pro.uas.dto.Users;
import com.pro.uas.service.UniversityServiceImpl;


@WebServlet("/deleteoffer")
public class DeleteProgramController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UniversityDAOImpl  impl = new UniversityDAOImpl();
		String programname = req.getParameter("programname");
		boolean result = impl.deleteProgramOffered(programname);
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
