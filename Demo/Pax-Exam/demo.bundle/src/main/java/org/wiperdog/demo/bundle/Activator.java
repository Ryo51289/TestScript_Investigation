package org.wiperdog.demo.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wiperdog.demo.bundle.service.TestService;
import org.wiperdog.demo.bundle.service.impl.TestServiceImpl;

public class Activator implements BundleActivator{

	public void start(BundleContext context) throws Exception {
		context.registerService(TestService.class.getName(), new TestServiceImpl(),null);
		System.out.println("Demo bundle start successfully !");	
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Demo bundle stop successfully !");			
	}

}
