package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s3url")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet3() {
		System.out.println("Servlet3.Servlet1()-0 param constructor");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet3.doGet()");

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

		//	    reading Request Attribute
		pw.println("servlet3::" + req.getAttribute("attr1"));
		pw.println("servlet3::" + req.getAttribute("val1"));
		pw.println("</br>");
		
//		reading session Attribute
		HttpSession ses = req.getSession();
		pw.println("servlet3::"+ses.getAttribute("attr2"));
		pw.println("servlet3::"+ses.getAttribute("val2"));
	
		pw.print("<br/>");
//		reading application attribute
		ServletContext sc = getServletContext();
		pw.println("servlet3::"+sc.getAttribute("attr3"));
		pw.println("servlet3::"+sc.getAttribute("val3"));
		
		pw.close();

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet3.doPost()");
		doGet(req, res);
	}

}
