package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String get_city_query = "select * from city where id=?";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// set Response Content Type
		resp.setContentType("text/html");

		// creating PrintWriter object
		PrintWriter pw = resp.getWriter();

		// getting request parameter values
		int id = Integer.parseInt(req.getParameter("id"));

		// persistance logic

		try {
			// loading of class (optional)
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			// creating Connection object
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");

			
//			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");

			// creating PreparedStament Object
			PreparedStatement pstmt = con.prepareStatement(get_city_query);

			// passing Input to parameters query
			pstmt.setInt(0,id);

			// Holding Result Set Object data
			ResultSet rs = pstmt.executeQuery();

			// printing employee details
			while (rs.next()) {
				pw.println("<h2>" + rs.getString(1) + "</h2>");
				pw.println("<h2>" + rs.getString(2) + "</h2>");
				pw.println("<h2>" + rs.getString(3) + "</h2>");
				pw.println("<h2>" + rs.getString(4) + "</h2>");
				pw.println("<h2>" + rs.getString(5) + "</h2>");
				
			}

		}/**	 catch (

	ClassNotFoundException cnfe) {
			cnfe.printStackTrace();

		}**/ catch (SQLException sql) {
			sql.printStackTrace();

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);

	}

}
