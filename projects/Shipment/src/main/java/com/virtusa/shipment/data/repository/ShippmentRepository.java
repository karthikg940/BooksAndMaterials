package com.virtusa.shipment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.shipment.data.enity.ShippmentEntity;

public interface ShippmentRepository extends
		JpaRepository<ShippmentEntity, Long> {

}
