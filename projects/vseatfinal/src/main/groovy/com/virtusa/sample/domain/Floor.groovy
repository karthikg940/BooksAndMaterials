package com.virtusa.sample.domain

import javax.persistence.Entity;
import javax.persistence.Id

@Entity
class Floor 
{
	@Id
	Integer id;
    Integer blockNo;
}
