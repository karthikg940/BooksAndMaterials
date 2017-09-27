package com.lly.audit.eda.entity;

import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoadAuditEntity {

	private int auditId;

	private int sourcePartnerId;

	private String sourcePartnerName;

	private String camelMsgId;

	private String payloadType;

	private Clob payload;

	private String auditStep;

	private String loadStatus;

	private Date loadStartDateTime;

	private Date loadEndDateTime;

	private Date loadDuration;

	private String createBy;

	private Timestamp createTimestamp;

	public LoadAuditEntity() {
	}

	public LoadAuditEntity(int auditId, int sourcePartnerId,
			String sourcePartnerName, String camelMsgId, String payloadType,
			Clob payload, String auditStep, String loadStatus,
			Date loadStartDateTime, Date loadEndDateTime, Date loadDuration,
			String createBy, Timestamp createTimestamp) {
		super();
		this.auditId = auditId;
		this.sourcePartnerId = sourcePartnerId;
		this.sourcePartnerName = sourcePartnerName;
		this.camelMsgId = camelMsgId;
		this.payloadType = payloadType;
		this.payload = payload;
		this.auditStep = auditStep;
		this.loadStatus = loadStatus;
		this.loadStartDateTime = loadStartDateTime;
		this.loadEndDateTime = loadEndDateTime;
		this.loadDuration = loadDuration;
		this.createBy = createBy;
		this.createTimestamp = createTimestamp;
	}

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

	public int getSourcePartnerId() {
		return sourcePartnerId;
	}

	public void setSourcePartnerId(int sourcePartnerId) {
		this.sourcePartnerId = sourcePartnerId;
	}

	public String getSourcePartnerName() {
		return sourcePartnerName;
	}

	public void setSourcePartnerName(String sourcePartnerName) {
		this.sourcePartnerName = sourcePartnerName;
	}

	public String getCamelMsgId() {
		return camelMsgId;
	}

	public void setCamelMsgId(String camelMsgId) {
		this.camelMsgId = camelMsgId;
	}

	public String getPayloadType() {
		return payloadType;
	}

	public void setPayloadType(String payloadType) {
		this.payloadType = payloadType;
	}

	public Clob getPayload() {
		return payload;
	}

	public void setPayload(Clob payload) {
		this.payload = payload;
	}

	public String getAuditStep() {
		return auditStep;
	}

	public void setAuditStep(String auditStep) {
		this.auditStep = auditStep;
	}

	public String getLoadStatus() {
		return loadStatus;
	}

	public void setLoadStatus(String loadStatus) {
		this.loadStatus = loadStatus;
	}

	public Date getLoadStartDateTime() {
		return loadStartDateTime;
	}

	public void setLoadStartDateTime(Date loadStartDateTime) {
		this.loadStartDateTime = loadStartDateTime;
	}

	public Date getLoadEndDateTime() {
		return loadEndDateTime;
	}

	public void setLoadEndDateTime(Date loadEndDateTime) {
		this.loadEndDateTime = loadEndDateTime;
	}

	public Date getLoadDuration() {
		return loadDuration;
	}

	public void setLoadDuration(Date loadDuration) {
		this.loadDuration = loadDuration;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
}
