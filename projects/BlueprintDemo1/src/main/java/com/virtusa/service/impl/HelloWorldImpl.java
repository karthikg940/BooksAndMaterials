package com.virtusa.service.impl;
package com.virtusa.service;

public class HelloWorldImpl implements HelloWorld {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
