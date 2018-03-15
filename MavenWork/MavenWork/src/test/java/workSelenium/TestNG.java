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

public class TestNG 
{
	WebDriver driver;

	@Test
	public void main() 
	{
		driver.findElement(By.id("FirstName")).sendKeys("Heyyy");
		driver.findElement(By.id("LastName")).sendKeys("Hulloooo");
	}

	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/SignUp?hl=en-GB");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() throws WebDriverException, IOException 
	{
		TakesScreenshot tt = ((TakesScreenshot)driver);
		FileUtils.copyFile(tt.getScreenshotAs(OutputType.FILE), new File("./snaps/googoo.jpg"));
		driver.quit();
	}
}
