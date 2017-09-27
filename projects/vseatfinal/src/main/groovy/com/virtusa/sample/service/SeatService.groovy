package com.virtusa.sample.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.virtusa.sample.domain.Seat
import com.virtusa.sample.repository.SeatRepository

@Service
class SeatService {

	@Autowired
	SeatRepository seatRepository
	
	/*get block */
	@Transactional
	def getBlock(){
		seatRepository.getDistinctBlockno();
	}
	
	/*get floor based on block */
	@Transactional
	def getFloor(blockNo){
		seatRepository.findByBlock_no(blockNo);
	}
	
	/*display seats based only on block */
	@Transactional
	def getSeatBasedOnBlock(blockNo) {
		seatRepository.getSeatByBlock(blockNo)
	}
	
	/*display seats based on block and floor */
	@Transactional
	def getSeatBasedOnBlkAndFlr(blockNo,floorNo) {
		seatRepository.getSeatByBlockAndFloor(blockNo,floorNo)
	}
	
	/*display seats based on block and range */
	@Transactional
	def getSeatBasedOnBlkSeat(startSeat,endSeat,blockNo){
		seatRepository.getSeatByBlockSeats(startSeat,endSeat,blockNo);
	}
	
	/*display seats in given RANGE regardless of block and floor*/
	@Transactional
	def getSeatInRange(startSeat,endSeat) {
		seatRepository.getSeatInSpecificRange(startSeat,endSeat)
	}
	
	/*display seats in given range based on block and floor */
	@Transactional
	def getSeatBasedOnRBF(blockNo,floorNo,startSeat,endSeat){
		seatRepository.findSeatOnRBF(blockNo,floorNo,startSeat,endSeat);
	}
	
	/*update status to 'Available' */
	@Transactional
	def updateStatusToAvail(seatName) {
		seatRepository.updateStatusToAvailable(seatName)
	}
	
	/*update status to 'Reserved' */
	@Transactional
	def updateStatusReserv(seatName) {
		seatRepository.updateStatusToReserved(seatName)
	}
	
	/*add new seat*/
	@Transactional
	def addSeat(seatDto) {
		seatRepository.save(new Seat("seatName":seatDto.seatName,"blockNo":seatDto.blockNo,
		                              "floorNo":seatDto.floorNo,"status":seatDto.status))                  
	}
	@Transactional
	def findingStatus(seatName) {
		seatRepository.findStatus(seatName)
	}
	@Transactional
	def deleteSeat(seatName) {
		println("hi");
		seatRepository.delete(seatName)
	}
}
