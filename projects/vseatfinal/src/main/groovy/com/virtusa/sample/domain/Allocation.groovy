package com.virtusa.sample.domainimport org.joda.time.DateTime;
import javax.persistence.Columnimport javax.persistence.Entityimport javax.persistence.GeneratedValue;import javax.persistence.GenerationType;import javax.persistence.Idimport javax.persistence.Tableimport org.hibernate.annotations.Typeimport org.hibernate.validator.constraints.Lengthimport org.joda.time.DateTime@Entity
class Allocation implements Serializable{
	@Id	@GeneratedValue(strategy = GenerationType.AUTO)	Long id;	Long empId;	String seatName;
		@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")	DateTime startDate;	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")	DateTime endDate;	String projectName;	}
