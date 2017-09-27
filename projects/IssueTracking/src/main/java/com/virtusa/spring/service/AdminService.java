package com.virtusa.spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.spring.dao.AdminDAO;
import com.virtusa.spring.dao.UserDAO;
import com.virtusa.spring.model.Category;
import com.virtusa.spring.model.Priority;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;

@Service
public class AdminService {

	@Autowired
	private UserDAO userdao;
	
	@Autowired
	private AdminDAO adminDao;
	static Logger log = Logger.getLogger(AdminService.class);

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	
	public AdminDAO getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

	public List<Ticket> viewAllTickets() {
//		System.out.println("in admin service");
		log.info("in admin service");
		Ticket ticket;
		List<Ticket> allTickets = new ArrayList<Ticket>();
		List<Ticket> list = userdao.getTicket();
		Iterator<Ticket> itr=list.iterator();
		while(itr.hasNext())
		{
			 ticket = itr.next();
			 if(ticket.getPriority()==null)
			 {
				 allTickets.add(ticket);
			 }
		}
		return allTickets;
	}

	public Ticket viewTicketById(int ticketId) {

		Ticket ticket = userdao.getTicket(ticketId);
		return ticket;
	}

	public List<Ticket> viewTicketByCategory(Integer categoryId) {
		log.info("in ser");
		List<Ticket> allTickets = new ArrayList<Ticket>();
		List<Ticket> list = userdao.getTicket();
		log.info("in service" + list);
		Iterator<Ticket> itr = list.iterator();
		Ticket ticket;
		Category category;
		while (itr.hasNext()) {
			ticket = itr.next();
			if(ticket.getPriority()==null)
			{
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

	public List<Category> getCategory() {
		log.info("in serice");
		List<Category> list = userdao.getCategory();
		return list;
	}
	
	public List<Priority> getPriority()
	{
		List<Priority> list=userdao.getPriority();
		return list;
	}

	public int assignPriority(int ticketId, int priorityId) {
		
//		adminDao.assignPriority(ticketId,priority);
		Ticket ticket=userdao.getTicket(ticketId);
		Priority priority=userdao.getPriority(priorityId);
		int number=adminDao.assignPriority(ticket,priority);
	//	priority.getPriorityName();
		return number;
	}

	public List<Ticket> viewAllTicketsWithPriority() {
		
		List<Ticket> allTickets = new ArrayList<Ticket>();
		List<Ticket> list = userdao.getTicket();
		Iterator<Ticket> itr = list.iterator();
		Ticket ticket;
		while (itr.hasNext()) {
			ticket = itr.next();
			if(ticket.getPriority()!=null)
			{
					allTickets.add(ticket);
			}
			
		}	 
		return allTickets;
	}
	public List<User> getDevelopers()
	{
		List<User> devList=new ArrayList<User>();
		 User user;
		 List<User> userList=userdao.getUser();
		 Iterator<User> itr=userList.iterator();
		 while(itr.hasNext())
		 {
			 user=itr.next();
			 if(user.getRole().getRoleId()==101 && user.getDeveloperTickets().size()==0)
			 {
				// System.out.println(user);
				 //System.out.println("hello"+user.getDeveloperTickets());
			   
			    	//System.out.println("in loof expected 3 times");
			    	devList.add(user);
			    
			 }
		 }
		return devList; 
	}

	public int setDeveloper(Ticket ticket, User user) {
		Set<Ticket>tickets=new HashSet<Ticket>();
		tickets.add(ticket);
		user.setDeveloperTickets(tickets);
		int setDeveloper=adminDao.setDeveloper(user);
		return setDeveloper;
	}
	
	/*public void getdevelopers()
	{
		 List<User> userList=userdao.getUser();
		 List<Ticket> ticketList = userdao.getTicket();
		 List<User>developerList=new ArrayList<User>();
		 int roleId=101;
		 User user;
		 Ticket ticket;
		 Iterator<User> itr=userList.iterator();
		 Iterator<Ticket> it=ticketList.iterator();
		 while(itr.hasNext())
		 {
			 	user = itr.next();
			 	while(it.hasNext())
			 	{
			 		ticket=it.next();
			 
			 		Iterator<User> devloperIterator=ticket.getAssignDeveloper().iterator();
			 		while(devloperIterator.hasNext())
			 		{
			 			User userDev=devloperIterator.next();
			 			if(userDev.getUserId()==user.getUserId())
			 			{
			 				
			 			}
			 		}
				 }
		}
	 }
		 while(itr.hasNext())
		 {
			   user = itr.next();
			   if(user.getRole().getRoleId()==101)
			   {
				   
			   }
		 }
		
	}*/

}
