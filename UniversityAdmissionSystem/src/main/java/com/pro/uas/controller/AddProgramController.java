package com.pro.uas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.uas.dto.Programs_Offered;
import com.pro.uas.service.UniversityServiceImpl;


@WebServlet("/add")
public class AddProgramController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		Programs_Offered po = new Programs_Offered();
		UniversityServiceImpl impl = new UniversityServiceImpl();
		String programname = req.getParameter("programname");
		String description = req.getParameter("description");
		String eligibility = req.getParameter("eligibility");
		int duration = Integer.parseInt(req.getParameter("duration"));
		String degreeoffered = req.getParameter("degreeoffered");
		
		
		po.setProgramname(programname);
		po.setDescription(description);
		po.setEligibility(eligibility);
		po.setDuration(duration);
		po.setDegreeoffered(degreeoffered);
		
	    boolean result  = impl.addProgramOffered(po);
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
