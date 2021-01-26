package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(value = "/secondurl")
public class Servlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String dyanaform_info_insertQuerry = "insert into dyanaform_info (pname,fname,ms,info1,info2) values(?,?,?,?,?)";

	@Resource(name = "DsJndi_MySql")
	private DataSource ds;

	Connection con = null;
	PreparedStatement ps = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet2.doGet()");

		//		set ContentType
		res.setContentType("text/html");

		//		creating PrintWriter object
		PrintWriter pw = res.getWriter();

		//		reading form1 data
		String name = req.getParameter("hname");
		String fname = req.getParameter("hfname");
		String ms = req.getParameter("hms");

		//		reading form2 data

		String f2v1 = req.getParameter("f2t1");
		String f2v2 = req.getParameter("f2t2");

		//		printing form1 data and form2 data
		pw.println("Name::" + name + "....Father Name::" + fname + "....Marital Status::" + ms);

		pw.println("f2v1::   " + f2v1 + "....f2v2::     " + f2v2);

		//		JDBC code to insert data

		try {
			con = ds.getConnection();//creating Connection using DataSource

			if (con != null) {
				ps = con.prepareStatement(dyanaform_info_insertQuerry);//creating PreparedStatement Object
				
				

				ps.setString(1,name );
				ps.setString(2,fname);
				ps.setString(3, ms);
				ps.setString(4,f2v1);
				ps.setString(5,f2v2);
				
				if (ps != null) {
					int result = ps.executeUpdate();//executing ps 

					//					checking record inserted or not
					if (result == 0) {
						pw.print("</br>");
						pw.print("Problem in record Insertion!");
					} else {
						pw.print("Record Insertion Sucessfully!");
					}
				}

			}

		} catch (SQLException e) {
			pw.println("Problem in record Insertion!");//exception during record insertion
			e.printStackTrace();
			
		} finally {//closing all Connections after using
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}

		//		closing PrintWriter Object
		pw.close();

	}//doGet

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet2.doPost()");
		doGet(req, res);
	}//doPost

}//class
