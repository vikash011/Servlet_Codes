package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet1() {
		System.out.println("Servlet1.Servlet1()-0 Param Constructor)");

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet1.doGet()");

		//		set response ContentType
		res.setContentType("text/html");

		
		//		creating Cookie(In Memory Data)
		Cookie ck1 = new Cookie("name", "Raja");
		Cookie ck2 = new Cookie("fname", "rao");

		//		sending/adding cookie to browser using response object
		res.addCookie(ck1);
		res.addCookie(ck2);
		
		
		
//		creating Cookie (Persistance) having maxage
		
		Cookie ck3 = new Cookie("age","27");
		Cookie ck4 = new Cookie("ms","married");
		
       ck3.setMaxAge(2*60);//time in milliSecond
       ck4.setMaxAge(2*60);
       
       
//       adding cookie to Browser
       res.addCookie(ck3);
       res.addCookie(ck4);

	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet1.doPost()");
		doGet(req, res);
	}//doPost

}
