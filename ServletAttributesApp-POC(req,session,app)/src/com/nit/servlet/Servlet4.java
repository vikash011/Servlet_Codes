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

@WebServlet("/s4url")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet4() {
		System.out.println("Servlet4.Servlet4()-0 param constrcutor");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet4.doGet()");

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

		//		getting Request Attribute
		pw.print("servlet4::" + req.getAttribute("attr1"));
		pw.print("servler4::" + req.getAttribute("val1"));
		pw.print("<br/>");

		//       reading session Attribute
		HttpSession ses = req.getSession();
		pw.println("servlet4::" + ses.getAttribute("attr2"));
		pw.println("servlet4::" + ses.getAttribute("val2"));
		
		pw.print("<br/>");
//		reading application attribute
		ServletContext sc = getServletContext();
		pw.print("servlet4::"+sc.getAttribute("attr3"));
		pw.print("servlet4"+sc.getAttribute("val3"));
		
		
		
		pw.close();

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet4.doPost()");
		doGet(req, res);
	}

}
