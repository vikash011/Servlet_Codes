package com.nit.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlServlet extends HttpServlet {

	// servlet class loading
	static {
		System.out.println("HtmlServlet.static block");
	}

	// servlet class object creation
	public HtmlServlet() {
		System.out.println("HtmlServlet.HtmlServlet()");
	}

	// servlet class initilization using init method
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("HtmlServlet.init(-)");
	}

	//service method for generating response to request
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("HtmlServlet.service()");
	}

	//servlet class object destruction after executing service method
	@Override
	public void destroy() {
		System.out.println("HtmlServlet.destroy()");
	}
}
