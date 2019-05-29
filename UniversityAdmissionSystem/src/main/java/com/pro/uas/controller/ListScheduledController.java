package com.pro.uas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.uas.dto.Programs_Scheduled;
import com.pro.uas.service.UniversityServiceImpl;
@WebServlet("/listsch")
public class ListScheduledController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		UniversityServiceImpl impl=new UniversityServiceImpl();
	List<Programs_Scheduled>lso=impl.listAllScheduledPrograms();
		
	 
	if(lso!=null)
{
		out.print(lso);
	 
}
	else
	{
		out.print("<h1>"+"something went wrong"+"</h1>");
	}
	}
	
}
