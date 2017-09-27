package com.virtusa.spring.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.spring.model.Category;
import com.virtusa.spring.model.FileUpload;
import com.virtusa.spring.model.Project;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;
import com.virtusa.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController  {
	
	@Autowired
	private UserService userService;
	@Autowired
	HttpSession session;

	static Logger log = Logger.getLogger(UserController.class);


		public static Logger getLog() {
			return log;
		}
        public static void setLog(Logger log) {
			UserController.log = log;
		}

	@RequestMapping("/login")
	public String goHome(Model model){
//		System.out.println("Main Controllerr in Go Home Handler method");
		log.info("in user controller logincheck handler");
		return "login";
	}
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST)
	public String loginDetails(Model model,@RequestParam("userName")String userName,@RequestParam("password") String password,HttpServletRequest request) throws com.virtusa.spring.exceptions.UserException{
		log.info("in controller");
		User user;
		 
			user = userService.addLogin(userName,password);
		
//		System.out.println(user);
		log.info(user);
		if(user==null)
		{
			model.addAttribute("error","UserName or password is doesn't exists!!");
			return "login";
		}
		else{
			session = request.getSession();
			session.setAttribute("user",user);
			model.addAttribute("user",user);
			return "homepage";
		}
		 
	}

    @RequestMapping("/reg")
	public String reg(Model model)//Error//@Valid
	{
		model.addAttribute("user", new User());
		log.info("reg");
		return "registration";
	}

		@RequestMapping("/registration")
			public String registration(Model model,@Valid @ModelAttribute User user,Errors errors)
			{
				if(!errors.hasErrors()){
				log.info("controller");
				boolean register=userService.registration(user);
				if(register==false)
				{
					model.addAttribute("error", "Username Already Exists...Please Enter other!!!");
				}
				else
				{
					model.addAttribute("success", "User Registered Successfully!!!");
				}
				return "registration";
				}
				else
				{
					log.info(errors.getErrorCount());
					log.info("errors found not calling service");
					model.addAttribute("user",user);
					return "registration";
				}
			}

		@RequestMapping(value="/Raise Ticket",method=RequestMethod.GET)
			public String validateUser1(Model model)
			{
				
				model.addAttribute("ticket",new Ticket());
				//HttpSession session = request.getSession();
				log.info("------------------------");
				//User userSession=(User)session.getAttribute("user");
				//log.info(userSession);
				List<Project> projectList=userService.getProjects();
				Map<Integer,String> projectMap=new LinkedHashMap<Integer,String>();
				for(Project project:projectList)
				{
					projectMap.put(project.getProjectId(), project.getProjectName());
				}
				/*project map end*/
				List<Category> list=userService.getCategory();
				Map<Integer,String>categoryMap=new LinkedHashMap<Integer,String>();
				for(Category cat:list)
				{
					categoryMap.put(cat.getCategoryId(), cat.getCategoryName());
				}
				/*System.out.println();*/
//				User user=userService.getUser(userId);
//				log.info(userId+"in rise");
				model.addAttribute("projectMap", projectMap);
				model.addAttribute("categoryMap", categoryMap);
				//model.addAttribute("user",userSession);
				return "raiseticket";
			}
		@RequestMapping(value="/ticketdetails",method=RequestMethod.POST)
		public String ticketDetails(Model model,@RequestParam("description") String description,@RequestParam("category") int category,@RequestParam("project") int projectId) throws SQLException
		{
			model.addAttribute("ticket",new Ticket());
			//HttpSession session = request.getSession();
			User userSession=(User)session.getAttribute("user");
			log.info(userSession);
			log.info(category+""+projectId+""+description); 
			Ticket ticket=userService.ticketDetails(userSession,category,projectId,description);
			
			List<Category> list=userService.getCategory();
			Map<Integer,String> categoryMap=new LinkedHashMap<Integer,String>();
			for(Category cat:list)
			{
				categoryMap.put(cat.getCategoryId(), cat.getCategoryName());
			}
			
			List<Project> projectList=userService.getProjects();
			Map<Integer,String> projectMap=new LinkedHashMap<Integer,String>();
			for(Project project:projectList)
			{
				projectMap.put(project.getProjectId(), project.getProjectName());
			}
			
			if(ticket!=null){
				model.addAttribute("ticket",ticket);
				//model.addAttribute("user", userSession);
				model.addAttribute("projectMap", projectMap);
				model.addAttribute("categoryMap", categoryMap);
				model.addAttribute("success","Your Ticket with Id ("+ticket.getTicketId()+") Submitted successfully..Please note Your Ticket Id");
			return "raiseticket";
			}
			else
			{
				model.addAttribute("projectMap", projectMap);
				model.addAttribute("categoryMap", categoryMap);
				model.addAttribute("error","Your ticket not submitted....Please Enter correct project Id");
				return "raiseticket";
			}
		} 
		
		@RequestMapping(value="/View Status",method=RequestMethod.GET)
		public String viewTicket(Model model)
		{
			model.addAttribute("ticket",new Ticket());
			List<Category> list=userService.getCategory();
			Map<Integer,String> map=new LinkedHashMap<Integer,String>();
			for(Category cat:list)
			{
				map.put(cat.getCategoryId(), cat.getCategoryName());
			}
//			User user=userService.getUser(userId);
//			log.info(userId+"in rise");
			model.addAttribute("map", map);
			//model.addAttribute("user",userSession);
			return "viewstatusticket";
		}
			
			
		
		@RequestMapping(value="/viewStatusById",method=RequestMethod.POST)//change url
		public String viewTicketById(Model model,@RequestParam("ticketId") int ticketId)
		{
//			System.out.println("in download controller");
			log.info("in download controller");
//			System.out.println("-----------------"+ticketId);
			log.info("-----------------"+ticketId);
			model.addAttribute("ticket",new Ticket());
			User userSession=(User)session.getAttribute("user");
			Ticket ticket=userService.viewTicketById(ticketId,userSession.getUserId());
			//model.addAttribute("ticketId", ticketId);
			log.info(ticket);
			System.out.println("ticket data"+ticket);
			if(ticket==null || ticket.getTicketId()==0)
				
			{
				List<Category> list=userService.getCategory();
				Map<Integer,String> map=new LinkedHashMap<Integer,String>();
				for(Category cat:list)
				{
					map.put(cat.getCategoryId(), cat.getCategoryName());
				}
				model.addAttribute("map", map);
				model.addAttribute("searchId","No Tickets found with Ticket Id "+ticketId);
				return "viewstatusticket";
			}
			
			List listFileData=userService.getdownLoadData();
//			System.out.println(listFileData);
			log.info(listFileData);
//			System.out.println(" "+listFileData);
			log.info(" "+listFileData);
			
			model.addAttribute("list", listFileData);
			model.addAttribute("ticket", ticket);
			return "viewTickets";//need to change jsp page
		}
		
		@RequestMapping(value="/viewStatusByAll",method=RequestMethod.POST)//change url
		public String viewAllTickets(Model model)
		{
			model.addAttribute("ticket",new Ticket());
			//HttpSession session = request.getSession();
			log.info("------------------------");
			User userSession=(User)session.getAttribute("user");
			int userId=userSession.getUserId();
			List<Ticket> list=userService.viewAllTickets(userId);
			if(list.size()==0)
			{

				List<Category> listCategory=userService.getCategory();
				Map<Integer,String> map=new LinkedHashMap<Integer,String>();
				for(Category cat:listCategory)
				{
					map.put(cat.getCategoryId(), cat.getCategoryName());
				}
				model.addAttribute("map", map);
				model.addAttribute("searchAll","Currently you doesn't have any tickets");
				return "viewstatusticket";
			}
			List listFileData=userService.getdownLoadData();
			model.addAttribute("list", listFileData);
			model.addAttribute("ticketList", list);
			return  "viewTickets";//need to change jsp page
		}
 	 
		@RequestMapping(value="/viewStatusByCategory",method=RequestMethod.POST)//change url
		public String viewTicketByCategory(Model model,@RequestParam("category") int categoryId)
		{
			model.addAttribute("ticket",new Ticket());
			//model.addAttribute("ticket",new Ticket());
			//HttpSession session = request.getSession();
			log.info("------------------------");
			User userSession=(User)session.getAttribute("user");
			int userId=userSession.getUserId();
			log.info("in cont");
			log.info(categoryId);
			List<Ticket> list=userService.viewTicketByCategory(categoryId,userId);
			log.info("service alltickets "+list);
			if(list.size()==0)
			{
				List<Category> listCategory=userService.getCategory();
				Map<Integer,String> map=new LinkedHashMap<Integer,String>();
				for(Category cat:listCategory)
				{
					map.put(cat.getCategoryId(), cat.getCategoryName());
				}
				model.addAttribute("map", map);
				model.addAttribute("searchCategory","No Tickets found with ticket category");
				return "viewstatusticket";
			}
			List listFileData=userService.getdownLoadData();
			model.addAttribute("list", listFileData);
			//model.addAttribute("category",categoryId);
			model.addAttribute("ticketListUser", list);
			
			return  "viewTickets";//need to change jsp page
		}
		
		@RequestMapping(value="/download/{ticketId}")
		public String download(HttpServletResponse response,
				@PathVariable("ticketId") int ticketId) throws IOException   {
//			System.out.println("-------------------------------------- in download controller");
			log.info("-------------------------------------- in download controller");
//			System.out.println(ticketId);
			log.info(ticketId);
			
			// MIME type of the file
			response.setContentType("application/octet-stream");
			// Response header
			response.setHeader("Content-Disposition", "attachment; filename=\"");
			// Read from the file and write into the response
			OutputStream os = response.getOutputStream();

			InputStream in = new ByteArrayInputStream(userService.getFileData(ticketId));

			byte[] outputByte = new byte[2097152];
			// copy binary contect to output stream
			while (in.read(outputByte, 0, 4096) != -1) {
				os.write(outputByte, 0, 4096);
			}
			in.close();
			os.flush();
			os.close();
			return "viewTickets";
		}
		@RequestMapping("/loginhome")
		public String goLoginHome()
		{
			return "home";
		}
		@RequestMapping("/home")
		public String goAfterLoginHome()
		{
			return "homepage";
		}
		
		@RequestMapping("/about")
		public String goAbout()
		{
			return "About";
		}
		@RequestMapping("/contact")
		public String goContact()
		{
			return "Contact";
		}
		
		@RequestMapping("/logout")
		public String logout()
		{
			//HttpSession session = request.getSession();
			session.invalidate();
			return "home";
		}
		
		
		
		
	
}
