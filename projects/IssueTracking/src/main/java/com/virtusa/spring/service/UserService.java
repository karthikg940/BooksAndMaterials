package com.virtusa.spring.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.spring.dao.UserDAO;
import com.virtusa.spring.exceptions.UserException;
import com.virtusa.spring.model.Category;
import com.virtusa.spring.model.FileUpload;
import com.virtusa.spring.model.Project;
import com.virtusa.spring.model.Role;
import com.virtusa.spring.model.Status;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userdao;
	static Logger log = Logger.getLogger(UserService.class);

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	public User addLogin(String userName, String password) throws UserException {
		log.info("service login");
		List<User> users;
		users = userdao.getUser();
		if (users != null) {
			Iterator<User> itr = users.iterator();
			User user = null;
			User check;

			while (itr.hasNext()) {
				check = itr.next();
				if (check.getUserName().equals(userName)
						&& check.getPassword().equals(password)) {
					user = check; 
				}
			}
			return user;
		}
		return null;
	}

	public boolean registration(User user) {

		log.info("service");
		List<User> users = userdao.getUser();
		Iterator<User> itr = users.iterator();
		User check;
		while (itr.hasNext()) {
			check = itr.next();
			if (check.getUserName().equals(user.getUserName())) {
				return false;
			}
		}
		Role role = userdao.getRole(102);
		user.setRole(role);
		userdao.addUser(user);
		return true;
	}

	/*
	 * public User checkUser(String userName) { List<User>
	 * users=userdao.getUser(); Iterator<User> itr=users.iterator(); User
	 * user=null; while(itr.hasNext()) { user=itr.next();
	 * if(user.getUserName().equals(userName)) { return user; } } return user; }
	 */
	public List<Category> getCategory() {
		log.info("in service");
		List<Category> list = userdao.getCategory();
		return list;
	}

	public List<Project> getProjects() {
		log.info("in serice");
		List<Project> list = userdao.getProjects();
		return list;
	}

	public User getUser(int userId) {
		User user = userdao.getUser(userId);
		return user;

	}

	public Ticket ticketDetails(User user, int categoryId, int projectId,
			String description) throws SQLException {
		log.info("in service");
		// User user1 =userdao.getUser(user.getUserId());
		log.info(user + "in service user");
		Category category = userdao.getCategory(categoryId);
		log.info(category);
		Set<Category> set = new HashSet<Category>();
		set.add(category);

		Project project = userdao.getProject(projectId);
		if (project != null) {
			log.info(project);
			Status status = userdao.getStatus(700);
			log.info(status);
			Ticket ticket = new Ticket();
			ticket.setDescription(description);
			ticket.setUser(user);
			ticket.setProject(project);
			ticket.setCategory(set);
			ticket.setRiseDate(new Date());
			ticket.setStatus(status);
			log.info(ticket + "in service");
			Ticket ticket1 = userdao.ticketDetails(ticket);
			log.info(ticket1);
			return ticket1;
		} else
			return null;
	}

	public Ticket viewTicketById(int ticketId, int userId) {
		Ticket ticket = userdao.getTicket(ticketId);
		if(ticket !=null && ticket.getUser().getUserId() == userId)
		{
		
			return ticket;
		
		}
		System.out.println("in ticket"+ticket);
		return null;
	}

	public List<Ticket> viewAllTickets(int userId) {
		List<Ticket> allTickets = new ArrayList<Ticket>();
		List<Ticket> list = userdao.getTicket();
		Iterator<Ticket> itr = list.iterator();
		Ticket ticket;
		while (itr.hasNext()) {
			ticket = itr.next();
			log.info(ticket + " " + userId);
			int id = ticket.getUser().getUserId();
			if (id == userId) {
				allTickets.add(ticket);
			}
		}

		return allTickets;
	}

	public List<Ticket> viewTicketByCategory(Integer categoryId, Integer userId) {
		log.info("in ser");
		List<Ticket> allTickets = new ArrayList<Ticket>();
		List<Ticket> list = userdao.getTicket();
		log.info("in service" + list);
		Iterator<Ticket> itr = list.iterator();
		Ticket ticket;
		Category category;
		while (itr.hasNext()) {
			ticket = itr.next();
			int id = ticket.getUser().getUserId();
			if (id == userId) {
				Iterator<Category> it = ticket.getCategory().iterator();
				while (it.hasNext()) {
					category = it.next();
					if (category.getCategoryId() == categoryId) {
						allTickets.add(ticket);
					}
				}
			}
		}
		return allTickets;
	}

	public byte[] getFileData(int ticketId) {
		List<FileUpload> list = userdao.getFileData();
		for (FileUpload fileupload : list) {
			byte[] fileData = fileupload.getFileData();
			return fileData;
		}
		return null;
	}

	public List<Integer> getdownLoadData() {
		List<Integer> allTickets = new ArrayList<Integer>();
		List<FileUpload> listFileData = userdao.getFileData();
		Iterator<FileUpload> itrFile = listFileData.iterator();
		FileUpload fileData;
		while (itrFile.hasNext()) {
			fileData = itrFile.next();
			allTickets.add(fileData.getTicket().getTicketId());

		}
		return allTickets;
	}

	
	
}
