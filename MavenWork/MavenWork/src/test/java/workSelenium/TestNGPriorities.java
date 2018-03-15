package workSelenium;

import org.testng.annotations.Test;

public class TestNGPriorities 
{

	@Test (priority = 1)
	public void one() 
	{
		System.out.println("one");
	}
	
	@Test (priority = 2)
	public void two() 
	{
		System.out.println("two");
	}
	
	@Test (priority = 3)
	public void three() 
	{
		System.out.println("three");
	}
	
	@Test (priority = 2)
	public void four() 
	{
		System.out.println("four");
	}
}
