package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {

	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}

	public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;
	static String TxtGotToUseLater;
	static String stringtoTrimBIXP,stringtoTrimBIId;
	static String stringtoTrimBEIXP, stringtoTrimBEIId;

	public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will launch the browser in local machine and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Winston
	 * @param url - The url with http or https
	 * 
	 */
	public void invokeApp(String browser) {
		invokeApp(browser,false);
	}

	/**
	 * This method will launch the browser in grid node (if remote) and maximise the browser and set the
	 * wait for 30 seconds and load the url 
	 * @author Winston
	 * @param url - The url with http or https
	 * 
	 */
	public void invokeApp(String browser, boolean bRemote) {
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			// this is for grid run
			if(bRemote)
				driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
			else{ // this is for local run
				if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
				}else{
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();		
			reportStep("The browser:" + browser + " launched successfully", "PASS");

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
	}

	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Winston
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */

	public void enterById(String idValue, String data) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue)));
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+idValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+idValue, "FAIL");
		}
	}

	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param nameValue - name of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Winston
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public void enterByName(String nameValue, String data) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue)));
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+nameValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+nameValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+nameValue, "FAIL");
		}
	}

	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param classValue - Class Value of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Winston
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public void enterByClass(String classValue, String data) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(classValue)));
			driver.findElement(By.className(classValue)).clear();
			driver.findElement(By.className(classValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+classValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+classValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+classValue, "FAIL");
		}
	}

	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param xpathValue - xpathValue of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Winston
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public void enterByXpath(String xpathValue, String data) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+xpathValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+xpathValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+xpathValue, "FAIL");
		}
	}

	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Winston
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}else
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");

		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will verify the title of the browser whether it just contains the input
	 * @param title - The expected title of the browser
	 * @author Winston
	 */
	public boolean verifyTitleContains(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().contains(title)){
				reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}else
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");

		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will verify the given text matches in the element text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Winston
	 */
	public void verifyTextByXpath(String xpath, String text){
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.equalsIgnoreCase(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Winston
	 */
	public void verifyTextContainsByXpath(String xpath, String text){
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * @param id - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Winston
	 */
	public void verifyTextById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * @param id - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Winston
	 */
	public void verifyTextContainsById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.contains(text)){
				System.out.println("The text: "+sText+" matches with the value :"+text);
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				System.out.println("The text: "+sText+" did not match with the value :"+text);
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}



	/**
	 * This method will close all the browsers
	 * @author Winston
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			reportStep("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.", "FAIL");
		}
	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickById(String id) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(id))));
			driver.findElement(By.id(id)).click();
			reportStep("The element with id: "+id+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
	}

	//to click by id, without taking a snap
	public void clickByIdNoSnap(String id) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(id))));
			driver.findElement(By.id(id)).click();
		} catch (Exception e) {
			System.out.println("Unknown exception!");
		}
	}

	/**
	 * This method will click the element using id as locator
	 * @param classVal  The Class value (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByClassName(String classVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className(classVal))));
			driver.findElement(By.className(classVal)).click();
			reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByName(String name) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(name))));
			driver.findElement(By.name(name)).click();
			reportStep("The element with name: "+name+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using link name as locator
	 * @param linkVal  The link value (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByLink(String linkVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(linkVal))));
			driver.findElement(By.linkText(linkVal)).click();
			reportStep("The element with link name: "+linkVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with link name: "+linkVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using partial-link name as locator
	 * @param partLinkVal  The partial-link value (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByPartialLink(String partLinkVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(partLinkVal))));
			driver.findElement(By.linkText(partLinkVal)).click();
			reportStep("The element with link name: "+partLinkVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with link name: "+partLinkVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using link name as locator, but without taking a Snap
	 * @param linkVal  The link value (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByLinkNoSnap(String linkVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(linkVal))));
			driver.findElement(By.linkText(linkVal)).click();
		} catch (Exception e) {
			reportStep("The element with link name: "+linkVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByXpath(String xpathVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpathVal))));
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using xpath as locator, but without taking a Snap
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Winston
	 */
	public void clickByXpathNoSnap(String xpathVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpathVal))));
			driver.findElement(By.xpath(xpathVal)).click();
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will mouse over on the element using id as locator
	 * @param idVal  The id (locator) of the element to be moused over
	 * @author Winston
	 */
	public void mouseOverById(String idVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.id(idVal))).build().perform();
			reportStep("The mouse over by xpath : "+idVal+" is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by xpath : "+idVal+" could not be performed.", "FAIL");
		}
	}

	/**
	 * This method will mouse over on the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be moused over
	 * @author Winston
	 */
	public void mouseOverByXpath(String xpathVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
	}

	/**
	 * This method will get the text of the element, to be use later at a different step, using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element
	 * @author Winston
	 */
	public String getTextToUseLater(String xpathVal){
		try{
			TxtGotToUseLater = driver.findElement(By.xpath(xpathVal)).getText();
			System.out.println(TxtGotToUseLater);
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return TxtGotToUseLater; 
	}

	/**
	 * This method will enter the text fetched earlier using the method:, using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element
	 * @author Winston
	 */
	public void enterTextFetchedEarlier(String xpathVal){
		try{
			driver.findElement(By.xpath(xpathVal)).clear();
			driver.findElement(By.xpath(xpathVal)).sendKeys(TxtGotToUseLater);	
			reportStep("The data: "+TxtGotToUseLater+" entered successfully in field :"+xpathVal, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data: "+TxtGotToUseLater+" could not be entered in the field :"+xpathVal, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering "+TxtGotToUseLater+" in the field :"+xpathVal, "FAIL");
		}
	}

	/**
	 * This method will return the text of the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element
	 * @author Winston
	 */
	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathVal)));
			System.out.println(driver.findElement(By.xpath(xpathVal)).getText());
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	/**
	 * This method will return the text of the element using id as locator
	 * @param xpathVal  The id (locator) of the element
	 * @author Winston
	 */
	public String getTextById(String idVal) {
		String bReturn = "";
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idVal)));
			System.out.println(driver.findElement(By.id(idVal)).getText());
			return driver.findElement(By.id(idVal)).getText();
		} catch (Exception e) {
			reportStep("The element with id: "+idVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	//to switch to the parent window
	public void switchToParentWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) 
			{
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window", "FAIL");
		}
	}

	//to switch to the last-active window
	public void switchToLastWindow(String windowTitle) {
		try {
			Set<String> winHandles1 = driver.getWindowHandles();
			for (String wHandle : winHandles1) 
			{
				driver.switchTo().window(wHandle);
				if(driver.getTitle().contains(windowTitle))
				{
					System.out.println("Switched to the target window with title: "+windowTitle);
					break;
				}
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window", "FAIL");
		}
	}

	//To switch to a specific frame
	public void switchToFrame(String locValue)
	{
		try {
			WebElement frame= driver.findElement(By.id(locValue));
			driver.switchTo().frame(frame);
			System.out.println("Frame-switch SUCCESSFUL");
			reportStep("Frame-switch SUCCESSFUL", "PASS");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+locValue, "FAIL");
		}
	}

	//To switch to the default frame
	public void switchToDefaultcontent(){
		try {
			driver.switchTo().defaultContent();
			System.out.println("Frame-switch SUCCESSFUL");
			reportStep("Default Frame-switch SUCCESSFUL", "PASS");
		} catch (Exception e) {
			reportStep("Unknown exception occured", "FAIL");
		}
	}

	//To take a snap
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.", "FAIL");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return number;
	}

	//To substring a String by providing the Begin index alone-using xPath as locator
	public String subStringBegIndexXpath(String xpathVal, int begIndex){
		try {
			stringtoTrimBIXP=getTextByXpath(xpathVal);
			System.out.println(stringtoTrimBIXP.substring(begIndex));
			reportStep("String has been successfully trimmed", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
		return stringtoTrimBIXP.substring(begIndex);
	}

	//To substring a String by providing the Begin index alone-using Id as locator
	public String subStringBegIndexId(String idVal, int begIndex){
		try {
			stringtoTrimBIId=getTextById(idVal);
			System.out.println(stringtoTrimBIId.substring(begIndex));
			reportStep("String has been successfully trimmed", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The element: "+idVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+idVal, "FAIL");
		}
		return stringtoTrimBIId.substring(begIndex);
	}

	//To substring a String by providing BOTH the Begin & End indexes-using xPath as locator
	public String subStringBegEndIndexesXpath(String xpathVal, int begIndex, int endIndex){
		try {
			stringtoTrimBEIXP=getTextByXpath(xpathVal);
			System.out.println(stringtoTrimBEIXP.substring(begIndex, endIndex));
			reportStep("String has been successfully trimmed", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
		return stringtoTrimBEIXP.substring(begIndex, endIndex);
	}

	//To substring a String by providing BOTH the Begin & End indexes-using Id as locator
	public String subStringBegEndIndexesId(String idVal, int begIndex, int endIndex){
		try {
			stringtoTrimBEIId=getTextById(idVal);
			System.out.println(stringtoTrimBEIId.substring(begIndex, endIndex));
			reportStep("String has been successfully trimmed", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The element: "+idVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+idVal, "FAIL");
		}
		return stringtoTrimBEIId.substring(begIndex, endIndex);
	}
}


