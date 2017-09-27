package com.virtusa.sample.web.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.virtusa.sample.service.SeatService
import com.virtusa.sample.web.controller.dto.SeatDto


@RestController
@RequestMapping("/api")
class SeatResource 
{
	
	@Autowired
	SeatService seatService
	
	/*get floor based on block */
	@RequestMapping(value="/seat/blockno/{blockNo}/floor",method=RequestMethod.GET)
	def getFloorByBlock(@PathVariable("blockNo") int blockNo )
	{
		seatService.getFloor(blockNo);
	}
	
	/*display seats based only on block */
	@RequestMapping(value="/seat/blockno/{blockNo}/seats",method=RequestMethod.GET)
	def getSeatByBlock(@PathVariable("blockNo") int blockNo)
	{
		seatService.getSeatBasedOnBlock(blockNo);
	} 
	
	/*display seats based on block and floor */
	@RequestMapping(value="/seat/block/{blockNo}/floor/{floorNo}",method=RequestMethod.GET)
	def getSeatByBlockAndFloor(@PathVariable("blockNo") int blockNo,@PathVariable("floorNo") int floorNo)
	{
		seatService.getSeatBasedOnBlkAndFlr(blockNo,floorNo);
	}
	
	/*display seats based on block and range*/
	@RequestMapping(value="/seat/block/{blockNo}/range/start/{startSeat}/end/{endSeat}",method=RequestMethod.GET)
	def getSeatByBlockAndSeat(@PathVariable("startSeat") String startSeat,@PathVariable("endSeat") String endSeat,@PathVariable("blockNo") int blockNo)
	{
		seatService.getSeatBasedOnBlkSeat(startSeat,endSeat,blockNo);
	}
		
	/*display seats in given RANGE regardless of block and floor*/
	@RequestMapping(value="/seat/start/{startSeat}/end/{endSeat}",method=RequestMethod.GET)
	def getSeatForGivenRange(@PathVariable("startSeat") String startSeat,@PathVariable("endSeat") String endSeat)
	{
		seatService.getSeatInRange(startSeat,endSeat);
	}
	
	/*display seats in given range based on block and floor */
	@RequestMapping(value="/seat/block/{blockNo}/floor/{floorNo}/range/start/{startSeat}/end/{endSeat}",method=RequestMethod.GET)
	def getSeatOnRangeBlockFloor( @PathVariable("blockNo") int blockNo,@PathVariable("floorNo") int floorNo,
		                          @PathVariable("startSeat")  String startSeat,@PathVariable("endSeat") String endSeat)
	{
		seatService.getSeatBasedOnRBF(blockNo,floorNo,startSeat,endSeat);
	} 
	
	/*update status to 'Reserved' */
	@RequestMapping(value="/allocate/status/seat/{seatName}",method=RequestMethod.POST)
	def updateStatus(@PathVariable("seatName") String seatName)
	{
		seatService.updateStatusReserv(seatName);
	}
	
	/*update status to 'Available' */
	@RequestMapping(value="/deallocate/status/seat/{seatName}",method=RequestMethod.POST)
	def updateStatusToAvail(@PathVariable("seatName") String seatName)
	{
		seatService.updateStatusToAvail(seatName);
	}
	
	/*add new seat*/
	
		@RequestMapping(value="/seat",method=RequestMethod.POST)
		def addNewSeat(@RequestBody SeatDto seatDto) 
		{
			ResponseEntity.created(new URI("/api/seat/${seatService.addSeat(seatDto).seatName}".toString())).build();
		}
		
		@RequestMapping(value="/seat/status/{seatName}",method=RequestMethod.GET)
		def findingStatus(@PathVariable("seatName") String seatName) {
			seatService.findingStatus(seatName);
		}
		
		@RequestMapping(value="/seat/{seatName}",method=RequestMethod.DELETE)
		def deleteSeat(@PathVariable("seatName") String seatName) {
			seatService.deleteSeat(seatName);
		
	}
	
}
