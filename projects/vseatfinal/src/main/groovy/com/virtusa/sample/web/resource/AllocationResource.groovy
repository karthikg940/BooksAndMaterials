package com.virtusa.sample.web.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.virtusa.sample.service.AllocationService
import com.virtusa.sample.web.controller.dto.EmployeeDto


@RestController
@RequestMapping("/api")
class AllocationResource 
{
	
	@Autowired
	AllocationService allocationService
	
	/*Allocate New Seat */
	@RequestMapping(value="/allocation/create",method=RequestMethod.POST)
	def insertAllocation(@RequestBody EmployeeDto empDto) 
	{
		allocationService.insert(empDto);
	}
	
	/*pop-up employee details based on seat_id */
	@RequestMapping(value="/allocation/getDetails/seat/{seatName}",method=RequestMethod.GET)
	def displayDetails(@PathVariable("seatName") String seatName) 
	{
		allocationService.displayPopup(seatName);
	}
	
	/*DeAllocate*/
	@RequestMapping(value="/allocation/delete/seat/{seatName}",method=RequestMethod.POST)
	def deleteAllocation(@PathVariable("seatName") String seatName) 
	{
		allocationService.deleteAllocated(seatName);
	}
	
}
