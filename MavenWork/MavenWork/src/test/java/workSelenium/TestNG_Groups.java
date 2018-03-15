package workSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_Groups {

	@Test (groups = { "Car" })
	public void Car1() 
	{
		System.out.println("Batch Car - Test car 1");
	}
	
	@Test (groups = {"Car"})
	public void Car3()
	{
		System.out.println("Batch Car - Test car 3");
	}

	@Test (groups = { "Car" })
	public void Car2() 
	{
		System.out.println("Batch Car - Test car 2");
	}

	@Test (groups = {"Van"})
	public void Van1()
	{
		System.out.println("Batch Car - Test van 1");
	}
	
	@Test (groups = { "Scooter" })
	public void Scooter1() 
	{
		System.out.println("Batch Scooter - Test scooter 1");
	}

	@Test (groups = { "Scooter" })
	public void Scooter2() 
	{
		System.out.println("Batch Scooter - Test scooter 2");
	}

	@Test (groups = { "Car", "Bus" })
	public void Sedan1() 
	{
		System.out.println("Batch Bus- Test Bus 1");
	}
}