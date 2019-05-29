package com.pro.uas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.uas.dto.Programs_Scheduled;
import com.pro.uas.service.UniversityServiceImpl;


@WebServlet("/schadd")
public class AddSchProgramCotroller extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		Programs_Scheduled ps = new Programs_Scheduled();
		UniversityServiceImpl impl = new UniversityServiceImpl();
				
		DateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		
		int programId = Integer.parseInt(req.getParameter("programId"));
		String programName=req.getParameter("programName");
		String location=req.getParameter("location");
		String date = sdf.format(ps.getStartdate());
		Date d1=null;
		Date d2=null;
		try {
		d1= sdf.parse(date); 
		String date1 = sdf.format(ps.getEnddate());
		d2= sdf.parse(date); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		int sessionperweek = Integer.parseInt(req.getParameter("sessionsPerWeek"));
		
		ps.setProgramid(programId);
		ps.setProgramname(programName);
		ps.setLocation(location);
		ps.setStartdate((java.sql.Date) d1);
		ps.setEnddate((java.sql.Date)d2);
		ps.setSessionsperweek(sessionperweek);
		
	    boolean result  = impl.createScheduledProgram(ps);
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
