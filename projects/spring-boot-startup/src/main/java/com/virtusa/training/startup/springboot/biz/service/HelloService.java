package com.virtusa.training.startup.springboot.biz.service;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.virtusa.training.startup.springboot.data.enity.HelloEntity;
import com.virtusa.training.startup.springboot.data.repository.HelloRepository;

/**
 * Hello Service.
 */
@Service
@Transactional
public class HelloService {

    @Inject
    private HelloRepository helloRepository;

    public HelloEntity sayHello(Long id) {
        return helloRepository.findOne(id);
    }
}
