package com.virtusa.training.startup.springboot.web.rest.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.training.startup.springboot.biz.service.ShippmentService;
import com.virtusa.training.startup.springboot.data.enity.ShippmentEntity;

@RestController
@RequestMapping("/api/shipping")
public class ShippmentController {

	 @Inject
	    private ShippmentService shippmentService;

	    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
	    public ResponseEntity<ShippmentEntity> getHello(@RequestBody ShippmentEntity shippmentEntity) {
	    	ShippmentEntity  shipmentEntity = shippmentService.create(shippmentEntity);
	        return ResponseEntity.ok(shipmentEntity);
	    }
	    
//	    @RequestMapping(method = RequestMethod.GET)
//		public List<ShippmentEntity> getAll() {
//			List<ShippmentEntity> list = shippmentService.getAll();
//			return list;
//		}
//	    
//	    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
//	  		public ShippmentEntity get(@PathVariable("id") long id) {
//	    
//	  			ShippmentEntity shipmentObj = shippmentService.get(id);
//	  			return shipmentObj;
//	  		}
//	    
//	    @RequestMapping(path = "/{id}",method = RequestMethod.PUT)
//	  		public ShippmentEntity update(@PathVariable("id") long id,@RequestBody ShippmentEntity shippmentEntity) {
//	  			ShippmentEntity shipmentObj = shippmentService.update(id,shippmentEntity);
//	  			return shipmentObj;
//	  		}
}
