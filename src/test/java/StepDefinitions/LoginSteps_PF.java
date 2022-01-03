package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageFactory.homePage_PF;
import pageFactory.loginPage_PF;


public class LoginSteps_PF {


	WebDriver driver = null;
	loginPage_PF login;
	homePage_PF home;

	@Given("browser is opened")
	public void browser_is_opened() {
		System.out.println("InsideStep - BroswerOpen");

		System.out.println("==== this is the right one ====n");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is :" +projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe"); // should use relative path Windows Version
		//System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/linux/chromedriver"); // should use relative path Linux Version
		//System.setProperty("webdriver.chrome.driver", "D:/Java/cucumberSelenium/src/test/resources/drivers/chromedriver.exe"); // should use relative path

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}


	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("InsideStep - login page");
		driver.navigate().to("https://example.testproject.io/web/");
	}

	//	@When("user enters username and password")
	//	public void user_enters_username_and_password() throws InterruptedException {
	//		System.out.println("InsideStep - username and password");
	//		driver.findElement(By.id("name")).sendKeys("anzo");
	//		driver.findElement(By.id("password")).sendKeys("12345");
	//		Thread.sleep(500);
	//		

	@When("^user enters (.*) and (.*)$") 
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		System.out.println("InsideStep - username and password");
		
		login = new loginPage_PF(driver);
		home = new homePage_PF(driver);
		
		login.enterUsername(username);
		login.enterPassword(password);
		
//		driver.findElement(By.id("name")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);

	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		System.out.println("InsideStep - entered username and password");

		login.clickOnLogin();
		//		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		System.out.println("InsideStep - home page");
		
		home.checkLogoutIsDisplayed();
		//driver.findElement(By.id("logout")).isDisplayed();

		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}




}