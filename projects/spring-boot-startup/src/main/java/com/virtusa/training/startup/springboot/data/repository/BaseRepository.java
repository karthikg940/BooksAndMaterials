package com.virtusa.training.startup.springboot.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.virtusa.training.startup.springboot.data.enity.BaseEntity;

/**
 * Base Repository for all other JPA based repositories.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {
}
