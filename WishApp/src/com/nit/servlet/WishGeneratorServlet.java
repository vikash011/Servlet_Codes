package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishGeneratorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

		LocalTime time = LocalTime.now();

		int hour = time.getHour();

		if (hour < 12) {
			pw.println("<h1 align='ceter' style='color:red'>Good Morning</h1>");
		} else if (hour < 14) {
			pw.println("<h1 align='ceter' style='color:red'>Good After Noon</h1>");
		} else if (hour < 18) {
			pw.println("<h1 align='ceter' style='color:red'>Good Evening</h1>");
		} else {
			pw.println("<h1 align='ceter' style='color:red'>Good Night</h1>");
		}

		pw.println("<h1><a href='index.html'>HOME</a></h1>");

		pw.close();
	}

}
