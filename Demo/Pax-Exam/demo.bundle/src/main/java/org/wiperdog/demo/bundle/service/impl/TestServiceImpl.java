package org.wiperdog.demo.bundle.service.impl;

import org.wiperdog.demo.bundle.service.TestService;

public class TestServiceImpl implements TestService{
	public double multiple(int a,int b){
		return a*b;
	}

	public double divide(int a, int b) {
		return a/b;
	}
}
