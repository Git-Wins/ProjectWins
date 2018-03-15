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

public class TestNGAnnotations {

	@Test
	public void testcaseB() {
		System.out.println("This is the Test Case 1111111111111111111");
	}

	@Test
	public void testcaseA() {
		System.out.println("This is the Test Case 222222222222222222");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod = This will execute before every Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod = This will execute after every Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass = This will execute before the Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass = This will execute after the Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest = This will execute before the Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest = This will execute after the Test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite = This will execute before the Test Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite = This will execute after the Test Suite");
	}
}