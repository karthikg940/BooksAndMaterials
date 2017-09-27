package com.virtusa.audit.eda.entity;

import java.io.File;

import javax.persistence.EntityManager;
import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

	private EntityManager entityManager;
	@Override
	public void process(Exchange exchange) throws Exception {
		Message msg=exchange.getIn();
//		LoadAuditEntity loadauditentity =msg.getBody(LoadAuditEntity.class);
//		JAXBContext context=JAXBContext.newInstance(LoadAuditEntity.class);
//		context.createUnmarshaller().unmarshal();
//		loadauditentity.setAuditId(1);
//		loadauditentity.setCamelMsgId("messageId");
//		loadauditentity.setPayload("payLoad");
//		loadauditentity.setAuditStep("auditstep");
//		loadauditentity.setCreateBy("createBy");
//		loadauditentity.setLoadStatus("loadStatus");
//		loadauditentity.setPayloadType("xml type");
//		loadauditentity.setSourcePartnerId(2);
//		loadauditentity.setSourcePartnerName("partner");
//		entityManager.persist(loadauditentity);
	}

	
	/*public void process(Exchange exchange) throws Exception {
		Message message = exchange.getIn();
		LoadAuditEntity obj=message.getBody(LoadAuditEntity.class);
//		LoadAuditEntity obj1 = exchange.getIn().getBody(LoadAuditEntity.class);
		JAXBContext context=JAXBContext.newInstance(LoadAuditEntity.class);
		//context.createUnmarshaller().unmarshal(message.getBody());
		System.out.println(obj.toString() + "this is the object");
		System.out.println("entered before sets");
		message.setHeader("AuditId", obj.getAuditId());
		message.setHeader("SourcePartnerId", obj.getSourcePartnerId());
		message.setHeader("SourcePartnerName", obj.getSourcePartnerName());
		message.setHeader("AuditStep", obj.getAuditStep());
		message.setHeader("CamelMessageId", obj.getCamelMsgId());
		message.setHeader("CreateBy", obj.getCreateBy());
		message.setHeader("CreateTimestamp", obj.getCreateTimestamp());
		message.setHeader("LoadDuration", obj.getLoadDuration());
		message.setHeader("LoadEndDateTime", obj.getLoadEndDateTime());
		message.setHeader("LoadStartDateTime", obj.getLoadStartDateTime());
		message.setHeader("LoadStatus", obj.getLoadStatus());
		message.setHeader("Payload", obj.getPayload());
		message.setHeader("PayloadType", obj.getPayloadType());
		
		System.out.println(message);
	}*/
	
	
	
	
}
