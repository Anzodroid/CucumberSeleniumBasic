package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

	protected WebDriver driver; // protected optional

	private By txt_username = By.id("name");

	private By txt_password = By.id("password");

	private By btn_login = By.id("login");
	
	private By btn_logout = By.id("logout");
	
	public loginPage(WebDriver driver) { // constructor of login page class
		this.driver = driver; // pass the driver object/ driver instance of the same session 
		System.out.println(driver.getTitle());
		
		if(!driver.getCurrentUrl().equals("https://example.testproject.io/web/")) {
		throw new IllegalStateException("This is not the login page. The current page is " +driver.getCurrentUrl());
		};
		
	}
	
	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}


	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	
	public void checkLogOutIsDesplayed() {
		driver.findElement(btn_logout).isDisplayed(); 
	}

	public void loginValidUser(String username, String password) {
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(password);
		driver.findElement(btn_login).click();

	}

}
