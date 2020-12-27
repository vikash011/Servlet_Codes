package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySqlConnServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("MySqlConnServlet.doGet()");

		//		set response Content Type 
		res.setContentType("text/html");

		//	  creating PrintWriter object
		PrintWriter pw = res.getWriter();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySqlConnServlet.doGet()-MqSql clazz is loaded");

			//			creating connection object 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");

			if (conn == null) {
				pw.println("<h2 align='center'>DB is not connected</h2>");
			} else {
				pw.println("<h2 align='center'>DB is connected</h2>");
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MySqlConnServlet.doPost()");
		doGet(req, res);
	}

}
