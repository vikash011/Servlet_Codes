package com.nit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.dto.StudentDTO;
import com.nit.service.IStudentMgmtService;
import com.nit.service.StudentMgmtServiceImpl;



public class MainControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IStudentMgmtService service;

	@Override
	public void init() throws ServletException {

		System.out.println("MainControllerServlet.init()");
		try {
			service = new StudentMgmtServiceImpl();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}//init()

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("StudentMainController.doGet()");

		//		set ContentType
		res.setContentType("text/html");

		//		get PrintWriter
		PrintWriter pw = res.getWriter();

		//		getting input formData 

		String sName = req.getParameter("sName");
		String sAdd = req.getParameter("SAddress");
		int marks1 = Integer.parseInt(req.getParameter("mrk1"));
		int marks2 = Integer.parseInt(req.getParameter("mrk2"));
		int marks3 = Integer.parseInt(req.getParameter("mrk3"));

		//		creating StudentDTO class object having form data

		StudentDTO dto = new StudentDTO();

		dto.setSname(sName);
		dto.setSadd(sAdd);
		dto.setMarks1(marks1);
		dto.setMarks2(marks2);
		dto.setMarks3(marks3);

		//		using service class
		try {
			String result = service.generateResult(dto);
			pw.print("<h1 align='center' style='color:green'>" + result + "</h1>");
		} catch (Exception e) {
			pw.print("<h1 align='center' style='color:red'>Problem in Student Registration</h1>");
			e.printStackTrace();
		}

		//		adding home HyperLink
		pw.print("<a href='input.html'>Home</a>");

	}//doGet

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("StudentMainController.doPost()");
		doGet(req, res);
	}//doPost

}//class
