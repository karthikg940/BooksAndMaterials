package com.virtusa.shipment.biz.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.shipment.NotificationSender;
import com.virtusa.shipment.data.enity.ShippmentEntity;
import com.virtusa.shipment.data.repository.ShippmentRepository;

@Service
public class ShippmentService {

	@Autowired
	private ShippmentRepository shipmentRepository;
	@Autowired
	private NotificationSender notificationSender;

	public long create(ShippmentEntity shippmentEntity) {
		ShippmentEntity shippmentObj = shipmentRepository.save(shippmentEntity);
		return shippmentObj.getId();
	}

	public List<ShippmentEntity> getAll() {
		return shipmentRepository.findAll();
	}

	public ShippmentEntity get(long id) {
		return shipmentRepository.findOne(id);
	}

	@Transactional
	public ShippmentEntity update(ShippmentEntity shipmentEntity) {
		return shipmentRepository.save(shipmentEntity);
	}

	@Transactional
	public ShippmentEntity partialUpdate(long id,
			ShippmentEntity shippmentEntity) {
		ShippmentEntity shipmentObj = shipmentRepository.findOne(id);
		shipmentObj.setStatus(shippmentEntity.getStatus());
		if (shipmentObj.getStatus() != null) {
			notificationSender.sender(shipmentObj.getStatus());
		}
		return shipmentRepository.save(shipmentObj);
	}

	@Transactional
	public void delete(long id) {
		shipmentRepository.delete(id);
	}
}
