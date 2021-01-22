package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		System.out.println("SearchServlet.SearchServlet():0-param constructor");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("SearchServlet.doGet()");

		res.setContentType("text/html");

		String ss = req.getParameter("ss");
		String engine = req.getParameter("engine");

		String url = null;

		if (engine.equalsIgnoreCase("google")) {
			url = "https://www.google.com/search?q=" + ss;

		} else if (engine.equalsIgnoreCase("yahoo")) {
			url = "https://in.search.yahoo.com/search?p=" + ss;
		} else if (engine.equalsIgnoreCase("Ask")) {
			url = "https://www.ask.com/web?q=" + ss;
		} else if (engine.equalsIgnoreCase("Bing")) {
			url = "https://www.bing.com/search?q=" + ss;
		}

		//		perform sendRedirect() operation
		res.sendRedirect(url);

		//		TestCase::1
		//		Adding one more sendRedirect() method
		//		res.sendRedirect("/abc.html");//throws java.lang.IllegalStateException: Cannot call sendRedirect() after the response has been committed

		
		//		TestCase::2
		//		Adding rd.forward(req,res);
		RequestDispatcher rd = req.getRequestDispatcher("/abc.html");
		//		rd.forward(req, res);//throws java.lang.IllegalStateException: Cannot forward after response has been committed

		
		//		TestCase::3
		//		Adding rd.include(req,res);
		rd.include(req, res);//output of rd.include(req,res) is Nullified onlu o/p of req.sendRedirect() is shown

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("SearchServlet.doPost()");
		doGet(req, res);
	}

}
