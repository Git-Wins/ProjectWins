package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.Strings;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	
	@Given("^this is the Given-bg block$")
	public void this_is_the_Given_bg_block() throws Throwable {
	    System.out.println("BG-Given block");
	}

	@When("^this is the When-bg block$")
	public void this_is_the_When_bg_block() throws Throwable {
		System.out.println("BG-When block");
	}

	@Then("^this is the Then-bg block$")
	public void this_is_the_Then_bg_block() throws Throwable {
		System.out.println("BG-Then block");
	}
	
	@Given("^this is the first step$")
	public void this_is_the_first_step() throws Throwable {
	    System.out.println("1st Step");
	}

	@When("^this is the second step$")
	public void this_is_the_second_step() throws Throwable {
		System.out.println("2nd Step");
	}

	@Then("^this is the final-third step$")
	public void this_is_the_final_third_step() throws Throwable {
		System.out.println("3rd Step");
	}
	
	
	/*//////////////////////////////////////

	private static WebDriver driver = null;
	
	@Given("^User is on the Home Page$")
	public void user_is_on_the_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.store.demoqa.com");	}

	@When("^User navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();	
	}

		//Map Data tables to Class objects
	@When("^User enters Credentials to login$")
	public void user_enters_Credentials_to_login(List<Credentials> userCreds) throws Throwable {

		for(Credentials cred: userCreds)
		{
			driver.findElement(By.id("log")).sendKeys(cred.getUsername()); 
			driver.findElement(By.id("pwd")).sendKeys(cred.getPassword()); 
			driver.findElement(By.id("login")).click();
		}
	}

		//Data Table-MULTIPLE data(with Header)
	@When("^User enters Credentials to login$")
	public void user_enters_Credentials_to_login(DataTable userCreds) throws Throwable {

		for(Map<String,String> data : userCreds.asMaps(String.class, String.class))
		{
			driver.findElement(By.id("log")).sendKeys(data.get("username")); 
			driver.findElement(By.id("pwd")).sendKeys(data.get("password")); 
			driver.findElement(By.id("login")).click();
		}
	}

		//Data Table-SINGLE data(WITH Header)
	@When("^User enters Credentials to login$")
	public void user_enters_Credentials_to_login(DataTable userCreds) throws Throwable {

		List<Map<String,String>> data = userCreds.asMaps(String.class, String.class);
		driver.findElement(By.id("log")).sendKeys(data.get(0).get("username")); 
		driver.findElement(By.id("pwd")).sendKeys(data.get(0).get("password")); 
		driver.findElement(By.id("login")).click();
	}


		//Data Table-SINGLE data(without Header)
	@When("^User enters Credentials to login$")
	public void user_enters_Credentials_to_login(DataTable userCreds) throws Throwable {
		List<List<String>> data = userCreds.raw();
		driver.findElement(By.id("log")).sendKeys(data.get(0).get(0)); 
		driver.findElement(By.id("pwd")).sendKeys(data.get(0).get(1)); 
		driver.findElement(By.id("login")).click();
	}

	// With single data(without using Examples)/multiple data(using Examples)
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) throws Throwable {
		driver.findElement(By.id("log")).sendKeys(username); 
		driver.findElement(By.id("pwd")).sendKeys(password); 
		driver.findElement(By.id("login")).click();
	}

	@Then("^Message to be displayed that User has logged in successfully$")
	public void message_to_be_displayed_that_User_has_logged_in_successfully() throws Throwable {
		System.out.println("Logged in Successfully");
	}

	@When("^User Logs Out$")
	public void user_Logs_Out() throws Throwable {
		driver.findElement(By.id("account_logout")).click();
	}

	@Then("^Message to be displayed that User has logged out successfully$")
	public void message_to_be_displayed_that_User_has_logged_out_successfully() throws Throwable {
		System.out.println("Logged out Successfully");
	}

//////////////////////////////////////	
	 */
}
