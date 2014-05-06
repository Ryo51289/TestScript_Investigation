package demo.junit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import demo.junit.Application;

public class TestApplication {
	Application app ;
	@Before
	public void prepare(){
		app = new Application();
	}
	@Test
	public void testSay1() {
		
		assertEquals("Function [say1] working",app.say1());
	}
	
	@Test
	public void testSay2() {
		assertEquals("Function [say2] working",app.say2());
	}

}
