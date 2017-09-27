package com.virtusa.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.spring.model.Category;
import com.virtusa.spring.model.FileUpload;
import com.virtusa.spring.model.Priority;
import com.virtusa.spring.model.Project;
import com.virtusa.spring.model.Role;
import com.virtusa.spring.model.Status;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	static Logger log = Logger.getLogger(UserDAO.class);

	@Transactional
	public User addUser(User user) {
		log.info("dao");
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		return user;
	}

	public List<User> getUser() {
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> users = query.list();
		session.close();
		return users;
	}

	public User getUser(int userId) {
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}

	public Role getRole(int roleId) {
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, roleId);
		session.close();
		return role;
	}

	public List<Category> getCategory() {
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Category");
		List<Category> list = query.list();
		session.close();
		return list;
	}

	public Category getCategory(int categoryId) {
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Category category = (Category) session.get(Category.class, categoryId);
		session.close();
		return category;
	}

	public List<Project> getProjects() {
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Project");
		List<Project> list = query.list();
		session.close();
		return list;
	}

	public Project getProject(int projectId) {
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Project project = (Project) session.get(Project.class, projectId);
		session.close();
		return project;
	}

	public Priority getPriority(int priorityId) {
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Priority priority = (Priority) session.get(Priority.class, priorityId);
		session.close();
		return priority;
	}

	public List<Priority> getPriority() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Priority");
		List<Priority> list = query.list();
		session.close();
		return list;
	}

	public Status getStatus(int statusId) {
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		log.info("in dao category");
		Status status = (Status) session.get(Status.class, statusId);
		session.close();
		return status;
	}

	public List<Status> getStatus() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Status");
		List<Status> list = query.list();
		session.close();
		return list;
	}

	public Ticket getTicket(int ticketId) {
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Ticket ticket = (Ticket) session.get(Ticket.class, ticketId);
		session.close();
		return ticket;
	}

	public List<Ticket> getTicket() {
		log.info("in dao getticket");
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Ticket");
		List<Ticket> list = query.list();
		log.info(list);
		session.close();
		return list;
	}

	// @Transactional
	public Ticket ticketDetails(Ticket ticket) {
		log.info(ticket + "in dao");
		Session session = sessionFactory.openSession();
		// Session session=sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(ticket);
		tx.commit();
		session.close();
		return ticket;
	}

	public List<FileUpload> getFileData() {
		Session session = sessionFactory.openSession();
		// String sql =
		// ("SELECT TICKETID FROM TICKET_USER_DEVELOPER where TICKET_ID="+ticketId);
		List<FileUpload> list = session.createQuery("from FileUpload").list();
		return list;
	}

	
}
