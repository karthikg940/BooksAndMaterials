/*
 * Copyright 2016, Virtusa Corporation. All Rights Reserved.
 */

package com.virtusa.training.startup.springboot.web.rest.controller;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.training.startup.springboot.biz.service.HelloService;
import com.virtusa.training.startup.springboot.data.enity.HelloEntity;

/**
 * Hello controller.
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @Inject
    private HelloService helloService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<HelloEntity> getHello(@RequestParam Long id) {
        HelloEntity hello = helloService.sayHello(id);
        return ResponseEntity.ok(hello);
    }
}
