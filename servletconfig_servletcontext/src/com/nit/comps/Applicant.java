package com.nit.comps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Applicant extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("Applicant.doGet()");
//		set response content Type
		res.setContentType("text/html");
		
//		creating PrintWriter object
		PrintWriter pw = res.getWriter();
		
//		getting servlet Config object(or)
		ServletConfig cg = getServletConfig();
		String servletconfigName = cg.getInitParameter("email");
		
		/*
		String servletconfigName = getServletConfig().getInitParameter("email");
		
		*/
//		getting servlet context object(or)
		ServletContext sc = getServletContext();
	    String servletcontextName = sc.getInitParameter("web-site");
	    
		/*
		String servletcontextName = getServletContext().getInitParameter("web-site");
		*
		*/
	    
	    pw.println("<h1 align='center'>Web-site Name::"+servletcontextName+"</h1>"); 
	    pw.println("<h2 align='center'> Email::"+servletconfigName+"</h2>");

//	    closing PrintWriter Object
	    pw.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Applicant.doPost()"); 
		doGet(req,res);
	}
	

}
