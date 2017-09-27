package com.virtusa.spring.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.virtusa.spring.model.Status;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;
import com.virtusa.spring.service.DeveloperService;



@Controller
@RequestMapping(value="/developer")
public class DeveloperController {
	
	@Autowired
	private DeveloperService developerService;
	@Autowired
	private HttpSession session;
	
	static Logger log=Logger.getLogger(DeveloperController.class);
	

	@RequestMapping(value="/View Tickets",method=RequestMethod.GET)
	public String viewTickets(Model model,HttpServletRequest request)
	{
//		System.out.println("in admin controller viewTickets");
		
		log.info("in admin controller viewTickets");
		//model.addAttribute("ticket",new Ticket() );
		log.info("in controller of admin");
		User userSession=(User)session.getAttribute("user");
		Set<Ticket> ticketDeveloperSet=developerService.viewAllTickets(userSession);
		log.info("in controller view status");
		if(ticketDeveloperSet.size()==0)
		{
			return "displayDeveloperTickets";
		}
		List<Status> list=developerService.getStatus();
//		System.out.println("stuslist"+list);
		
		log.info("stuslist"+list);
//		System.out.println("developers"+ticketDeveloperSet);
		
		log.info("developers"+ticketDeveloperSet);
		model.addAttribute("list",list);
		model.addAttribute("ticketDeveloperSet",ticketDeveloperSet);
		model.addAttribute("user",userSession);
		return "displayDeveloperTickets";
	}
	@RequestMapping(value="/setstatus/{ticketId}",method=RequestMethod.POST)
	public String setStatus(Model model,HttpServletRequest request,@RequestParam("fileUpload") CommonsMultipartFile[] fileUpload,@PathVariable("ticketId")int ticketId) throws IOException
	{
//		System.out.println("in setStatus controller");
		
		log.info("in setStatus controller");
		
		User userSession=(User)session.getAttribute("user");
		Set<Ticket> ticketDeveloperSet=developerService.viewAllTickets(userSession);
//		System.out.println(ticketDeveloperSet);
		
		log.info(ticketDeveloperSet);
		Iterator<Ticket> itr=ticketDeveloperSet.iterator();
		 
		Ticket check,ticket=null;
		while(itr.hasNext())
		{
			check=itr.next();
		    if(ticketId==check.getTicketId())
		    {
		    	ticket=check;
		    }
		}
//		System.out.println("ticket:= "+ticket);
		
		log.info("ticket:= "+ticket);
		for(CommonsMultipartFile file:fileUpload)
		{
			
			log.info("file name: "+file.getOriginalFilename());
			log.info("fileSize: "+file.getSize());
			
		}
		developerService.setStatus(fileUpload,ticket);
		/*developerService.updateTicket(ticket);*/
		model.addAttribute("message","Ticket with id "+ticketId+" Resolved Successfully");
		return "displayDeveloperTickets";
	}
	
	
	
}
