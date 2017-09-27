package com.virtusa.training.startup.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.virtusa.training.startup.osgi.service.HelloWorld;
import com.virtusa.training.startup.osgi.service.impl.HelloWorldImpl;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Hello World!");
//        context.registerService(HelloWorld.class, new HelloWorldImpl(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Bye World!");
    }
}
