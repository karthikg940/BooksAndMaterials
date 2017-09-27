package com.virtusa.training.startup.springboot.data.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "SHIPMENT")
public class ShippmentEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonProperty("shipmentId")
	private Long id;
	
	@Column(name = "OID")
	private int orderId;
	
	@Column(name = "PID")
	private int productId;
	
	@Column(name = "STATUS")
	private String status;

	
//	  public ShippmentEntity() { super(); }
//	  
//	  public ShippmentEntity(Long id, int orderId, int productId, String
//	  status) { super(); this.id = id; this.orderId = orderId; this.productId =
//	 productId; this.status = status; }
//	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
