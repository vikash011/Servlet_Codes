package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/orcl")
public class OracleConnServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//		setting response Content Type
		res.setContentType("text/html");

		//      creating PrintWriter stream
		PrintWriter pw = res.getWriter();

		try {
			Class.forName("Oracle:jdbc:driver:OracleDriver");

			//		Creating Connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:@localhost:thin:1521:orcl", "scott", "tiger");

			if (con == null) {
				pw.print("<h1>DB is not Connected</h1>");
			} else {
				pw.print("<h1>DB ic Connected</h1");
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
