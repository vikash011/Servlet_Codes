package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter pw = res.getWriter();

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

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("SearchServlet.doPost()");
		doGet(req, res);
	}

}
