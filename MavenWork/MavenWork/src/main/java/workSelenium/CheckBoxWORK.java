package workSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxWORK {

	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://testleaf.herokuapp.com/pages/checkbox.html");
		WebElement ff = driver.findElement(By.xpath("//input[@type='checkbox'][3]"));
		if(! ff.isSelected())
		{
			ff.click();
		}
		else {
			System.out.println("The WebElement is already selected");
		}
	}
}
