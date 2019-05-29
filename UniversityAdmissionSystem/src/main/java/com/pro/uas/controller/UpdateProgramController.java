package com.pro.uas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.uas.dto.Programs_Offered;
import com.pro.uas.dto.Users;
import com.pro.uas.service.UniversityServiceImpl;

@WebServlet("/updateprogoffer")
public class UpdateProgramController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Programs_Offered po=new Programs_Offered();
		resp.setContentType("text/html");
		UniversityServiceImpl impl=new UniversityServiceImpl();
		
		String description = req.getParameter("description");
		String eligibility = req.getParameter("eligibility");
		int duration = Integer.parseInt(req.getParameter("duration"));
		String degreeoffered = req.getParameter("degreeoffered");
		String programname = req.getParameter("programname");
		 
		po.setDescription(description);
		po.setEligibility(eligibility);
		po.setDuration(duration);
		po.setDegreeoffered(degreeoffered);
		po.setProgramname(programname);		 
		boolean result  = impl.updateProgramOffered(po) ;
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
