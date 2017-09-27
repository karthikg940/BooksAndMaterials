package com.virtusa.sample.web.controller.dto	
	import javax.validation.constraints.NotNull
	
	class EmployeeDto {
	
		@NotNull
		Long id
		def empName
		def project
		def email
		
		@NotNull
        String seatName
		def blockNo
		def floorNo
		def status
		
		def slNo
		@NotNull
		Long empId
		def startDate
		def endDate
	
	}
	

