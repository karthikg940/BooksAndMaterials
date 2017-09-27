package com.virtusa.training.startup.osgi.service.impl;

import com.virtusa.training.startup.osgi.service.HelloWorld;

public class HelloWorldImpl implements HelloWorld {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
