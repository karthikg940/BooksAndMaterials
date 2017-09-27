package com.virtusa.firstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xyz")
public class HomeController {

	@RequestMapping
	public String goHome() {
		return "index";
	}
}
