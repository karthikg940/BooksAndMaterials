package com.virtusa.audit.eda.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="EDA_POC_LOAD_AUDIT")
public class LoadAuditEntity {
	@Id
	@Column(name = "AUDIT_ID")
	private int auditId;

	@Column(name = "SOURCE_PARTNER_ID")
	private int sourcePartnerId;

	@Column(name = "SOURCE_PARTNER_NAME")
	private String sourcePartnerName;

	@Column(name = "CAMEL_MSG_ID")
	private String camelMsgId;

	@Column(name = "PAYLOAD_TYPE")
	private String payloadType;

	@Column(name = "PAYLOAD")
	private String payload;

	@Column(name = "AUDIT_STEP")
	private String auditStep;

	@Column(name = "LOAD_STATUS")
	private String loadStatus;

	@Column(name = "LOAD_START_DATE_TIME")
	private Date loadStartDateTime;

	@Column(name = "LOAD_END_DATE_TIME")
	private Date loadEndDateTime;

	@Column(name = "LOAD_DURATION")
	private Date loadDuration;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "CREATE_TIMESTAMP")
	private Timestamp createTimestamp;

	public LoadAuditEntity() {
	}

	public LoadAuditEntity(int auditId, int sourcePartnerId,
			String sourcePartnerName, String camelMsgId, String payloadType,
			String payload, String auditStep, String loadStatus,
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

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
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

	@Override
	public String toString() {
		return "LoadAuditEntity [auditId=" + auditId + ", sourcePartnerId="
				+ sourcePartnerId + ", sourcePartnerName=" + sourcePartnerName
				+ ", camelMsgId=" + camelMsgId + ", payloadType=" + payloadType
				+ ", payload=" + payload + ", auditStep=" + auditStep
				+ ", loadStatus=" + loadStatus + ", loadStartDateTime="
				+ loadStartDateTime + ", loadEndDateTime=" + loadEndDateTime
				+ ", loadDuration=" + loadDuration + ", createBy=" + createBy
				+ ", createTimestamp=" + createTimestamp + "]";
	}

}
