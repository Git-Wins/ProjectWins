package workSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsWork {

	public static void main(String[] args) throws IOException, AWTException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/SignUp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement fName = driver.findElement(By.id("FirstName"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(fName).click().build().perform();
		/*fName.sendKeys("There");
		fName.sendKeys(Keys.BACK_SPACE);*/
		
		Robot gg = new Robot();
		gg.keyPress(KeyEvent.VK_6);
		
		//driver.quit();
		
	}
}
