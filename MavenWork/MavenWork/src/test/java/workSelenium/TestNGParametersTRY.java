package workSelenium;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersTRY 
{
	private static WebDriver driver;
	
	@Test
	@Parameters({"aA", "bB"})
	public void parametersTry(String aA, String bB) throws WebDriverException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/SignUp?hl=en-GB");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("FirstName")).sendKeys(aA);
		driver.findElement(By.id("LastName")).sendKeys(bB);
		TakesScreenshot tsht = ((TakesScreenshot)driver);
		FileUtils.copyFile(tsht.getScreenshotAs(OutputType.FILE), new File("./snaps/Haha.jpg"));
		driver.quit();
	}
}
