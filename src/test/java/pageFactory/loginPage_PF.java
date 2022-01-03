package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage_PF {
	
	@FindBy(id = "name")
	@CacheLookup  //usefull for websites that dont change -- saved page to cache 
	WebElement txt_username;
	
	@FindBy(id = "password")
	WebElement txt_password;
	
	@FindBy(id = "login")
	WebElement btn_login;
	
	
	WebDriver driver;
	
	public loginPage_PF(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, loginPage_PF.class); // alternate method
		PageFactory.initElements(driver, this); // (this class)
		
	}
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickOnLogin() {
		btn_login.click();
	}
	
}
