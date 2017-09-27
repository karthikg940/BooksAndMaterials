package com.virtusa.sample.domain
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

import org.hibernate.validator.constraints.Length
@Entity
class Employee 
{
	@Id
	Long id;
	String empName;
	String project;
	String email;
	String designation;
}



