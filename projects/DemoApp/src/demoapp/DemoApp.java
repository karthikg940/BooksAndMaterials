package demoapp;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class DemoApp implements BundleActivator {

	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		// TODO Auto-generated method stub
		DemoApp.context = bundleContext;
		System.out.println("second demo app started");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("second demo app stopped");
	}

}
