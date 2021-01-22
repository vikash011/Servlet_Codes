package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet2() {
		System.out.println("Servlet2.Servlet1()-0 param constructor");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet2.doGet()");

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

		//	    creating RequestDispatcher object
		RequestDispatcher rd = req.getRequestDispatcher("/s3url");

		//	    reading Request Attribute
		pw.println("servlet2::" + req.getAttribute("attr1"));
		pw.println("servlet2::" + req.getAttribute("val1"));
		
		pw.print("<br/>");

		//	    reading session Attribute
		HttpSession ses =req.getSession();
		pw.println("servlet2::" + ses.getAttribute("attr2"));
		pw.println("servlet2::" + ses.getAttribute("val2"));
		pw.print("<br/>");
		
		
		
//		reading application attribute
		ServletContext sc = getServletContext();
		pw.println("servlet2::"+sc.getAttribute("attr3"));
		pw.println("servlet2::"+sc.getAttribute("val3"));

		//	    forwarding request to servlet3
		rd.forward(req, res);

		pw.close();

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet2.doPost()");
		doGet(req, res);
	}

}
