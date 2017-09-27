package com.virtusa.spring.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtusa.spring.model.Category;
import com.virtusa.spring.model.Priority;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;
import com.virtusa.spring.service.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
//	@Autowired
//	private AdminController adminController;
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private HttpSession session;
	
	static Logger log=Logger.getLogger(AdminController.class);
	
	@RequestMapping(value="/View Tickets",method=RequestMethod.GET)
	public String viewTickets(Model model)
	{
		model.addAttribute("ticket",new Ticket());
		User userSession=(User)session.getAttribute("user");
		model.addAttribute("user",userSession);
		List<Category> list=adminService.getCategory();
		Map<Integer,String> map=new LinkedHashMap<Integer,String>();
		for(Category cat:list)
		{
			map.put(cat.getCategoryId(), cat.getCategoryName());
		}
		model.addAttribute("map", map);
		return "viewTicketsAdmin";
				 
	}
	
	@RequestMapping(value="/Assign Developer",method=RequestMethod.GET)
	public String assignDeveloper(Model model)
	{
		model.addAttribute("ticket",new Ticket());
		User userSession=(User)session.getAttribute("user");
		List<Ticket> ticketAdminList=adminService.viewAllTicketsWithPriority();
		model.addAttribute("user",userSession);
		model.addAttribute("ticketAdminList", ticketAdminList);
		return "assigndeveloper";
	}
	
		@RequestMapping(value="/viewTicketsById",method=RequestMethod.POST)
			public String viewTicketsById(Model model,HttpServletRequest request,@RequestParam("ticketId") int ticketId)
			{
			model.addAttribute("ticket",new Ticket() );
//			System.out.println("in controller of admin");
			log.info("in controller of admin");
			    session=request.getSession();
				User userSession=(User)session.getAttribute("user");
				Ticket ticket=adminService.viewTicketById(ticketId);
				log.info("in controller view status");
				if(ticket==null || ticket.getTicketId()==0)
				{
					List<Category> list=adminService.getCategory();
					Map<Integer,String> map=new LinkedHashMap<Integer,String>();
					for(Category cat:list)
					{
						map.put(cat.getCategoryId(), cat.getCategoryName());
					}
					model.addAttribute("map", map);
					model.addAttribute("searchId","No Tickets found with Ticket Id"+ticketId);
					return "viewTicketsAdmin";
				}
//				System.out.println(ticket);
				List<Priority> list=adminService.getPriority();
				model.addAttribute("list", list);
				model.addAttribute("ticketId",ticketId);
				model.addAttribute("ticket",ticket);
				model.addAttribute("user",userSession);
				return "displayAdminTickets";
			}
		
		@RequestMapping(value="/viewTicketsByCategory",method=RequestMethod.POST)
		public String viewTicketsByCategory(Model model,HttpServletRequest request,@RequestParam("category") int categoryId)
		{
//			System.out.println();
			model.addAttribute("ticket",new Ticket() );
//		System.out.println("in controller of admin");
			
			log.info("in controller of admin");
			User userSession=(User)session.getAttribute("user");
			List<Ticket> ticketList=adminService.viewTicketByCategory(categoryId);
			log.info("in controller view status");
			if(ticketList.size()==0)
			{
				List<Category> list=adminService.getCategory();
				Map<Integer,String> map=new LinkedHashMap<Integer,String>();
				for(Category cat:list)
				{
					map.put(cat.getCategoryId(), cat.getCategoryName());
				}
				
				model.addAttribute("map", map);
				model.addAttribute("searchCategory","No Tickets found with ticket category");
				return "viewTicketsAdmin";
			}
			List<Priority> list=adminService.getPriority();
			model.addAttribute("list", list);
//			System.out.println(ticketList);
			log.info(ticketList);
			model.addAttribute("categoryId",categoryId);
//			System.out.println(ticketList);
			log.info(ticketList);
			model.addAttribute("ticketList",ticketList);
			model.addAttribute("user",userSession);
			return "displayAdminTickets";
		}

		@RequestMapping(value="/viewAllTickets",method=RequestMethod.POST)
		public String viewAllTickets(Model model,HttpServletRequest request)
		{
			model.addAttribute("ticket",new Ticket() );
//			System.out.println("in controller of admin");
			log.info("in controller of admin");
			User userSession=(User)session.getAttribute("user");
			List<Ticket> ticketAdminList=adminService.viewAllTickets();
			log.info("in controller view status");
			if(ticketAdminList.size()==0)
			{
				List<Category> list=adminService.getCategory();
				Map<Integer,String> map=new LinkedHashMap<Integer,String>();
				for(Category cat:list)
				{
					map.put(cat.getCategoryId(), cat.getCategoryName());
				}
				model.addAttribute("map", map);
				model.addAttribute("searchAll","Currently no tickets available to view");
				return "viewTicketsAdmin";
			}
//			System.out.println(ticketAdminList);
			List<Priority> list=adminService.getPriority();
			model.addAttribute("list",list);
			model.addAttribute("ticketAdminList",ticketAdminList);
			model.addAttribute("user",userSession);
			return "displayAdminTickets";
		}

		@RequestMapping(value="/assignprioritybycategory/{categoryId}",method=RequestMethod.POST)
		public String assignPriorityByCategory(Model model,HttpServletRequest request,@PathVariable("categoryId")int categoryId){
			
			
			List<Ticket> ticketList=adminService.viewTicketByCategory(categoryId);
			Iterator<Ticket> it=ticketList.iterator();
			Ticket ticket;
			int ticketId;
			while(it.hasNext())
			{
				ticket=it.next();
				ticketId=ticket.getTicketId();
				if(request.getParameter(ticketId+"")!="")
				{
					int priorityId=Integer.parseInt(request.getParameter(ticketId+""));
//					System.out.println(ticketId+"priority: "+request.getParameter(ticketId+""));
					
					log.info(ticketId+"priority: "+request.getParameter(ticketId+""));
					adminService.assignPriority(ticketId,priorityId);
				}
			}
			model.addAttribute("assignprioritybycategory","Selected tickets priority assigned successfully!!");
			return "displayAdminTickets";
		}
		@RequestMapping(value="/assignpriorityAllTickets",method=RequestMethod.POST)
		public String assignPriorityAllTickets(Model model,HttpServletRequest request)
		{
			//User userSession=(User)session.getAttribute("user");
			List<Ticket> ticketList=adminService.viewAllTickets();
			Iterator<Ticket> itr=ticketList.iterator();
			Ticket ticket;
			int ticketId;
			while(itr.hasNext())
			{
				ticket=itr.next();
			    ticketId= ticket.getTicketId();
			    if(request.getParameter(String.valueOf(ticketId))!="")
			    {			    	
			    log.info(ticketId+"priority: "+request.getParameter(ticketId+""));
			    int priorityId=Integer.parseInt(request.getParameter(ticketId+""));
			    adminService.assignPriority(ticketId,priorityId);
			    
			    }
			}
			model.addAttribute("assignpriorityAllTickets","Selected tickets priority assigned successfully!!");
			return "displayAdminTickets";
		}
		
		@RequestMapping(value="/assignprioritybyid/{ticketId}",method=RequestMethod.POST)
		public String assignPriorityAllTickets(Model model,HttpServletRequest request,@PathVariable("ticketId") int ticketId)
		{
			//User userSession=(User)session.getAttribute("user");
			adminService.viewTicketById(ticketId);
			 if(request.getParameter(ticketId+"")!="")
			    {
//				 System.out.println(ticketId+"priority: "+request.getParameter(ticketId+""));
				 log.info(ticketId+"priority: "+request.getParameter(ticketId+""));
			    int priorityId=Integer.parseInt(request.getParameter(ticketId+""));
			    adminService.assignPriority(ticketId,priorityId);
			    }
			 model.addAttribute("assignprioritybyid",ticketId);
			 return "displayAdminTickets";
		}
		
		@RequestMapping(value="/setdeveloper",method=RequestMethod.POST)
		public String setDeveloper(Model model,HttpServletRequest request)
		{
			
			List<Ticket> ticketAdminList=adminService.viewAllTicketsWithPriority();
			Iterator<Ticket> itr=ticketAdminList.iterator();
			Ticket ticket;
			int ticketId;
			List<User>listDevelopers= adminService.getDevelopers();
			int size=listDevelopers.size();
			log.info("no of developers"+size);
			int noOfTickets=0;
			if(size>0)
			{
			while(itr.hasNext())
			{
				ticket=itr.next();
			    ticketId= ticket.getTicketId();
			    if(noOfTickets==size)
			    {
			    	noOfTickets=0;
			    }
			    if(request.getParameter(String.valueOf(ticketId))!=null)
			    {
			    	adminService.setDeveloper(ticket,listDevelopers.get(noOfTickets));
			    	//System.out.println(listDevelopers.get(noOfTickets));
			    	noOfTickets++;
			    }
			}
			return "assigndeveloper";
			}
			else
			{
				model.addAttribute("error", "Currently No developers Available");
				return "assigndeveloper";
			}
		}

}
