package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/testurl")
//@WebServlet(value="/testurl")
//@WebServlet(urlPatterns = "/testurl")
//@WebServlet(urlPatterns  = {"/testurl1","/testurl2"})
//@WebServlet(value= {"/testurl1","/testurl2"},name ="test",loadOnStartup = 1)
@WebServlet(urlPatterns = "/testurl", name = "test", loadOnStartup = 1, initParams = {
		@WebInitParam(name = "p1", value = "v1"), @WebInitParam(name = "p2", value = "v2") })

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet() {
		System.out.println("TestServlet.TestServlet()");

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("TestServlet.doGet()");

		//		setting Response ContentType
		res.setContentType("text/html");

		//		getting PrintWriter object
		PrintWriter pw = res.getWriter();

		pw.println("<h1 align='center' style='color:red'>Annotation Project</h1>");

		pw.println("<h2>Date and Time::" + new Date() + "</h2>");

		ServletConfig sc = getServletConfig();

		pw.println("<h2>SevletConfig object values::" + sc.getInitParameter("p1") + "   " + sc.getInitParameter("p2")
				+ "</h2>");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("TestServlet.doPost()");
		doGet(req, res);
	}

}
