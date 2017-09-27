package com.virtusa.sample.domain

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Project {

	@Id
	String projectName;
	Long managerId;
}
