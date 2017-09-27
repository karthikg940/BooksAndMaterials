package com.virtusa.sample.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.stereotype.Repository

import com.virtusa.sample.domain.Allocation
import com.virtusa.sample.domain.Employee

@RestResource
@Repository
interface AllocationRepository extends JpaRepository<Allocation, Long>
{
	/*pop-up employee details based on seat_id */
	@Query("select e.id,e.empName,e.project,e.email,a.seatName from Employee e,Allocation a where e.id in (select empId from Allocation where seatName = :seatName)")
	public List<Employee> modalPopup(@Param("seatName") String seatName);
	
	/*DeAllocate*/
	@Modifying(clearAutomatically=true)
	@Query("delete from Allocation where seatName=:seatName")
	public void deleteAllocation(@Param("seatName") String seatName);
}

