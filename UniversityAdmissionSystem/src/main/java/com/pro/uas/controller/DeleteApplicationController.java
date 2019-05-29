package com.pro.uas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.uas.dto.Application;
import com.pro.uas.service.UniversityServiceImpl;

@WebServlet("/applicationdelete")
public class DeleteApplicationController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		UniversityServiceImpl service=new UniversityServiceImpl();
		Application a=new Application();
		
		int applicationid=Integer.parseInt(req.getParameter("applicationid"));
		
		boolean result=service.deleteApplication(applicationid);
	    if(result)
		{
			
			out.print("<h1>"+" application rejected"+"</h1>");
		}else
		{
			out.print("<h1>"+"application not rejected"+"</h1>");
		}
	}
	
}
