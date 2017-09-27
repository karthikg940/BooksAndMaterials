package com.virtusa.firstapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.firstapp.bean.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public int save(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		return user.getId();
	}
	
	public User get(int id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user=(User)session.get(User.class,id);
		return user;
	}

	public List<User> all() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> users = query.list();
		System.out.println(users);
		session.close();
		return users;
		
		 
	}

	public User update( User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("in dao");
		session.update(user);
		System.out.println(user);
		return user;
	}

	public void delete(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
	 
	}

}
