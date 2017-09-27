package com.virtusa.spring.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.virtusa.spring.model.Priority;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;


@Repository
public class AdminDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	static Logger log = Logger.getLogger(AdminDAO.class);

	public int assignPriority(Ticket ticket, Priority priority) {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ticket.setPriority(priority);
		session.update(ticket);
		tx.commit();
		session.close();
		return 0;
		
	}

	public int setDeveloper(User user) {
		 
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
		return 0;
		
	}

}
