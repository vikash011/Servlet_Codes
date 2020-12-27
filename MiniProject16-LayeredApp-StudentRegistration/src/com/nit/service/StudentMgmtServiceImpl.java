package com.nit.service;

import com.nit.dao.IStudentDAO;
import com.nit.dao.StudentDAOImpl;
import com.nit.dto.StudentDTO;

public class StudentMgmtServiceImpl implements IStudentMgmtService {

	private IStudentDAO dao;

	public StudentMgmtServiceImpl() throws Exception {
		dao = new StudentDAOImpl();

	}

	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		
		
//		b.logic 
		int total = dto.getMarks1()+dto.getMarks2()+dto.getMarks3();
		
         float avg = total/3.0f;
         
         
		
		
		return null;
	}

}
