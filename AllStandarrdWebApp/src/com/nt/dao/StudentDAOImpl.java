package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.bo.StudentBO;
import com.nt.utility.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {
	Session ses = null;
	Transaction tx = null;
	int cnt=0;

	@Override
	public int insert(StudentBO bo) {
		// get bo

		ses = HibernateUtil.getSession();
		
		
		try{
			tx=ses.beginTransaction();
			  ses.save(bo);
			tx.commit();
			cnt=1;
			}
			catch(Exception e){
				cnt=0;
			}
			HibernateUtil.closeSession();
			return cnt;
	
	}
	// close session

}
