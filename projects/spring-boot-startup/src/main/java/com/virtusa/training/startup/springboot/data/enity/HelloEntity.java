package com.virtusa.training.startup.springboot.data.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hello entity.
 */
@Entity
@Table(name = "HELLO")
public class HelloEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "MESSAGE")
    private String message;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
