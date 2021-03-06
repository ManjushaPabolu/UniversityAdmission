package com.pro.uas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.uas.dto.Application;
import com.pro.uas.service.UniversityServiceImpl;

@WebServlet("/apply")
public class ApplyApplicationController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		Application ap = new Application();
		UniversityServiceImpl impl = new UniversityServiceImpl();
		
		int applicationid = Integer.parseInt(req.getParameter("applicationid"));
		String name = req.getParameter("name");
		String dateofbirth = req.getParameter(" dateofbirth");
		String qualification = req.getParameter("qualification");
		int marks = Integer.parseInt(req.getParameter("marks"));
		String goals= req.getParameter("goals");
		String emailid= req.getParameter("emailid");
		int programid = Integer.parseInt(req.getParameter("programid"));
		String  status= req.getParameter("status");
		String interviewdate = req.getParameter("interviewdate");
		

		ap.setApplicationid(applicationid);
		ap.setName(name);
		ap.setDateofbirth(dateofbirth);
		ap.setQualification(qualification);
		ap.setMarks(marks);
		ap.setGoals(goals);
		ap.setEmailid(emailid);
		ap.setProgramid(programid);
		ap.setStatus(status);
		ap.setInterviewdate(interviewdate);
		
	    boolean result  = impl.applyApplication(ap);
		if(result)
		{
			RequestDispatcher dis=req.getRequestDispatcher("./appid");
		}
		else
		{
			resp.sendRedirect("Failed.jsp");
		}
	}
}
