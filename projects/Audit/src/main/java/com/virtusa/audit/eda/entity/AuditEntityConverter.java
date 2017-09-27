package com.virtusa.audit.eda.entity;

import javax.persistence.EntityManager;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;

public class AuditEntityConverter implements TypeConverters {

//	private EntityManager em;
	@Converter
	public LoadAuditEntity convertTo(String payLoad) {
	
		System.out.println(payLoad);
		LoadAuditEntity loadauditentity = new LoadAuditEntity();
		loadauditentity.setAuditId(1);
		loadauditentity.setCamelMsgId("messageId");
		loadauditentity.setPayload(payLoad);
		loadauditentity.setAuditStep("auditstep");
		loadauditentity.setCreateBy("createBy");
		loadauditentity.setLoadStatus("loadStatus");
		loadauditentity.setPayloadType("xml type");
		loadauditentity.setSourcePartnerId(2);
		loadauditentity.setSourcePartnerName("partner");
//		em.persist(loadauditentity);
		return loadauditentity;
	}

}
