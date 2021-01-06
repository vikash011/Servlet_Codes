package com.nit.service;

import com.nit.bo.StudentBO;
import com.nit.dao.IStudentDAO;
import com.nit.dao.StudentDAOImpl_MySQL;
import com.nit.dao.StudentDAOImpl_Oracle;
import com.nit.dto.StudentDTO;

public class StudentMgmtServiceImpl implements IStudentMgmtService {

	private IStudentDAO dao;

	public StudentMgmtServiceImpl() throws Exception {
		System.out.println("StudentMgmtServiceImpl.StudentMgmtServiceImpl()-no param constructor");
		
       //for oracle
      // dao= new StudentDAOImpl_Oracle();
		
		//for Mysql
		dao = new StudentDAOImpl_MySQL();

	}

	@Override
	public String generateResult(StudentDTO dto) throws Exception {

		System.out.println("StudentMgmtServiceImpl.generateResult()");
		//		b.logic  to calculate total marks
		int total = dto.getMarks1() + dto.getMarks2() + dto.getMarks3();

		//		calculating average marks
		float avg = total / 3.0f;

		//      generate result
		String result = "null";

		if (dto.getMarks1() < 35 || dto.getMarks2() < 35 || dto.getMarks3() < 35) {
			result = "fail";
		} else if (avg < 35) {
			result = "fail";
		} else if (avg < 50) {
			result = "third class";

		} else if (avg < 60) {
			result = "second class";
		} else {
			result = "first class";
		}

		//		creating StudentBO class object
		StudentBO bo = new StudentBO();

		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setResult(result);
		bo.setTotal(total);
		bo.setAvg(avg);

		//	     using DAO
		int count = dao.insert(bo);

		return count == 0 ? "Student Registration failed"
				: "Student Registration Sucessfully" + "sName:" + dto.getSname() + "  sAdd:" + dto.getSadd() + "   avg"
						+ avg + "  result:" + result + "  total:" + total;
	}//method

}//class
