package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//setting response ContentType
		resp.setContentType("text/html");
		
		
		//creating PrintWriter Stream object
		PrintWriter pw = resp.getWriter();
		
		//reading form  data
		String name = req.getParameter("pname");
		int age = Integer.parseInt(req.getParameter("page"));
		String gender =req.getParameter("gender");
		String addrs = req.getParameter("addrs");
		String dob = req.getParameter("pdob");
		String favcolor = req.getParameter("favcolor");
		long mobNo = Long.parseLong(req.getParameter("mobno"));
		long salary = Long.parseLong(req.getParameter("sal_range"));
		String crr_time = req.getParameter("crr_time");
		String email = req.getParameter("email");
		String fav_url = req.getParameter("fav_url");
		String[] hobbies = req.getParameterValues("hb");
		String qualification = req.getParameter("qualification_list");
		String m_staus = req.getParameter("m_staus");
	
		//b.logic or request processing logic
		
		if(gender.equalsIgnoreCase("M")) {
			if(age<5) {
				pw.print("<h1 align='cneter' style='color:blue'></h1>");
				
			}
			
			
		}else {
			
			
			
		}
		
		
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	
	
}
