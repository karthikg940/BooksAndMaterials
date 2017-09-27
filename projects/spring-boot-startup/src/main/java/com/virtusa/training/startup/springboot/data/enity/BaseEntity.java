package com.virtusa.training.startup.springboot.data.enity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * Super class for all the domain classes.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract Long getId();

    public abstract void setId(Long id);

}
