package pax.test.demo.bundle;

import javax.inject.Inject;

import static org.junit.Assert.*;
import static org.ops4j.pax.exam.CoreOptions.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.junit.runner.JUnitCore;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedService;
import org.wiperdog.demo.bundle.service.TestService;

;
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class TestDemoBundle {
	public TestDemoBundle() {
	}

	@Inject
	private org.osgi.framework.BundleContext context;

	@Configuration
	public Option[] config() {

		return options(cleanCaches(true), frameworkStartLevel(6),
		// felix log level
				systemProperty("felix.log.level").value("4"), // 4 = DEBUG
				// setup properties for fileinstall bundle.
				systemProperty("felix.home").value(System.getProperty("user.dir")),
				// Pax-exam make this test code into OSGi bundle at runtime, so
				mavenBundle("org.wiperdog", "demo.bundle", "0.0.1-SNAPSHOT").startLevel(3), 
				junitBundles());
	}

	TestService testService;
	int a;
	int b;

	@Before
	public void prepare() {
		testService =  (TestService) context.getService(context.getServiceReference(TestService.class.getName()));
		a = 20;
		b = 10;
	}

	@After
	public void finish() {
		a = 0;
		b = 0;
	}

	@Test
	public void TestMultiple() {
		assertTrue(testService.multiple(a, b) == a*b);
	}
	@Test
	public void Testdivide() {
		assertTrue(testService.divide(a, b) == a/b);
	}
}
