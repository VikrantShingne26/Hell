package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOImpl;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

	@Override
	public String registerStudent(StudentDTO dto){
		StudentDAO dao=null;
		int total=0;
		float avg=0.0f;
		String result=null;
		int count=0;
		StudentBO bo=null;
		//calc total,avg and generate result
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=(float)total/(3);
		if(avg>35){
			result="pass";
		}
		else
			result="fail";
		
		//convert DTO TO BO
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//call dao
		
		dao= new StudentDAOImpl();
		count=dao.insert(bo);
		if(count==1)
			return result+" Student Registration successful";
		else
			return result+" student registration failed";
		
			
	}

	
}
