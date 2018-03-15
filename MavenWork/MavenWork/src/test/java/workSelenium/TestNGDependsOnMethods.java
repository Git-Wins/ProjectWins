package workSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNGDependsOnMethods 
{
	@Test (dependsOnMethods = {"two", "four"})
	public void three() 
	{
		System.out.println("method_Three");
	}

	@Test
	public void aaa() 
	{
		System.out.println("method_aaa");
	}
	
	@Test
	public void four() 
	{
		System.out.println("method_Four");
	}
	
	@Test (dependsOnMethods = {"aaa"})
	public void two() 
	{
		System.out.println("method_Two");
		//System.out.println(9/0);
	}
}
