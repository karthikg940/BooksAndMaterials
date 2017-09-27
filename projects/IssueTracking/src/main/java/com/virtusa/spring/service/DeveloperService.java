package com.virtusa.spring.service;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.virtusa.spring.dao.DeveloperDAO;
import com.virtusa.spring.dao.UserDAO;
import com.virtusa.spring.model.FileUpload;
import com.virtusa.spring.model.Status;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;

@Service
public class DeveloperService {

	@Autowired
	private UserDAO userdao;

	@Autowired
	private DeveloperDAO developerDao;

	public DeveloperDAO getDeveloperDao() {
		return developerDao;
	}

	public void setDeveloperDao(DeveloperDAO developerDao) {
		this.developerDao = developerDao;
	}

	static Logger log = Logger.getLogger(DeveloperService.class);

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	public Set<Ticket> viewAllTickets(User user) {
		Set<Ticket> ticketSet = user.getDeveloperTickets();
		return ticketSet;
	}

	public List<Status> getStatus() {
		List<Status> list = userdao.getStatus();
		return list;
	}

	public void setStatus(CommonsMultipartFile[] fileUpload, Ticket ticket) {
//		Status status = userdao.getStatus(702);
//		ticket.setStatus(status);
		System.out.println("in service"+ticket);
		log.info("in service");
		for (CommonsMultipartFile aFile : fileUpload) {
			FileUpload file = new FileUpload();
			file.setFileData(aFile.getBytes());
			file.setTicket(ticket);
			developerDao.setStatus(file);
		}
		//developerDao.updateTicket(ticket);
	}

	/*public void updateTicket(Ticket ticket) {
		Status status = userdao.getStatus(702);
		ticket.setStatus(status);
		developerDao.updateTicket(ticket);
		
	}*/

}
