package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// set Response ContentType
		resp.setContentType("text/Html");

		// creating PrintWriter stream object
		PrintWriter pw = resp.getWriter();

		// read form data
		String pval = req.getParameter("s1");

		// Locale class Object
		Locale[] locale = Locale.getAvailableLocales();

		if (pval.equalsIgnoreCase("country")) {
			pw.println("<h1 align='center' style='color:red'>All Countries::</h1>");
			for (Locale l : locale) {
				pw.println("<h2 style='color:blue'>" + l.getDisplayCountry() + "</h2>");
			}

		} else if (pval.equalsIgnoreCase("language")) {
			pw.println("<h1 align='center' style='color:red'>All Languages::</h1>");
			for (Locale l : locale) {
				pw.println("<h2 style='color:blue'>" + l.getDisplayLanguage() + "</h2>");
			}
		} else if(pval.equalsIgnoreCase("properties")) {
			pw.println("<h1 align='center' style='color:red' >System Properties::</h1>");
			pw.println("<h2>" + System.getProperties() + "</h2>");
		}

		// closing PrintWriter stream object
		pw.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
