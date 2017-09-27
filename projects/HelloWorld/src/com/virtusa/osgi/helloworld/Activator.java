package com.virtusa.osgi.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.virtusa.osgi.service.Impl.HelloWorldImpl;
import com.virtusa.osgi.service.interfaces.HelloWorld;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	 
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("hello");
		context.registerService(com.virtusa.osgi.service.interfaces.HelloWorld.class,new HelloWorldImpl(), null);
		ServiceReference<HelloWorld> ref=context.getServiceReference(HelloWorld.class);
		HelloWorld ref1=context.getService(ref);
		ref1.create();
	}

	 
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
