package workSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {
	
	static String linkName, urlLink;

	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://testleaf.herokuapp.com/pages/Link.html");
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		System.out.println(totalLinks.size());
		
		for(WebElement lnk: totalLinks)
			
		{
			linkName = lnk.getText();
			urlLink = lnk.getAttribute("href");
			linkCheck(urlLink);
		}
		
		
		/*for(int i=0;i<totalLinks.size();i++)
		{
			linkName = totalLinks.get(i).getText();
			urlLink = totalLinks.get(i).getAttribute("href");
			linkCheck(urlLink);
		}*/
		driver.quit();
	}

	public static void linkCheck(String urlLink)
	{
		try {
			URL link = new URL(urlLink);
			HttpURLConnection conctn = (HttpURLConnection)(link.openConnection());
			conctn.setRequestMethod("HEAD");
			conctn.connect();
			if(conctn.getResponseCode() >= 400)
			{
				System.out.println("The link: " +linkName +" is invalid or broken");
			} else 
			{
				System.out.println("The link: " +linkName +" is Valid");
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
