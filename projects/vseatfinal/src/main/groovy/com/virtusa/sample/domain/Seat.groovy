package com.virtusa.sample.domain

import javax.persistence.*

import org.hibernate.validator.constraints.Length

@Entity
public class Seat implements Serializable
{
	@Id
	String seatName;
	Integer blockNo;	
	Integer floorNo;
	String status;
}

