package com.virtusa.sample.service
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.virtusa.sample.domain.Allocation
import com.virtusa.sample.repository.AllocationRepository

@Service
class AllocationService {

	String month,date,year
	DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy/MM/dd");
	String[] startDateArray
	String[] endDateArray
	@Autowired
	AllocationRepository allocationRepository

	/*Allocate New Seat */
	@Transactional
	def insert(empDto) {
		String startDate = empDto.startDate
		String endDate = empDto.endDate
		if(startDate.contains("/"))
		{
			startDateArray = startDate.split("/")
			endDateArray = endDate.split("/")
		}
		else if(startDate.contains("-"))
		{
			startDateArray = startDate.split("-")
			endDateArray = endDate.split("-")
		}
		String start = calculateDate(startDateArray)
		String end = calculateDate(endDateArray)
		allocationRepository.save(new Allocation("seatName":empDto.seatName,"empId":empDto.empId,
		                                         "startDate": formatter.parseDateTime(start),
		                                         "endDate":formatter.parseDateTime(end)))
	}

	def calculateDate(datearray) {
		year = datearray[0]
		date = datearray[2]
		month = datearray[1]
		datearray[0]=year
		datearray[1]=month
		datearray[2]=date
		return datearray[0]+"/"+datearray[1]+"/"+datearray[2]
	}

	/*pop-up employee details based on seat_id */
	@Transactional
	def displayPopup(seatName) {
		allocationRepository.modalPopup(seatName)
	}
	
	/*DeAllocate*/
	@Transactional
	def deleteAllocated(seatName) {
		allocationRepository.deleteAllocation(seatName)
	}
}
