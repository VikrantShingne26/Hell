package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceImpl;
import com.nt.vo.StudentVO;

public class SRCController extends HttpServlet {
	
	String sno=null;
	String m1=null,m2=null,m3=null;;
	String sname=null;
	StudentVO vo=null;
	StudentDTO dto=null;
	StudentService service=null;
	RequestDispatcher rd=null;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read input value
		sno=req.getParameter("sno");
		sname=req.getParameter("sname");
		m1=req.getParameter("m1");
		m2=req.getParameter("m2");
		m3=req.getParameter("m3");
		//prepare StudentVO
		vo=new StudentVO();
		vo.setSno(sno);
		vo.setSname(sname);
		vo.setM1(m1);vo.setM2(m2);vo.setM3(m3);	
		//convert vo to DTO
		dto=new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		
		//calls Service
		service=new StudentServiceImpl();
		service.registerStudent(dto);
		
		//forwaard request
		rd=req.getRequestDispatcher("\result.jsp");
		if(rd!=null){
			rd.forward(req, res);
	}
		
		
			
			
		
		
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
	
	

}
