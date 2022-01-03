package StepsForHooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;

public class HooksSteps { // hooks are executed before and after each scenario
	
	// nnote order is reversed for After hooks
	
	@BeforeStep 
	public void beforeSteps() {
		System.out.println("beforeSteps triggers before every step");
	}

	@BeforeStep
	public void afterSteps() {
		System.out.println("afterSteps triggers after every step");
	}
	
	//ctr + d delete all

	WebDriver driver = null;
	
	@Before(order=1) // before Hook
	public void browserSetup() {
	System.out.println("Before Hook order 1");
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe"); // should use relative path Windows Version
	driver = new ChromeDriver();
	
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	
	
	@Before(order=0) // before Hook
	public void order0() {
		System.out.println("Before Hook order 0");
	}
	
	@Before(order=2) // before Hook
	public void order2() {
		System.out.println("Before Hook order 2");
	}
	
	@Before("@smoke") // before Hook
	public void smoke() {
		System.out.println("Before Hook - smoke tag only");
	}
	
	
	
	@After
	public void teardown() {
		System.out.println("After Hook");
		driver.close();
		driver.quit();
		
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
	}
	@And("clicks on login button")
	public void clicks_on_login_button() {
	}
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
	}


}
