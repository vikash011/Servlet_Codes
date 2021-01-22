package com.nit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet1() {
		System.out.println("Servlet1.Servlet1()-0 param constructor");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet1.doGet()");

		res.setContentType("text/html");

		//		creating Request Attribute
		req.setAttribute("attr1", "attr1");
		req.setAttribute("val1", "val1");

		
//		creating Session Attribute
		HttpSession ses = req.getSession();
		ses.setAttribute("attr2", "attr2");
		ses.setAttribute("val2", "val2");
		
		
		ServletContext sc = getServletContext();
		sc.setAttribute("attr3", "attr3");
		sc.setAttribute("val3", "val3");
		
		
		
		
		//	    creating RequestDispatcher object
		RequestDispatcher rd = req.getRequestDispatcher("/s2url");
	

		//	    forwarding request to servlet2
		rd.forward(req, res);
		
		
		
		

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet1.doPost()");
		doGet(req, res);
	}

}
