package com.virtusa.spring.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.spring.boot.controller.SpringController;


//@RestController
//@EnableAutoConfiguration 
@SpringBootApplication
public class MainAppl {
	
	/*@RequestMapping("/home/appl")
	String home(){
		return "Hello world";
	}*/
	
	public static void main(String[] args) {
		
		//SpringApplication.run(MainAppl.class, args);
		SpringApplication sp=new SpringApplication(MainAppl.class);
		sp.setBannerMode(Banner.Mode.OFF);
		sp.run(args); 
		 
		
	}

}
