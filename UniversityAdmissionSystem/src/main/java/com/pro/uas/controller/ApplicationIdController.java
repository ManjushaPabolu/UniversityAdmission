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

@WebServlet("/appid")
public class ApplicationIdController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out = resp.getWriter();
		Application a=new Application();
		UniversityServiceImpl service=new UniversityServiceImpl();
	int applicationid=	service.getapplicationId(a.getEmailid());
	out.print("<h1>"+"your have successfully registered,your application id is"+applicationid+"</h1>");
	
	
	
	}
}
