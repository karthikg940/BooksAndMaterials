package com.virtusa.sample.web.controller.dto

import javax.validation.constraints.NotNull

class SeatDto {
	
		@NotNull
		def seatName
		long  blockNo
		long  floorNo
		def status
	}
	

