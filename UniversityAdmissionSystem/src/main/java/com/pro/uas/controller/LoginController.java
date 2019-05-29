package com.pro.uas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.uas.dto.Users;
import com.pro.uas.service.UniversityServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	PrintWriter out= resp.getWriter();
	resp.setContentType("text/html");
	
	String login_id=req.getParameter("login_id");
	String password=req.getParameter("password");
	String role=req.getParameter("role");
	
	UniversityServiceImpl service=new UniversityServiceImpl();
	Users us= service.login(login_id, password, role);
	
	if(us.getRole().equalsIgnoreCase("Admin")) {
		HttpSession session=req.getSession();
		req.setAttribute("Admin", us);
		RequestDispatcher dis=req.getRequestDispatcher("/Homepage.jsp");
		dis.forward(req, resp);
	}
	else if(us.getRole().equalsIgnoreCase("MAC"))
	{
		HttpSession session=req.getSession();
		req.setAttribute("MAC", us);
		RequestDispatcher dis=req.getRequestDispatcher("/HomepageMAC.jsp");
		dis.forward(req, resp);
	}
	else {
		resp.sendRedirect("./login.jsp");
	}
		 
}
	
}
