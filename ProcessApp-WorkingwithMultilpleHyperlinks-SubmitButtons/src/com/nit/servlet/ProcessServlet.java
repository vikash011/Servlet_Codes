package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// set Response ContentType
		resp.setContentType("text/html");

		// creating PrintWriter Stream Object
		PrintWriter pw = resp.getWriter();

		// caption request parameter value
		String pval = req.getParameter("s1");

		//Checking request other than link
		if (!pval.equalsIgnoreCase("link1") && !pval.equalsIgnoreCase("link2")) {

			//storing request parameter form data
			float value1 = Float.parseFloat(req.getParameter("t1"));
			float value2 = Float.parseFloat(req.getParameter("t2"));

			//b.logic or request processing logic
			if (pval.equalsIgnoreCase("ADD")) {
				pw.print("<h1>Addition is::" + (value1 + value2) + "</h1>");
			} else if (pval.equalsIgnoreCase("SUB")) {
				pw.print("<h1>Substraction is::" + (value1 - value2) + "</h1>");
			} else if (pval.equalsIgnoreCase("DIV")) {
				pw.print("<h1>Division is::" + (value1 / value2) + "</h1>");
			} else if (pval.equalsIgnoreCase("MUL")) {
				pw.print("<h1>Multiplication is::" + (value1 * value2) + "</h1>");
			}

		}//if
		else {//logic for hyperlink
            if(pval.equalsIgnoreCase("link1")) {
            	pw.print("<h1 align='center' style='color:blue'>System date and time::"+new Date()+"</h1>");
            }else if(pval.equalsIgnoreCase("link2")) {
            	pw.print("<h1 align='center' style='color:blue'>System properties::"+System.getProperties()+"</h1>");      	
            }
			
		}//else
		
		//closing PrintWriter Stream Object
		   pw.close();
		   
		

	}//doGet

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}//doPost

}//class
