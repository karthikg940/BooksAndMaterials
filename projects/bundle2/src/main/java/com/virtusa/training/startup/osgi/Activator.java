package com.virtusa.training.startup.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.virtusa.training.startup.osgi.service.HelloWorld;

public class Activator implements BundleActivator {
	Logger log = LoggerFactory.getLogger(Activator.class);

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println("start method");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		log.info("Bye World!");
	}

}
