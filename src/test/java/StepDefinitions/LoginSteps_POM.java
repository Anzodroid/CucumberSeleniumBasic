package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.loginPage; // import constructor from pages.loginPage


public class LoginSteps_POM {
	WebDriver driver = null;
	loginPage login;

	@Given("browser is opened")
	public void browser_is_opened() {
		System.out.println("InsideStep - BroswerOpen");

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


	@When("^user enters (.*) and (.*)$") 
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		System.out.println("InsideStep - username and password");
		
		login = new loginPage(driver); // new instance of the login class
		login.enterUsername(username);
		login.enterPassword(password);
		
		//driver.findElement(By.id("name")).sendKeys(username);
		//driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);

	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		System.out.println("InsideStep - click login");
		
		login.clickLogin();
		//driver.findElement(By.id("login")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("InsideStep - home page");
		driver.findElement(By.id("logout")).isDisplayed();


		driver.close();
		driver.quit();

	}




}
