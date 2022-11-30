package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookClass {
	BaseClass baseClass;
	
	@Before
	public void intiateTheDriver() {
       baseClass = new BaseClass();	
       baseClass.setUpDriver();
	
	}
	
	@After
	public void closingTheDriver() {
		baseClass.closingTheDriverSession();
	}


}
