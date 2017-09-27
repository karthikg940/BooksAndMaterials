package com.virtusa.training.startup.springboot.biz.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.virtusa.training.startup.springboot.data.enity.ShippmentEntity;
import com.virtusa.training.startup.springboot.data.repository.ShippmentRepository;


@Service
@Transactional
public class ShippmentService {

	@Inject
	private ShippmentRepository shipmentRepository;
	
	public ShippmentEntity create(ShippmentEntity shippmentEntity)
	{
		return shipmentRepository.save(shippmentEntity);
	}

//	public List<ShippmentEntity> getAll() {
//		// TODO Auto-generated method stub
//		return shipmentRepository.findAll();
//	}
//
//	public ShippmentEntity get(long id) {
//		// TODO Auto-generated method stub
//		return shipmentRepository.findOne(id);
//	}
//
//	public ShippmentEntity update(long id,ShippmentEntity shipmentEntity) {
//		// TODO Auto-generated method stub
//		ShippmentEntity shipmentObj=shipmentRepository.findOne(id);
//		shipmentObj.setOrderId(6);
//		return shipmentRepository.save(shipmentObj);
//	}
//	
}
