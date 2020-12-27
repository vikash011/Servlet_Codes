package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarraigeChecking.doGet(-,-)");

		// setting ContentType
		res.setContentType("text/html");

		// creating PrintWriter stream object
		PrintWriter pw = res.getWriter();

		// reading request parameter form data
		String pname = req.getParameter("pname");
		String tage = req.getParameter("page");
		String gender = req.getParameter("gender");
		String vstatus = req.getParameter("vflag");
		
		int age=0;

		if (vstatus.equalsIgnoreCase("no")) {// checking clint side validation not done
			// Server Side form Validation

			List<String> errList = new ArrayList<>();
			if (pname == null || pname.equals("") || pname.length() == 0) {// name required
				errList.add("Person Name is required");
			} else if (pname.length() < 5) {// minimum length
				errList.add("Person Name must have minimum 5 characters");
			}
			if (tage == null || tage.equals("") || tage.length() == 0) {
				errList.add("Person Age is required ");
			} else {
				try {
					 age = Integer.parseInt(tage);
					if (age < 1 || age > 125) {
						errList.add("Person Age  must between 1 to 125");
					}
				} catch (NumberFormatException nfe) {
					errList.add("Person Age must be Numric");

				}//catch()

			}//else
		//Display Form validation error messages
			if(!errList.isEmpty()) {
			     errList.forEach(msg ->{
			    	 pw.print("<li style='color:red'>"+msg+"</li>");
			     });
			   return;
				
			}//if

	}else {	
			 age= Integer.parseInt(tage);
	}
		System.out.println("MarriageServlet.doGet()::server side b.logic");
		pw.println("<h1 align='center' style='color:Magenta'>Shaadi.com</h1>");
			if(gender.equalsIgnoreCase("M")) {
				if(age>=21) {
					pw.print("<h1 style='color:blue' align='center'>"+pname+" is eligible for Marriage but think once</h1>");
				}else {
					pw.print("<h1 style='color:blue' align='center'>"+pname+" is  not eligible for Marriage wait "+(21-age)+"</h1>");
				}
				
			}else {
				if(age>=18) {
					pw.print("<h1 style='color:blue' align='center'>"+pname+" is eligible for Marriage but think thrice</h1>");
				}else {
					pw.print("<h1 style='color:blue' align='center'>"+pname+" is eligible for Marriage wait till"+(18-age)+"</h1>");
				}
				
			}
			
			
			

		//hyperlink for  home page 
		pw.println("<a href='input.html'>HOME</a>");
    
		//closing PrintWriter Stream
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarraigeChecking.doPost(-,-)");
		doGet(req, res);
	}
	

}
