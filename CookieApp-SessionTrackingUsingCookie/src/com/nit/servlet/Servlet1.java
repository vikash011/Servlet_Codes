package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/firsturl")
public class Servlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Servlet1() {
		System.out.println("Servlet1 ..0-param constructor");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet1.doGet()");

		//		set ContentType
		res.setContentType("text/html");

		//		creating PrintWriter object
		PrintWriter pw = res.getWriter();

		//		reading form1 data
		String name = req.getParameter("name");
		String fname = req.getParameter("fname");
		String ms = req.getParameter("ms");
		
		pw.print("Name::"+name+"...."+"Father Name::"+fname+"....Marital Status::"+ms);

//		creating Cookie(In Memory Data)
		
		Cookie ck1 = new Cookie("name",name);
		Cookie ck2 = new Cookie("fname",fname);
		Cookie ck3 = new Cookie("ms",ms);
		
//		adding Cookie to response object
		res.addCookie(ck1);
		res.addCookie(ck2);
		res.addCookie(ck3);
		
		
		
		//		Dynamic form page
		if (ms.equalsIgnoreCase("married")) {
			
			pw.println("<h1 align='center' style='color:red'>Dynamic form2:providing married details:</h1>");
			pw.println("<div align='center' style='color:cyan'>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table>");
			pw.println("<tr>");
			
			pw.println("<td>Spouse Name::");
			pw.println("</td>");
			pw.println("<td>");
			pw.println("<input type='text' name='f2t1'>");
			pw.println("</td>");
			pw.println("<td>No.Of Children::");
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println("<input type='text' name='f2t2'>");
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</td>");
			
			
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
			pw.println("</div>");
		} else {
			pw.println("<h1 align='center' style='color:red'>Dynamic form2:providing Single details:</h1>");
			pw.println("<div align='center' style='color:cyan'>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table>");
			pw.println("<tr>");
			
			pw.println("<td>Why want to Marry?::");
			pw.println("</td>");
			pw.println("<td>");
			pw.println("<input type='text' name='f2t1'>");
			pw.println("</td>");
			pw.println("<td>When want to Marry?::");
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println("<input type='text' name='f2t2'>");
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</td>");
			
			
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
			pw.println("</div>");

		}
		//		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet1.doPost()");
		doGet(req, res);
	}

}
