package com.virtusa.spring.dao;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.spring.model.FileUpload;
import com.virtusa.spring.model.Ticket;

@Repository
public class DeveloperDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	static Logger log = Logger.getLogger(DeveloperDAO.class);
	
	public int setStatus(FileUpload file) {
		 
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		log.info("devdao");
		session.save(file);
		tx.commit();
		session.close();
		return 0;
		
	}

	/*public void updateTicket(Ticket ticket) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(ticket);
		tx.commit();
		session.close();
		
	}
*/
	/*public void updateTicket(Ticket ticket) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(ticket);
		tx.commit();
		session.close();
	}*/

//	public int uploadfile(FileUpload filenew) {
//		 
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(filenew);
//		tx.commit();
//		session.close();
//		return 0;
//		
//	}

}
