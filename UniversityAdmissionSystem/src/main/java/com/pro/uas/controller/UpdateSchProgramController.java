package com.pro.uas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.uas.dto.Programs_Scheduled;
import com.pro.uas.service.UniversityServiceImpl;


@WebServlet("/progoschdupdate")
public class UpdateSchProgramController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		Programs_Scheduled ps=new Programs_Scheduled();
		resp.setContentType("text/html");
		UniversityServiceImpl impl=new UniversityServiceImpl();
		DateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		
		String programName=req.getParameter("programName");
		String location=req.getParameter("location");
		String date = sdf.format(ps.getStartdate());
		java.util.Date d1=null;
		java.util.Date d2=null;
		try {
			d1= sdf.parse(date); 
			String date1 = sdf.format(ps.getEnddate());
			d2= sdf.parse(date); 
			}catch(Exception e) {
				e.printStackTrace();
			}
			int sessionperweek = Integer.parseInt(req.getParameter("sessionsPerWeek"));
			
			  boolean result=impl.updateScheduledProgram(ps);
			  if(result)
			  {
				  out.print("<h1>"+"scheduled program updated"+"</h1>");
				}else
				{
					out.print("<h1>"+"scheduled program not updated"+"</h1>");
				}
	}
	
}
