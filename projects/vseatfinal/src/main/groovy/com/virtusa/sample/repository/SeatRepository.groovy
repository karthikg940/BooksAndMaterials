package com.virtusa.sample.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.stereotype.Repository

import com.virtusa.sample.domain.Seat

@RestResource
@Repository
interface SeatRepository extends JpaRepository<Seat, String>
{
	 /*get block */
	 @Query("SELECT distinct blockNo  FROM Seat")
     public List<Seat> getDistinctBlockno();     
	      
	 /*get floor based on block */
	 @Query("SELECT distinct floorNo  FROM Seat where blockNo = :blockNo")
	 public List<Seat> findByBlock_no(@Param("blockNo") int blockNo);
	
	 /*display seats based only on block */
	 @Query("SELECT seatName,blockNo,floorNo,status from Seat where blockNo = :blockNo")
	 public List<Seat> getSeatByBlock(@Param("blockNo") int blockNo);
	
	 /*display seats based on block and floor */
	 @Query("SELECT seatName,blockNo,floorNo,status from Seat where floorNo = :floorNo and blockNo = :blockNo")
	 public List<Seat> getSeatByBlockAndFloor(@Param("blockNo") int blockNo,@Param("floorNo") int floorNo);
	
	 /*display seats based on block and range */
	 @Query("SELECT seatName,blockNo,floorNo,status from Seat where seatName between :startSeat and :endSeat and blockNo=:blockNo" )
	 public List<Seat> getSeatByBlockSeats(@Param("startSeat") String startSeat,@Param("endSeat") String endSeat,@Param("blockNo") int blockNo);
	
	 /*display seats in given range regardless of block and floor*/
	 @Query("SELECT seatName,blockNo,floorNo,status from Seat where seatName between :startSeat and :endSeat")
	 public List<Seat> getSeatInSpecificRange(@Param("startSeat") String startSeats,@Param("endSeat") String endSeats);
  
	 /*display seats in given RANGE based on BLOCK and FLOOR */
     @Query("SELECT seatName,blockNo,floorNo,status from Seat where seatName between :startSeat and :endSeat and blockNo=:blockNo and floorNo=:floorNo" )
 	 public List<Seat> findSeatOnRBF(@Param("blockNo") int blockNo,@Param("floorNo") int floorNo,@Param("startSeat") String startSeat,@Param("endSeat") String endSeat);
	 
	 /*update status to 'Reserved' */
	 @Modifying(clearAutomatically = true)
	 @Query("UPDATE Seat set status ='Reserved' where seatName = :seatName")
	 public void updateStatusToReserved(@Param("seatName") String seatName);
	 
	 /*update status to 'Available' */
	 @Modifying(clearAutomatically = true)
	 @Query("UPDATE Seat set status ='Available' where seatName = :seatName")
	 public void updateStatusToAvailable(@Param("seatName")  String seatName);
	 
	 @Query("select status from Seat where seatName = :seatName ")
	 public List<Seat> findStatus(@Param("seatName") String seatName)
}


