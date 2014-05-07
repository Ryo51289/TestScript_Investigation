package demo.spock.test
import spock.lang.Ignore;
import spock.lang.Shared;
import spock.lang.Unroll;
import demo.spock.test.Dog;
import demo.spock.test.Duck;

class TestSpec extends spock.lang.Specification {

	def "Test number of legs of dog & duck"() {
		setup: "create dog and duck object"
		Dog dog = new Dog();
		Duck duck = new Duck();
		

		when: "set number of legs for dog & duck"
		dog.setLegs(4);
		duck.setLegs(3);
		
		then:
		dog.getLegs() == a
		duck.getLegs() == b
		
		where:
		a = 4
		b = 2
	}
	
}