package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hookst {

	@Before (order = 1)
	public void before()
	{
		System.out.println("This is the before scenario step 1111111");
	}
	
	@Before (order = 0)
	public void bef()
	{
		System.out.println("This is the GENERAL-before scenario step 000000");
	}

	@After (order = 0)
	public void after()
	{
		System.out.println("This is the after scenario step 000000");
	}
	
	@After (order = 1)
	public void aft()
	{
		System.out.println("This is the after scenario step 111111111");
	}
}
