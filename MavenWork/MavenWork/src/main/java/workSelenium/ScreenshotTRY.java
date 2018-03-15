package workSelenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenshotTRY {

	public static void main(String[] args) throws IOException {
		//Chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/*//Firefox
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();*/
		
		/*//Edge
		System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();*/
		
		driver.get("https://www.guru99.com/take-screenshot-selenium-webdriver.html");
		//driver.navigate().to("https://www.guru99.com/take-screenshot-selenium-webdriver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TakesScreenshot scrSht = ((TakesScreenshot)driver);
		File sShot = scrSht.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sShot, new File("./snaps/JJ.jpg"));
		driver.quit();
		/*WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.p)*/
	}
}
