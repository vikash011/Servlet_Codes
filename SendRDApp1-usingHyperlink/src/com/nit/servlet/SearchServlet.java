package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl1")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		System.out.println("SearchApp.SearchApp()::0-param Constructor");

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("SearchApp.doGet()");
		PrintWriter pw = null;
//       getting PrintWriter
		pw = res.getWriter();

//		set ContentType
		res.setContentType("text/html");

		//		storing input String
		String iString = req.getParameter("ss");

//		destination Se
		pw.print("<h1><a href='https://www.google.com/search?q="+iString+"'>Go to Google</a></h1>");
       
		pw.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("SearchApp.doPost()");
		doGet(req, res);
	}

}
