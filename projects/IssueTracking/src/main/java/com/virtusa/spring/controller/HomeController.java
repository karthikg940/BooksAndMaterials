package com.virtusa.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	static Logger log=Logger.getLogger(HomeController.class);
	@RequestMapping("/")
	public String goHome()
	{
		log.info("in home controller");
		return "home";
	}
}
