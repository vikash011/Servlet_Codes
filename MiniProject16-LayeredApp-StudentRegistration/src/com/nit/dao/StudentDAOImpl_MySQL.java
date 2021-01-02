package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nit.bo.StudentBO;

public class StudentDAOImpl_MySQL implements IStudentDAO {

	private static final String LAYERED_STUDENT_INSERT = "INSERT INTO student_layered_db (sname,sadd,total,avg,result) VALUES(?,?,?,?,?)";

	private DataSource ds;

	public StudentDAOImpl_MySQL() throws Exception {
		
		
		System.out.println("StudentDAOImpl.StudentDAOImpl()-no param constructor");

		//				creating InitialContext object
		InitialContext ic = new InitialContext();
		//				creating DataSource Object from Jndi registry by lookup method
		ds = (DataSource) ic.lookup("java:/comp/env/DsJndi_MySql");
	}

	@Override
	public int insert(StudentBO bo) throws Exception {
		System.out.println("StudentDAOImpl.insert()");

		Connection con = getPooledJdbcConnection();

		//		creating prepared statement object
		PreparedStatement ps = con.prepareStatement(LAYERED_STUDENT_INSERT);

		//		setting parameter values to  query string
		ps.setString(1, bo.getSname());
		ps.setString(2, bo.getSadd());
		ps.setInt(3, bo.getTotal());
		ps.setFloat(4, bo.getAvg());
		ps.setString(5, bo.getResult());

		//		executing prepared statement
		int result = ps.executeUpdate();

		//		returning result
		return result;
	}

	public Connection getPooledJdbcConnection() throws Exception {
		System.out.println("StudentDAOImpl.getPooledJdbcConnection()");

		//		get Pooled Jdbc Connection object through DataSource Object ref
		Connection con = ds.getConnection();

		return con;
	}

}
