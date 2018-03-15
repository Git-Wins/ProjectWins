package workSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.graphbuilder.struc.LinkedList;

public class BrokenLinksTestWork {

	static String linkName, urlLink;
	static Set<String> brknLnks = new HashSet<String>();

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
		if(brknLnks.size() > 0)
		{
			System.out.println("Total broken links on the page: " +brknLnks.size());
			if(brknLnks.size() == 1)
			{
				System.out.println("Broken link: " +brknLnks);	
			}else if(brknLnks.size() > 1)
			{
				System.out.println("The list of broken links: " +brknLnks);
			}
		}else
		{
			System.out.println("No broken links found on the page");
		}

		driver.quit();
	}

	public static void linkCheck(String urlLink)
	{
		try {
			URL lnk = new URL(urlLink);
			HttpURLConnection huc = (HttpURLConnection)(lnk.openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			if(huc.getResponseCode() >= 400)
			{
				brknLnks.add(linkName);
				//System.out.println("Invalid link: " +linkName);
			}else
			{
				//System.out.println("Valid link: " +linkName);
			}

		} catch (MalformedURLException e) {
			System.out.println("MalformedException");
		} catch (IOException e) {
			System.out.println("IOException");
		}

	}
}

