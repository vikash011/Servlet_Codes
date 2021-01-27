package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/secondurl")
public class Servlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet2.doGet()");

		//		set ContentType
		res.setContentType("text/html");

		//		creating PrintWriter object
		PrintWriter pw = res.getWriter();

		//		reading form1/req1 data(cookie data)

		Cookie cookie[] = req.getCookies();

		String name = cookie[0].getValue();
		String fname = cookie[1].getValue();
		String ms = cookie[2].getValue();

		//		reading form2 data

		String f2t1 = req.getParameter("f2t1");
		String f2t2 = req.getParameter("f2t2");

		//		printing form1 data and form2 data
		pw.print("Name::" + name + "....Father Name::" + fname + "....Marital Status::" + ms);

		pw.print("f2v1::" + f2t1 + "....f2v2::" + f2t2);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet2.doPost()");
		doGet(req, res);
	}

}
