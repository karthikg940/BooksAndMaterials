
package com.virtusa.sample.web.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import com.virtusa.sample.service.SeatService

@Controller
class IndexController {
	@Autowired
	SeatService seatService

	@RequestMapping("/login")
	def login() {
		'login'
	}

	@RequestMapping("/index")
	def index(Model model) {
		model.addAttribute("block",seatService.getBlock())
		'index'
	}
	@RequestMapping("/manageSeat")
	def addseat() {

		'manageSeat'
	}
}
