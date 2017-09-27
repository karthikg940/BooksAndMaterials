package com.virtusa.shipment.web.rest.resource;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.shipment.biz.service.ShippmentService;
import com.virtusa.shipment.data.enity.ShippmentEntity;

@RestController
@RequestMapping("/api/shipment")
public class ShippmentResource {

	@Inject
	private ShippmentService shippmentService;

	@RequestMapping(method = RequestMethod.POST)
	public  ResponseEntity<Long> create(
			@RequestBody ShippmentEntity shippmentEntity) {
		
//		Link link = linkTo(ShippmentController.class).slash(id).withSelfRel();
//		return ResponseEntity.created(new URI("/api/shipment/" + id))
//				.body(link);
		if(shippmentEntity.getStatus()==null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		else
		{
			long id = shippmentService.create(shippmentEntity);
			return ResponseEntity.ok(id);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ShippmentEntity>> getAll() {
		List<ShippmentEntity> list = shippmentService.getAll();
		if(list.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		else
		{
		return ResponseEntity.ok(list);
		}
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ShippmentEntity> get(@PathVariable("id") Long id) {
		
		if(id == null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		else
		{
			ShippmentEntity shipmentObj = shippmentService.get(id);
		return ResponseEntity.ok(shipmentObj);
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ShippmentEntity> update(
			@RequestBody ShippmentEntity shippmentEntity) {
		if(shippmentEntity.getStatus()==null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		else
		{
		ShippmentEntity shipmentObj = shippmentService.update(shippmentEntity);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<ShippmentEntity> update(@PathVariable("id") long id,
			@RequestBody ShippmentEntity shippmentEntity) {
		
		if(shippmentEntity.getStatus()==null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		ShippmentEntity shipmentObj = shippmentService.get(id);
		 if(shipmentObj.getStatus()=="cancelled" && shippmentEntity.getStatus()=="delivered")
		{
			 return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}
		else
		{
		ShippmentEntity shipmentObj1 = shippmentService.partialUpdate(id,
				shippmentEntity);
		return ResponseEntity.ok(shipmentObj1);
		}
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		
		if(id == null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		else
		{
		shippmentService.delete(id);
		return ResponseEntity.noContent().build();
		}
	}
}
