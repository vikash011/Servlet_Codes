package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet2() {
		System.out.println("Servlet2.Servlet2()-0 param constructor");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet2.doGet()");

		//		set response ContentType
		res.setContentType("text/html");

		//		getting PrintWriter object
		PrintWriter pw = res.getWriter();

		//		getting Cookies
		Cookie cookie[] = req.getCookies();//returns array of cookie

		String name = cookie[0].getValue();//first cookie
		String fname = cookie[1].getValue();//second cookie

		//	   printing cookie values on the browser 
		pw.println("name::" + name);
		pw.println("fname::" + fname);
		
		
		
		String age=cookie[2].getValue();
		String ms = cookie[3].getValue();
		
		pw.println("age::"+age);
		pw.println("ms::"+ms);
		
		

		//	   closing streams
		pw.close();

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet2.doPost()");
		doGet(req, res);
	}

}
