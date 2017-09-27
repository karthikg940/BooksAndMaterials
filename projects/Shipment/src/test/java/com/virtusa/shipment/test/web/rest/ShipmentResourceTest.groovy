package com.virtusa.shipment.test.web.rest
import static org.hamcrest.Matchers.*
import static org.hamcrest.collection.IsCollectionWithSize.hasSize
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType
import org.springframework.web.context.WebApplicationContext;
import spock.lang.Unroll
import com.virtusa.shipment.test.base.TransactionalWebIntegrationTest
import com.virtusa.shipment.test.base.WebAppIntegrationBaseSpecification

@TransactionalWebIntegrationTest
class ShipmentResourceTest extends WebAppIntegrationBaseSpecification {
	
	
	@Unroll
	def "get the shipment record based on id" (id,orderId,productId,statusCode) {
		given:"based on the id we need to fetch the shipment details"

		when: "I entered the id"
		def createResponse=this.mockMvc.perform(get("/api/shipment/1").accept(MediaType.APPLICATION_JSON))
		then: "a record is fetched"
		createResponse.andExpect(status().is(statusCode))
		if(statusCode == 200) {
			createResponse.andExpect(is(statusCode))
		}
		where:
		id  | orderId |productId |statusCode
		1   | 1       | 1        | 200
	
	}
	
	@Unroll
	def "get the shipment d based on id" (id,orderId,productId,statusCode) {
		given:"based on the id we need to fetch the shipment details"

		when: "I entered the id"
		def createResponse=this.mockMvc.perform(get("/api/shipment").accept(MediaType.APPLICATION_JSON))
		then: "a record is fetched"
		createResponse.andExpect(status().is(statusCode))
//		if(statusCode == 200) {
//			createResponse.andExpect(is(statusCode))
//		}
		where:
		id  | orderId |productId |statusCode
		1   | 1       | 1        | 200
	
	}

	



//	@Unroll
//	def "get seat_id and status between start and end based on block and floor where block =#block_no and floor = #floor_no " (start,end,block,floor,statusCode) {
//		given:"based on the block and floor we need to fetch seat_id and status between "
//
//		when: "I entered the block, floor, start_seat and end_seat"
//		def createResponse=this.mockMvc.perform(get("/api/seat/"+start+"/"+end +"/"+block +"/"+floor).accept(MediaType.APPLICATION_JSON))
//		then: "a floor is fetched"
//
//
//		createResponse.andExpect(status().is(statusCode))
//		where:
//		start    | end     | block   |  floor   |statusCode
//		100     | 120	  |   10    |    5     |200
//		10000   | 1000000 |   10    |    7     |200
//		1       | 10000   |   10    |    1     |400
//	}
//
//
//	@Unroll
//	def "update the status to resrved"(seat_id,statusCheck) {
//		given:"based on the allocation of employee to particular seat we need to change the status"
//
//
//		when:"when ever employee is allocated to particular seat status should be changed "
//		def createResponse=this.mockMvc.perform(patch("/api/block/${blockId}/floor/${floorId}/seat/${seatId}/allocate").content([resourceId:12]).contentType(MediaType.APPLICATION_JSON))
//		then : "status is changed to reserved"
//
//		createResponse.andExpect(status().is(statusCheck))
//		
//		
//		// GET Request for the resource that was just created??
//		where:
//		seat_id      | statusCheck
//		105		   |     201
//		102          |     200
//		103          |     400
//		101          |     200
//		105          |     400
//		106          |     400
//	}
//
//
//
//	@Unroll
//	def "update status to available"(seat_id,statusCheck) {
//		given:"based on the deallocation of employee to particular seat we need to change the status"
//
//		when:"when ever an employee is deallocated to particular seat status should be changed "
//		def createResponse=this.mockMvc.perform(post("/api/seatDeAllocate/"+seat_id).accept(MediaType.APPLICATION_JSON))
//		then : "status is changed to allocate"
//
//
//		createResponse.andExpect(status().is(statusCheck))
//
//		where:
//		seat_id      | statusCheck
//		100		   |     200
//		103        |     200
//		104        |     200
//		160        |     200
//	}
}


















